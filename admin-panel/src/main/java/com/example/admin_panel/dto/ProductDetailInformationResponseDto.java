package com.example.admin_panel.dto;


import lombok.Value;


public record ProductDetailInformationResponseDto(
        Long id,
        String productName,
        String description,
        Long price,
        Long stockQuantity,
        String imageUrl,
        CategoryResponseDto category
) {
}