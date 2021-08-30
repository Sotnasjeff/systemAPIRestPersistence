package br.com.myCollege.HR.system.model

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
data class Student (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    var age: Int,
    val cpf: String,
    @OneToOne
    val address: Address,
    @OneToOne
    val course: Course,
    @Enumerated(value = EnumType.STRING)
    var status: Status = Status.ON_COURSE
)