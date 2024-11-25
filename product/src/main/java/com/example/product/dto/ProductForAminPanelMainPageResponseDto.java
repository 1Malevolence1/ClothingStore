package com.example.product.dto;

import com.example.product.model.Category;

/**
 * DTO for {@link com.example.product.model.Product}
 */
public record ProductForAminPanelMainPageResponseDto(Long id, String productName, CategoryResponseDto category, Long stockQuantity,
                                                     Long price) {
}