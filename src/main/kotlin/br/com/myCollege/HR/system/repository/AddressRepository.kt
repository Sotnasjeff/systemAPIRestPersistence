package br.com.myCollege.HR.system.repository

import br.com.myCollege.HR.system.model.Address
import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository : JpaRepository<Address, Long> {
}