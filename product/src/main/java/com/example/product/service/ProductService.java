package com.example.product.service;

import com.example.product.dto.ProductCreateReuestDto;
import com.example.product.dto.ProductDetailInformationResponseDto;
import com.example.product.dto.ProductForAminPanelMainPageResponseDto;
import com.example.product.dto.ProductForMainPageResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    List<ProductForMainPageResponseDto> findAll();
    List<ProductForMainPageResponseDto> findAll(String productName);
    ProductDetailInformationResponseDto findProductById(Long id);


}
