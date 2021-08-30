package br.com.myCollege.HR.system.repository

import br.com.myCollege.HR.system.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository:JpaRepository<Course,Long> {
}