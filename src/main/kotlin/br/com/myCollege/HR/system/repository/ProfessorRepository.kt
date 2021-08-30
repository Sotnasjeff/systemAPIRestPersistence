package br.com.myCollege.HR.system.repository

import br.com.myCollege.HR.system.model.Professor
import org.springframework.data.jpa.repository.JpaRepository

interface ProfessorRepository:JpaRepository<Professor,Long> {


}