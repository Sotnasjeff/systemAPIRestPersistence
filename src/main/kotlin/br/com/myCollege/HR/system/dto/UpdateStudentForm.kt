package br.com.myCollege.HR.system.dto

import br.com.myCollege.HR.system.model.Status
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class UpdateStudentForm(
    @field:NotNull val id: Long,
    @field:NotNull @field:NotEmpty val age: Int,
    @field:NotNull @field:NotEmpty val status: Status,

)