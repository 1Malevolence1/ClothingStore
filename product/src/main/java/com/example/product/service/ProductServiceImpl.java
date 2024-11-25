package com.example.product.service;

import com.example.product.convert.ProductManagerMapper;
import com.example.product.dto.ProductDetailInformationResponseDto;
import com.example.product.dto.ProductForMainPageResponseDto;
import com.example.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductManagerMapper productManagerMapper;

    @Override
    public List<ProductForMainPageResponseDto> findAll() {
        return productManagerMapper.toProductForMainPageDto(
                productRepository.findAll()
        );
    }

    @Override
    public List<ProductForMainPageResponseDto> findAll(String productName) {
        return productManagerMapper.toProductForMainPageDto(
                productRepository.findProductsByProductName(productName)
        );
    }

    @Override
    public ProductDetailInformationResponseDto findProductById(Long id) {
        return productManagerMapper.toProductDetailInformationDto(
                productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not found product by ID::%d".formatted(id)))
        );
    }

}
