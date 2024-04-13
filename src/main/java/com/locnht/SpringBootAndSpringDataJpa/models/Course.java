package com.locnht.SpringBootAndSpringDataJpa.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Course extends BaseEntity{

//    @Id
//    @GeneratedValue
//    private Integer id;

    private String name;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "authors_courses",
            joinColumns = {
                    @JoinColumn(name = "course_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }
    )
    private List<Author> authors;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Section> sections;
}
