package com.example.product.convert;


import com.example.product.dto.CategoryResponseDto;
import com.example.product.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface CategoryListMapper {

    List<CategoryResponseDto> toDto(List<Category> model);
}
