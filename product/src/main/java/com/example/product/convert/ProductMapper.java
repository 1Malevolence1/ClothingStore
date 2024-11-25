package com.example.product.convert;


import com.example.product.dto.ProductCreateReuestDto;
import com.example.product.dto.ProductDetailInformationResponseDto;
import com.example.product.dto.ProductForAminPanelMainPageResponseDto;
import com.example.product.model.Product;
import com.example.product.dto.ProductForMainPageResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mapping(target = "category", ignore = true)
    @Mapping(target = "imageUrl", ignore = true)
    Product toModel(ProductCreateReuestDto dto);
    ProductDetailInformationResponseDto toProductDetailInformationDto(Product model);
    ProductForMainPageResponseDto toProductForMainPage(Product model);

    ProductForAminPanelMainPageResponseDto toProductForAdminMainPage(Product model);
}
