package com.locnht.SpringBootAndSpringDataJpa.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
//@DiscriminatorValue("V") // @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@PrimaryKeyJoinColumn(name = "video_id") //@Inheritance(strategy = InheritanceType.JOINED)
public class Video extends Resource{

    private int length;
}
