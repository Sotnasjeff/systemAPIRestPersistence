package br.com.myCollege.HR.system.dto

import br.com.myCollege.HR.system.model.Course
import br.com.myCollege.HR.system.model.Status

data class StudentView(
    val id: Long? = null,
    val name: String,
    val course: Course,
    val status: Status
)
