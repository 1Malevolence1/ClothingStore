package com.example.admin_panel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final String  GET_IMAGE = "/api/image/get/%s";
    private final String  POST_ADD_IMAGE ="/api/image/add/%d";

    private final RestClient restClientProduct;

    @Override
    public void addImage(Long productId, MultipartFile file) {
        restClientProduct.post().uri(POST_ADD_IMAGE.formatted(productId)).body(file).retrieve();
    }

    @Override
    public byte[] getImage(String imageName) {
        return restClientProduct.get().uri(GET_IMAGE.formatted(imageName)).retrieve().toEntity(byte[].class).getBody();
    }
}
