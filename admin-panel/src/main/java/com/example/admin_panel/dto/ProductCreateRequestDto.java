package com.example.admin_panel.dto;

import lombok.ToString;
import lombok.Value;


@Value
@ToString
public class ProductCreateRequestDto {
    String productName;
    String description;
    Long stockQuantity;
    Long price;
    String categoryName;
}