package com.example.product.service;

import com.example.product.dto.ProductCreateReuestDto;
import com.example.product.dto.ProductForAminPanelMainPageResponseDto;

import java.util.List;

public interface ProductAdminService {
    List<ProductForAminPanelMainPageResponseDto> findAll();
    void deleteProduct(Long id);
    void saveImageUrlInBaseData(Long productId, String url);
    Long addProduct(ProductCreateReuestDto dto);
}
