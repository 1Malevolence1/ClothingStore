package com.example.product.dto;

import lombok.Value;

/**
 * DTO for {@link com.example.product.model.Category}
 */
public record CategoryRequestDto(String categoryName) {
}