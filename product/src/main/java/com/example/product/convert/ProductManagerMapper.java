package com.example.product.convert;

import com.example.product.dto.ProductCreateReuestDto;
import com.example.product.dto.ProductDetailInformationResponseDto;
import com.example.product.dto.ProductForAminPanelMainPageResponseDto;
import com.example.product.model.Product;
import com.example.product.dto.ProductForMainPageResponseDto;

import java.util.List;

public interface ProductManagerMapper {

    ProductDetailInformationResponseDto toProductDetailInformationDto(Product model);
    List<ProductForAminPanelMainPageResponseDto> toProductForAdminManePage(List<Product> model);
    List<ProductForMainPageResponseDto> toProductForMainPageDto(List<Product>  model);
    Product toProductCreateModel(ProductCreateReuestDto dto);


}
