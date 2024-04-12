package com.locnht.SpringBootAndSpringDataJpa.repositories;

import com.locnht.SpringBootAndSpringDataJpa.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByFirstnameContaining(String firstname);
}
