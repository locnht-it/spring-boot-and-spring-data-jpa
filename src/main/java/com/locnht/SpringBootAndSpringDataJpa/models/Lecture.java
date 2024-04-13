package com.locnht.SpringBootAndSpringDataJpa.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Lecture extends BaseEntity{

//    @Id
//    @GeneratedValue
//    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "section_id")
    @JsonBackReference
    private Section section;

    @OneToOne(mappedBy = "lecture")
    private Resource resource;
}
