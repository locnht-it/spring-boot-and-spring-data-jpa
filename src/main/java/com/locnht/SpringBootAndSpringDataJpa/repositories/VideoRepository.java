package com.locnht.SpringBootAndSpringDataJpa.repositories;

import com.locnht.SpringBootAndSpringDataJpa.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {
}
