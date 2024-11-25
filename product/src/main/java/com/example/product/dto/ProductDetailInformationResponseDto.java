package com.example.product.dto;

import lombok.Value;

/**
 * DTO for {@link com.example.product.model.Product}
 */
@Value
public class ProductDetailInformationResponseDto {
    Long id;
    String productName;
    String description;
    Long stockQuantity;
    Long price;
    String imageUrl;
    CategoryResponseDto category;
}