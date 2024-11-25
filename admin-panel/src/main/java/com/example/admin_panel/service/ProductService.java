package com.example.admin_panel.service;

import com.example.admin_panel.dto.ProductCreateRequestDto;
import com.example.admin_panel.dto.ProductDetailInformationResponseDto;
import com.example.admin_panel.dto.ProductForAdminMainPageMainPageResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    ResponseEntity<List<ProductForAdminMainPageMainPageResponseDto>> getAllProduct();
    ProductDetailInformationResponseDto getProductById(Long productId);
    void addProduct(ProductCreateRequestDto dto, MultipartFile file);
    void deleteProduct(Long productId);
}
