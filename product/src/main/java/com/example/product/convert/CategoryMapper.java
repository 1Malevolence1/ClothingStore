package com.example.product.convert;


import com.example.product.dto.CategoryRequestDto;
import com.example.product.dto.CategoryResponseDto;
import com.example.product.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toModel(CategoryRequestDto dto);
    CategoryResponseDto toDto(Category model);
}
