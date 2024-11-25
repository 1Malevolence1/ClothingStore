package com.example.product.controller;


import com.example.product.dto.*;
import com.example.product.service.ProductAdminService;
import com.example.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/admin/product")
@RequiredArgsConstructor
@Slf4j
public class ProductAdminRestController {

    private final ProductService productService;
    private final ProductAdminService productAdminService;

    @PostMapping()
    public ResponseEntity<ProductCreateIdResponseDto> addProduct(@RequestBody ProductCreateReuestDto dto){
        log.info("{}", dto);
        return ResponseEntity.ok(
                new ProductCreateIdResponseDto(
                        productAdminService.addProduct(dto)
                )
        );
    }


    @GetMapping("/{productId:\\d+}")
    public ResponseEntity<ProductDetailInformationResponseDto> getProductDetailInformation(@PathVariable(name = "productId") Long productId){
        return ResponseEntity.ok(
                productService.findProductById(productId)
        );
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductForAminPanelMainPageResponseDto>> getAllProduct(){
        return ResponseEntity.ok(
                productAdminService.findAll()
        );
    }

    @DeleteMapping("/{productId:\\d+}/delete")
    public ResponseEntity<Void> deleteProduct(@PathVariable(name = "productId") Long productId){
        log.info("метод по удалению товара в сервисе Product");
        productAdminService.deleteProduct(productId);
      return ResponseEntity.noContent().build();
    }
}
