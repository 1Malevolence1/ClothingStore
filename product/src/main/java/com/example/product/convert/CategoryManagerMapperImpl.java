package com.example.product.convert;

import com.example.product.dto.CategoryRequestDto;
import com.example.product.dto.CategoryResponseDto;
import com.example.product.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class CategoryManagerMapperImpl implements CategoryManagerMapper {

    private final CategoryListMapper categoryListMapper;
    private final CategoryMapper categoryMapper;


    @Override
    public Category toModel(CategoryRequestDto dto) {
        return categoryMapper.toModel(dto);
    }

    @Override
    public List<CategoryResponseDto> toDto(List<Category> model) {
        return categoryListMapper.toDto(model);
    }
}
