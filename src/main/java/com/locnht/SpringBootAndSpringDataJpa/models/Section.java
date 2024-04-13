package com.locnht.SpringBootAndSpringDataJpa.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Section extends BaseEntity{

//    @Id
//    @GeneratedValue
//    private Integer id;

    private String name;

    private int sectionOrder;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonBackReference
    private Course course;

    @OneToMany(mappedBy = "section")
    @JsonManagedReference
    private List<Lecture> lectures;
}
