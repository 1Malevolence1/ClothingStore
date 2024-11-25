package com.example.product.convert;

import com.example.product.dto.CategoryRequestDto;
import com.example.product.dto.CategoryResponseDto;
import com.example.product.model.Category;

import java.util.List;

public interface CategoryManagerMapper {


    Category toModel(CategoryRequestDto dto);
    List<CategoryResponseDto> toDto(List<Category> model);
}
