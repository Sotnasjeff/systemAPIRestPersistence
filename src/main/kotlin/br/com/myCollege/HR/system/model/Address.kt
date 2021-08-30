package br.com.myCollege.HR.system.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Address(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val street: String,
    val houseNumber: Long,
    val neighborhood: String,
    val city: String,
    val state: String,
    val country: String,
)
