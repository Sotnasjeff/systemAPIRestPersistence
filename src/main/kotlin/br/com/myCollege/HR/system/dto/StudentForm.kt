package br.com.myCollege.HR.system.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class StudentForm(
    @field:NotEmpty @field:Size(min = 2, max = 100) val name: String,
    @field: NotEmpty @field:NotNull val age: Int,
    @field: NotEmpty @field:NotNull val cpf: String,
    @field: NotNull val idCourse: Long,
    @field: NotNull val idAddress: Long,
)