package com.locnht.SpringBootAndSpringDataJpa.services;

import com.locnht.SpringBootAndSpringDataJpa.dto.StudentDto;
import com.locnht.SpringBootAndSpringDataJpa.dto.StudentResponseDto;
import com.locnht.SpringBootAndSpringDataJpa.mappers.StudentMapper;
import com.locnht.SpringBootAndSpringDataJpa.models.Student;
import com.locnht.SpringBootAndSpringDataJpa.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    // which service we want to test
    @InjectMocks
    private StudentService studentService;

    // declare the dependencies
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_save_a_student() {
        // Given
        StudentDto dto = new StudentDto(
            "Loc",
            "Ngo",
            "locnht1@gmail.com",
            1
        );
        Student student = new Student(
            "Loc",
            "Ngo",
            "locnht1@gmail.com",
            20
        );
        Student savedStudent = new Student(
                "Loc",
                "Ngo",
                "locnht1@gmail.com",
                20
        );

        // Mock the calls
        when(studentMapper.toStudent(dto))
                .thenReturn(student);
        when(studentRepository.save(student))
                .thenReturn(savedStudent);
        when(studentMapper.toStudentResponseDto(savedStudent))
                .thenReturn(new StudentResponseDto(
                        "Loc",
                        "Ngo",
                        "locnht1@gmail.com"
                ));

        // When
        StudentResponseDto responseDto = studentService.saveStudent(dto);

        // Then
        assertEquals(dto.firstname(), responseDto.firstname());
        assertEquals(dto.lastname(), responseDto.lastname());
        assertEquals(dto.email(), responseDto.email());

        verify(studentMapper, times(1))
                .toStudent(dto);
        verify(studentRepository, times(1))
                .save(student);
        verify(studentMapper, times(1))
                .toStudentResponseDto(savedStudent);
    }

    @Test
    public void should_return_all_students() {
        // Given
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                "Loc",
                "Ngo",
                "locnht1@gmail.com",
                20
        ));

        // Mock the calls
        when(studentRepository.findAll()).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "Loc",
                        "Ngo",
                        "locnht1@gmail.com"
                ));

        // When
        List<StudentResponseDto> responseDtos = studentService.findAllStudents();

        // Then
        assertEquals(students.size(), responseDtos.size());
        verify(studentRepository, times(1))
                .findAll();
    }

    @Test
    public void should_return_student_by_id() {
        // Given
        Integer studentId = 1;
        Student student = new Student(
                "Loc",
                "Ngo",
                "locnht1@gmail.com",
                20
        );

        // Mock the calls
        when(studentRepository.findById(studentId))
                .thenReturn(Optional.of(student));
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "Loc",
                        "Ngo",
                        "locnht1@gmail.com"
                ));

        // When
        StudentResponseDto dto = studentService.findStudentById(studentId);

        // Then
        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());

        verify(studentRepository, times(1))
                .findById(studentId);
    }

    @Test
    public void should_find_student_by_name() {
        // Given
        String studentName = "Loc";
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                "Loc",
                "Ngo",
                "locnht1@gmail.com",
                20
        ));

        // Mock the calls
        when(studentRepository.findAllByFirstnameContaining(studentName))
                .thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "Loc",
                        "Ngo",
                        "locnht1@gmail.com"
                ));

        // When
        var responseDto = studentService.findStudentByName(studentName);

        // Then
        assertEquals(students.size(), responseDto.size());

        verify(studentRepository, times(1))
                .findAllByFirstnameContaining(studentName);
    }
}