package com.example.product.service;

import com.example.product.convert.CategoryManagerMapper;
import com.example.product.convert.CategoryMapper;
import com.example.product.dto.CategoryRequestDto;
import com.example.product.dto.CategoryResponseDto;
import com.example.product.model.Category;
import com.example.product.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryManagerMapper categoryManagerMapper;
    @Override
    public Category findByCategoryName(String categoryName) {
        return categoryRepository.findCategoriesByCategoryName(categoryName);
    }

    @Override
    public void addCategory(CategoryRequestDto dto) {
            categoryRepository.save(
                    categoryManagerMapper.toModel(dto)
            );
    }

    @Override
    public List<CategoryResponseDto> findAllCategory() {
        return categoryManagerMapper.toDto(
                categoryRepository.findAll()
        );
    }
}
