package com.locnht.SpringBootAndSpringDataJpa.repositories;

import com.locnht.SpringBootAndSpringDataJpa.models.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
