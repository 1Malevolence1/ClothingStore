package com.example.product.service;

import com.example.product.dto.CategoryRequestDto;
import com.example.product.dto.CategoryResponseDto;
import com.example.product.model.Category;

import java.util.List;

public interface CategoryService {
    Category findByCategoryName(String categoryName);
    void addCategory(CategoryRequestDto dto);
    List<CategoryResponseDto> findAllCategory();
}
