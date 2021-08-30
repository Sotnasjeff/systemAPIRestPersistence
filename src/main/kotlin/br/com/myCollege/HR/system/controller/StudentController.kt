package br.com.myCollege.HR.system.controller

import br.com.myCollege.HR.system.dto.StudentForm
import br.com.myCollege.HR.system.dto.StudentView
import br.com.myCollege.HR.system.dto.UpdateStudentForm
import br.com.myCollege.HR.system.service.StudentService
import javax.transaction.Transactional
import javax.validation.Valid
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/student")
class StudentController (private val student: StudentService) {

    @GetMapping("/all")
    @Cacheable("student")
    fun listAllStudent(
        @PageableDefault(size = 5, sort = ["name"], direction = Sort.Direction.DESC) page: Pageable
    ) : Page<StudentView>{
        return student.listAll(page)
    }

    @GetMapping("/course")
    @Cacheable("student")
    fun listStudentByCourse(
        @RequestParam(required = false) nameCourse: String?,
        @PageableDefault(size = 5, sort = ["course"], direction = Sort.Direction.DESC) page: Pageable
    ): Page<StudentView>{
        return student.listByCourse(nameCourse,page)
    }

    @GetMapping("/{id}")
    fun searchStudentById(@PathVariable id: Long): StudentView{
        return student.searchStudentById(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict("student", allEntries = true)
    fun registerStudent(
        @RequestBody @Valid studentRegistration : StudentForm,
        uriBuilder: UriComponentsBuilder
    ) : ResponseEntity<StudentView>{
        val studentView = student.register(studentRegistration)
        val uri = uriBuilder.path("/student/${studentView.id}").build().toUri()
        return ResponseEntity.created(uri).body(studentView)
    }

    @PutMapping
    @Transactional
    @CacheEvict("student", allEntries = true)
    fun updateStudentInfo(@RequestBody @Valid studentUpdate:UpdateStudentForm): ResponseEntity<StudentView>{
        val studentView = student.updateStudentInfo(studentUpdate)
        return ResponseEntity.ok(studentView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    @CacheEvict("student", allEntries = true)
    fun deleteStudent(@PathVariable id: Long){
        student.deleteStudent(id)
    }

}