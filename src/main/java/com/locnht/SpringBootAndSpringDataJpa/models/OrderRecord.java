package com.locnht.SpringBootAndSpringDataJpa.models;

public record OrderRecord(
        String customerName,
        String productName,
        int quantity
) {
}
