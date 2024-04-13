package com.locnht.SpringBootAndSpringDataJpa.models;

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
@NamedQueries(
        {
                @NamedQuery(
                        name = "Author.findByNamedQuery",
                        query = "select a from Author a where a.age >= :age"
                ),
                @NamedQuery(
                        name = "Author.updateByNamedQuery",
                        query = "update Author a set a.age = :age"
                )
        }
)
//@NamedQuery(
//        name = "Author.findByNamedQuery",
//        query = "select a from Author a where a.age >= :age"
//)
//@NamedQuery(
//        name = "Author.updateByNamedQuery",
//        query = "update Author a set a.age = :age"
//)
//@Table(name = "AUTHOR_TBL")
public class Author extends BaseEntity{

    // default: GenerationType.AUTO
//    @Id
//    @GeneratedValue
//    // strategy = GenerationType.SEQUENCE
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "author_sequence"
//    )
//    @SequenceGenerator(
//            name = "author_sequence",
//            sequenceName = "author_sequence",
//            allocationSize = 1
//    )
//    // strategy = GenerationType.TABLE
//    @GeneratedValue(
//            strategy = GenerationType.TABLE,
//            generator = "author_id_gen"
//    )
//    @TableGenerator(
//            name = "author_id_gen",
//            table = "id_generator",
//            pkColumnName = "id_name",
//            valueColumnName = "id_value",
//            allocationSize = 1
//    )
//    private Integer id;

    @Column(
            name = "f_name",
            length = 35
    )
    private String firstname;

    private String lastname;

    @Column(
            unique = true,
            nullable = false
    )
    private String email;

    private int age;

//    @Column(
//            updatable = false,
//            nullable = false
//    )
//    private LocalDateTime createdAt;
//
//    @Column(
//            insertable = false
//    )
//    private LocalDateTime lastModified;

    @ManyToMany(
            mappedBy = "authors",
            fetch = FetchType.EAGER
    )
    private List<Course> courses;
}
