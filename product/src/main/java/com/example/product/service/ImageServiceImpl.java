package com.example.product.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final String UPLOAD_PATCH = "/home/ubuntu/IdeaProjects/ClothingStore/product/src/main/resources/static/images";


    @SneakyThrows
    public String saveImageToStorage(MultipartFile imageFile, Long productId) {
        String uniqueFileName = "productId_%d.jpeg".formatted(productId);

        Path uploadPath = Path.of(UPLOAD_PATCH);
        Path filePath = uploadPath.resolve(uniqueFileName);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return uniqueFileName;
    }


    @SneakyThrows
    public byte[] getImage(String image_name) {
        Path imagePath = Path.of(UPLOAD_PATCH, image_name);

        if (Files.exists(imagePath)) {
            byte[] imageBytes = Files.readAllBytes(imagePath);
            return imageBytes;
        } else {
            return null; // Handle missing images
        }
    }


    @SneakyThrows
    public void deleteImage(Long productId) {
        String url = "productId_%d".formatted(productId);
        Path imagePath = Path.of(UPLOAD_PATCH, url);

        if (Files.exists(imagePath)) {
            Files.delete(imagePath);
            log.info("Success");
        } else {
            log.info("Failed"); // Handle missing images
        }
    }

}
