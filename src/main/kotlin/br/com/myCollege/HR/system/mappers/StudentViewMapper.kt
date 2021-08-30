package br.com.myCollege.HR.system.mappers

import br.com.myCollege.HR.system.dto.StudentView
import br.com.myCollege.HR.system.model.Student
import org.springframework.stereotype.Component

@Component
class StudentViewMapper:Mapper<Student, StudentView> {

    override fun map(t: Student): StudentView {
        return StudentView(
            id = t.id,
            name = t.name,
            course = t.course,
            status = t.status
        )
    }

}
