package br.com.myCollege.HR.system.exception

import java.lang.RuntimeException

class NotFoundException(message: String?) : RuntimeException(message)