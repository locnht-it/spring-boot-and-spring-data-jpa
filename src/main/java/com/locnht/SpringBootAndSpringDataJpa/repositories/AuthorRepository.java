package com.locnht.SpringBootAndSpringDataJpa.repositories;

import com.locnht.SpringBootAndSpringDataJpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {

    @Transactional
    List<Author> findByNamedQuery(@Param("age") int age);

    @Transactional
    @Modifying
    void updateByNamedQuery(@Param("age") int age);

    //UPDATE Author a SET a.age = 22 WHERE a.id = 1
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    void updateAllAuthorsAges(int age);

    // SELECT * FROM author WHERE first_name = 'loc'
    List<Author> findAllByFirstname(String fn);

    // SELECT * FROM author WHERE first_name = 'Loc'
    List<Author> findAllByFirstnameIgnoreCase(String fn);

    // SELECT * FROM author WHERE first_name LIKE '%Loc%'
    List<Author> findAllByFirstnameContainingIgnoreCase(String fn);

    // SELECT * FROM author WHERE first_name LIKE 'Loc%'
    List<Author> findAllByFirstnameStartsWithIgnoreCase(String fn);

    // SELECT * FROM author WHERE first_name LIKE '%Loc'
    List<Author> findAllByFirstnameEndsWithIgnoreCase(String fn);

    // SELECT * FROM author WHERE first_name IN ('loc', 'toan', 'phu')
    List<Author> findAllByFirstnameInIgnoreCase(List<String> firstnames);
}
