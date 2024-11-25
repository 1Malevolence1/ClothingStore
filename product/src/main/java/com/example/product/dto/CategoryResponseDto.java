package com.example.product.dto;

import lombok.Value;

/**
 * DTO for {@link com.example.product.model.Category}
 */
@Value
public class CategoryResponseDto {
    Long id;
    String categoryName;
}