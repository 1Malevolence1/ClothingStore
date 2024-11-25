package com.example.client.service;


import com.example.client.dto.ProductDetailInformationResponseDto;
import com.example.client.dto.ProductForMainPageMainPageResponseDto;

import java.util.List;

public interface ProductService {
    List<ProductForMainPageMainPageResponseDto> getAllProducts();
    List<ProductForMainPageMainPageResponseDto> getAllProducts(String productName);
    ProductDetailInformationResponseDto getProduct(Long productId);
}
