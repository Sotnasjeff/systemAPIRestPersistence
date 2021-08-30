package br.com.myCollege.HR.system.service

import br.com.myCollege.HR.system.model.Course
import br.com.myCollege.HR.system.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private val courses: CourseRepository) {

    fun searchById(id: Long): Course{
        return courses.getById(id)
    }

}