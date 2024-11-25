package com.example.product.convert;

import com.example.product.dto.ProductCreateReuestDto;
import com.example.product.dto.ProductDetailInformationResponseDto;
import com.example.product.dto.ProductForAminPanelMainPageResponseDto;
import com.example.product.model.Product;
import com.example.product.dto.ProductForMainPageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class ProductManagerMapperImpl implements ProductManagerMapper {

    private final ProductMapper productMapper;
    private final ProductMapperList productMapperList;

    @Override
    public ProductDetailInformationResponseDto toProductDetailInformationDto(Product model) {
        return productMapper.toProductDetailInformationDto(model);
    }

    @Override
    public List<ProductForAminPanelMainPageResponseDto> toProductForAdminManePage(List<Product> model) {
        return productMapperList.toProductForAdminMainPage(model);
    }

    @Override
    public List<ProductForMainPageResponseDto> toProductForMainPageDto(List<Product> model) {
        return productMapperList.toProductForMainPage(model);
    }

    @Override
    public Product toProductCreateModel(ProductCreateReuestDto dto) {
        return productMapper.toModel(dto);
    }
}
