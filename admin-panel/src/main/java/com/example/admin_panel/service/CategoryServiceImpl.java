package com.example.admin_panel.service;

import com.example.admin_panel.dto.CategoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;



@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final RestClient restClientProduct;
    private final String GET_ALL_CATEGORY = "/api/category";


    @Override
    public List<CategoryResponseDto> getAllCategory() {
        return restClientProduct.get().uri(GET_ALL_CATEGORY).retrieve().body(new ParameterizedTypeReference<List<CategoryResponseDto>>() {
        });
    }


}
