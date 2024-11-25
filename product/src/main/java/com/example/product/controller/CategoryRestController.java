package com.example.product.controller;


import com.example.product.dto.CategoryRequestDto;
import com.example.product.dto.CategoryResponseDto;
import com.example.product.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryRestController {
    private final CategoryService categoryService;


    @PostMapping
    public ResponseEntity<Void> addCategory(@RequestBody CategoryRequestDto dto){
        categoryService.addCategory(dto);
        return ResponseEntity.noContent().build();
    }


    @GetMapping()
    public ResponseEntity<List<CategoryResponseDto>> getAllCategory(){
        return ResponseEntity.ok(
                categoryService.findAllCategory()
        );
    }
}
