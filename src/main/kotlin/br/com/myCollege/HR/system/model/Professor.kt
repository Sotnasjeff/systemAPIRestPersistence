package br.com.myCollege.HR.system.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Professor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val age: Int,
    val cpf: String,
    val wage: Double,
    val address: Address,
    val course: Course,
    val title: Title
)