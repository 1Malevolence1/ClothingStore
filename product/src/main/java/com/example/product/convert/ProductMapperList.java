package com.example.product.convert;

import com.example.product.dto.ProductForAminPanelMainPageResponseDto;
import com.example.product.model.Product;
import com.example.product.dto.ProductForMainPageResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = ProductMapper.class)
public interface ProductMapperList {

    List<ProductForMainPageResponseDto> toProductForMainPage(List<Product> model);
    List<ProductForAminPanelMainPageResponseDto> toProductForAdminMainPage(List<Product> model);
}
