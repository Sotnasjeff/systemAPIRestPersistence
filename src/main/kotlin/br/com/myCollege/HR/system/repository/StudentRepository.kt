package br.com.myCollege.HR.system.repository

import br.com.myCollege.HR.system.model.Student
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository


interface StudentRepository:JpaRepository<Student, Long> {

    fun findByCourseName(nameCourse:String, page:Pageable) : Page<Student>

}