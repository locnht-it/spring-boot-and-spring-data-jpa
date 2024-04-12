package com.locnht.SpringBootAndSpringDataJpa.mappers;

import com.locnht.SpringBootAndSpringDataJpa.dto.StudentDto;
import com.locnht.SpringBootAndSpringDataJpa.dto.StudentResponseDto;
import com.locnht.SpringBootAndSpringDataJpa.models.School;
import com.locnht.SpringBootAndSpringDataJpa.models.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public Student toStudent(StudentDto dto) {
        if(dto == null) {
            throw new NullPointerException("The student Dto is null");
        }
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;
    }

    public StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail());
    }
}
