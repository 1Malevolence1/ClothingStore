package com.example.product.controller;


import com.example.product.dto.ProductForMainPageResponseDto;
import com.example.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/user/product")
@RequiredArgsConstructor
public class ProductUserRestController {

    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductForMainPageResponseDto>> getAllProduct(){
        return ResponseEntity.ok(
                productService.findAll()
        );
    }

    @GetMapping()
    public ResponseEntity<List<ProductForMainPageResponseDto>> getAllProductByProductName(@RequestParam String productName){
        return ResponseEntity.ok(
                productService.findAll(productName)
        );
    }
}
