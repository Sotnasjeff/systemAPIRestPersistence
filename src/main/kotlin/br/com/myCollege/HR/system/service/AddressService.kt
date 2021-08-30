package br.com.myCollege.HR.system.service

import br.com.myCollege.HR.system.model.Address
import br.com.myCollege.HR.system.repository.AddressRepository
import org.springframework.stereotype.Service

@Service
class AddressService(private val addressRepository: AddressRepository) {

    fun searchById(id: Long): Address{
        return addressRepository.getById(id)
    }

}