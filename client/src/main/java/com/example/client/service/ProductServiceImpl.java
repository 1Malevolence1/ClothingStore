package com.example.client.service;

import com.example.client.dto.ProductDetailInformationResponseDto;
import com.example.client.dto.ProductForMainPageMainPageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final RestClient restClientProduct;
    private final String GET_ALL_PRODUCT = "api/user/product/all";
    private final String GET_ALL_PRODUCT_BY_PRODUCT_NAME = "api/user/product?productName=%s";
    private final String GET_PRODUCT_DETAIL_INFORMATION_BY_ID = "api/admin/product/%d";

    @Override
    public List<ProductForMainPageMainPageResponseDto> getAllProducts() {
        return restClientProduct.get().uri(GET_ALL_PRODUCT).retrieve().body(new ParameterizedTypeReference<List<ProductForMainPageMainPageResponseDto>>() {
        });
    }

    @Override
    public List<ProductForMainPageMainPageResponseDto> getAllProducts(String productName) {
        return restClientProduct.get().uri(GET_ALL_PRODUCT_BY_PRODUCT_NAME.formatted(productName))
                .retrieve().body(new ParameterizedTypeReference<List<ProductForMainPageMainPageResponseDto>>() {
        });
    }

    @Override
    public ProductDetailInformationResponseDto getProduct(Long productId) {
        return restClientProduct.get().uri(GET_PRODUCT_DETAIL_INFORMATION_BY_ID.formatted(productId)).retrieve().body(ProductDetailInformationResponseDto.class);
    }
}
