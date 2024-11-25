package com.example.admin_panel.service;

import com.example.admin_panel.dto.ProductCreateIdResponseDto;
import com.example.admin_panel.dto.ProductCreateRequestDto;
import com.example.admin_panel.dto.ProductDetailInformationResponseDto;
import com.example.admin_panel.dto.ProductForAdminMainPageMainPageResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final String GET_ALL_PRODUCT = "api/admin/product/all";
    private final String GET_DETAIL_INFORMATION_PRODUCT_BY_UD = "api/admin/product/%d";
    private final String POST_ADD_IMAGE_FOR_PRODUCT = "api/image/add/%d";
    private final String POST_ADD_PRODUCT = "api/admin/product";
    private final String DELETE_PRODUCT_BY_ID = "api/admin/product/%d/delete";


    private final RestClient restClientProduct;
    private final ParameterizedTypeReference<List<ProductForAdminMainPageMainPageResponseDto>> LIST_PRODUCT = new ParameterizedTypeReference<>(){
    };


    @Override
    public ResponseEntity<List<ProductForAdminMainPageMainPageResponseDto>> getAllProduct() {;
        return restClientProduct.get().uri(GET_ALL_PRODUCT).retrieve().toEntity(
               LIST_PRODUCT
        );
    }

    @Override
    public ProductDetailInformationResponseDto getProductById(Long productId) {
        ResponseEntity<ProductDetailInformationResponseDto> response = restClientProduct.get().uri(GET_DETAIL_INFORMATION_PRODUCT_BY_UD.formatted(productId)).retrieve().toEntity(ProductDetailInformationResponseDto.class);
        if(response.getStatusCode() == HttpStatus.NOT_FOUND) throw new NoSuchElementException("Not found product with ID::%d".formatted(productId));
        else return response.getBody();
    }

    @Override
    public void addProduct(ProductCreateRequestDto dto, MultipartFile file) {
        ResponseEntity<ProductCreateIdResponseDto> productId = restClientProduct.post().uri(POST_ADD_PRODUCT).contentType(MediaType.APPLICATION_JSON).body(dto).retrieve().toEntity(ProductCreateIdResponseDto.class);
        // Шаг 2: Создаем multipart-запрос для отправки файла
        MultipartBodyBuilder multipartBodyBuilder = new MultipartBodyBuilder();
        multipartBodyBuilder.part("file", file.getResource());  // Важно: "file" должно быть таким же, как в @RequestPart

        // Шаг 3: Отправляем файл через multipart/form-data
        ResponseEntity<Void> response = restClientProduct.post()
                .uri(POST_ADD_IMAGE_FOR_PRODUCT.formatted(productId.getBody().productId()))  // Вставляем ID продукта в URL
                .contentType(MediaType.MULTIPART_FORM_DATA)  // Указываем тип данных multipart/form-data
                .body(multipartBodyBuilder.build())  // Передаем тело запроса
                .retrieve()
                .toBodilessEntity();
    }

    @Override
    public void deleteProduct(Long productId) {
       restClientProduct.delete().uri(DELETE_PRODUCT_BY_ID.formatted(productId));
    }
}
