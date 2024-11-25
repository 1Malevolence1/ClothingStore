package com.example.admin_panel.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    void addImage(Long productId, MultipartFile file);
    byte[] getImage(String imageName);
}
