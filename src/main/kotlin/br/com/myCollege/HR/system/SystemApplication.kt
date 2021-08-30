package br.com.myCollege.HR.system

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.Cacheable

@Cacheable
@SpringBootApplication
class SystemApplication

fun main(args: Array<String>) {
	runApplication<SystemApplication>(*args)
}
