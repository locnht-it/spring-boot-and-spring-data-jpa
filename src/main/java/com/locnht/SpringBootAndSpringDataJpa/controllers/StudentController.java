package com.locnht.SpringBootAndSpringDataJpa.controllers;

import com.locnht.SpringBootAndSpringDataJpa.dto.StudentDto;
import com.locnht.SpringBootAndSpringDataJpa.dto.StudentResponseDto;
import com.locnht.SpringBootAndSpringDataJpa.models.Order;
import com.locnht.SpringBootAndSpringDataJpa.models.OrderRecord;
import com.locnht.SpringBootAndSpringDataJpa.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from my first controller";
    }

//    @GetMapping("/hello-2")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public String sayHello2() {
//        return "Hello 2 from my first controller";
//    }

    @PostMapping("/post")
    public String post(@RequestBody String message) {
        return "Request accepted and message is: " + message;
    }

    @PostMapping("/post-order")
    public String post(@RequestBody Order order) {
        return "Request accepted and order is: " + order.toString();
    }

    @PostMapping("/post-order-record")
    public String postRecord(@RequestBody OrderRecord order) {
        return "Request accepted and order record is: " + order.toString();
    }

    // http://localhost:8080/hello/tanloc
    @GetMapping("/hello/{user-name}")
    public String pathVar(@PathVariable("user-name") String userName) {
        return "my value = " + userName;
    }

    // http://localhost:8080/hello?param_name=paramValue&oaram_name_2=value_2
    @GetMapping("/hello2")
    public String pathVar2(
            @RequestParam("user-name") String userName,
            @RequestParam("user-lastname") String userLastname
    ) {
        return "my value = " + userName + "   " + userLastname;
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(@Valid @RequestBody StudentDto dto) {
        return studentService.saveStudent(dto);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDto findStudentById(@PathVariable("student-id") Integer id) {
        return studentService.findStudentById(id);
    }

    @GetMapping("/students/search/{student-id}")
    public List<StudentResponseDto> findStudentByName(@PathVariable("student-id") String name) {
        return studentService.findStudentByName(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("student-id") Integer id) {
        studentService.delete(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ) {
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
