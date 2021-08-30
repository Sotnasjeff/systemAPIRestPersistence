package br.com.myCollege.HR.system.mappers

import br.com.myCollege.HR.system.dto.StudentForm
import br.com.myCollege.HR.system.model.Student
import br.com.myCollege.HR.system.service.AddressService
import br.com.myCollege.HR.system.service.CourseService
import org.springframework.stereotype.Component

@Component
class StudentFormMapper(
    private val courseService: CourseService,
    private val addressService: AddressService
):Mapper<StudentForm,Student> {

    override fun map(t: StudentForm): Student {
        return Student(
            name = t.name,
            age = t.age,
            cpf = t.cpf,
            course = courseService.searchById(t.idCourse),
            address = addressService.searchById(t.idAddress)
        )
    }
}