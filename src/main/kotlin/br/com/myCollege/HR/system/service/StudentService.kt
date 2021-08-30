package br.com.myCollege.HR.system.service

import br.com.myCollege.HR.system.dto.StudentForm
import br.com.myCollege.HR.system.dto.StudentView
import br.com.myCollege.HR.system.dto.UpdateStudentForm
import br.com.myCollege.HR.system.exception.NotFoundException
import br.com.myCollege.HR.system.mappers.StudentFormMapper
import br.com.myCollege.HR.system.mappers.StudentViewMapper
import br.com.myCollege.HR.system.repository.StudentRepository
import org.aspectj.weaver.ast.Not
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class StudentService(
    private var student: StudentRepository,
    private val studentViewMapper: StudentViewMapper,
    private val studentFormMapper: StudentFormMapper,
    private val notFoundMessage: String = "Student not found"
) {

    fun listAll(page: Pageable):Page<StudentView>{
        val studentRepository = student.findAll(page)

        return studentRepository.map{
            t -> studentViewMapper.map(t)
        }
    }

    fun listByCourse(nameCourse: String?, page: Pageable): Page<StudentView> {
        val studentRepositoryByCourse = if(nameCourse == null){
            student.findAll(page)
        } else {
            student.findByCourseName(nameCourse,page)
        }

        return studentRepositoryByCourse.map{
            t -> studentViewMapper.map(t)
        }
    }

    fun searchStudentById(id: Long): StudentView {
        val studentId = student.findById(id).orElseThrow{NotFoundException(notFoundMessage)}

        return studentViewMapper.map(studentId)
    }

    fun register(studentRegistration: StudentForm): StudentView {
        val students = studentFormMapper.map(studentRegistration)
        student.save(students)
        return studentViewMapper.map(students)
    }

    fun updateStudentInfo(studentUpdate: UpdateStudentForm): StudentView {
        val searchStudentId = student.findById(studentUpdate.id).orElseThrow { NotFoundException(notFoundMessage) }

        searchStudentId.age = studentUpdate.age
        searchStudentId.status = studentUpdate.status

        return studentViewMapper.map(searchStudentId)
    }

    fun deleteStudent(id: Long) {
        student.deleteById(id)
    }

}
