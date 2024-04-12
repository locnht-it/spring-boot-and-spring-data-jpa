package com.locnht.SpringBootAndSpringDataJpa.dto;

public record StudentResponseDto(
        String firstname,
        String lastname,
        String email
) {
}
