package br.com.myCollege.HR.system.controller

import br.com.myCollege.HR.system.service.ProfessorService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/professor")
class ProfessorController (private val professor: ProfessorService) {




}