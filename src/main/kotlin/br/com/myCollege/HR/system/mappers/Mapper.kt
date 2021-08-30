package br.com.myCollege.HR.system.mappers

interface Mapper<T, U> {

    fun map(t: T): U

}