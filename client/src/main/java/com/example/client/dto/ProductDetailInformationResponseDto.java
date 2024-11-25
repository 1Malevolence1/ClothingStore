package com.example.client.dto;




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