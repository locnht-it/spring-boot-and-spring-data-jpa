package com.locnht.SpringBootAndSpringDataJpa.mappers;

import com.locnht.SpringBootAndSpringDataJpa.dto.StudentDto;
import com.locnht.SpringBootAndSpringDataJpa.dto.StudentResponseDto;
import com.locnht.SpringBootAndSpringDataJpa.models.Student;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
//    //only once
//    @BeforeAll
//    static void beforeAll() {
//        System.out.println("Inside the before all method");
//    }
//
//    @AfterAll
//    static void afterAll() {
//        System.out.println("Inside the after all method");
//    }
//
//    @BeforeEach
//    void setUp() {
//        System.out.println("Inside the before each method");
//    }
//
//    @AfterEach
//    void tearDown() {
//        System.out.println("Inside the after each method");
//    }

    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDto dto = new StudentDto(
            "Loc",
            "Ngo",
            "locnht1@gmail.com",
            1
        );

        Student student = studentMapper.toStudent(dto);

        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null() {
        var exp = assertThrows(NullPointerException.class, () -> studentMapper.toStudent(null));
        assertEquals("The student Dto is null", exp.getMessage());
    }

    @Test
    public void shouldMapStudentToStudentResponseDto() {
        //Given
        Student student = new Student(
                "Loc",
                "Ngo",
                "locnht1@gmail.com",
                20
        );

        //When
        StudentResponseDto response = studentMapper.toStudentResponseDto(student);

        //Then
        assertEquals(response.firstname(), student.getFirstname());
        assertEquals(response.lastname(), student.getLastname());
        assertEquals(response.email(), student.getEmail());
    }
}