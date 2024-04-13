package com.locnht.SpringBootAndSpringDataJpa.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "resource_type") --> only with SINGLE_TABLE
//@Inheritance(strategy = InheritanceType.JOINED) // Parent table has only all fields of it, and child table has only all fields of it + id
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // Parent table has ony all fields of it, but child table has all fields of it + all fields of parent
@Polymorphism(type = PolymorphismType.EXPLICIT)
public class Resource {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private int size;

    private String url;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
