package com.example.product.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    String saveImageToStorage(MultipartFile file, Long id);
    byte[] getImage(String image_name);
    void deleteImage(Long productId);
}
