package com.example.product.dto;

import lombok.ToString;
import lombok.Value;
import org.springframework.web.multipart.MultipartFile;

/**
 * DTO for {@link com.example.product.model.Product}
 */
@Value
@ToString
public class ProductCreateReuestDto {
    String productName;
    String description;
    Long price;
    Long stockQuantity;
    String categoryName;
}