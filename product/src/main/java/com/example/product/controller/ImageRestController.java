package com.example.product.controller;


import com.example.product.service.ImageService;
import com.example.product.service.ProductAdminService;
import com.example.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.apache.tomcat.util.http.fileupload.FileUploadBase.MULTIPART_FORM_DATA;

@RestController
@RequestMapping("api/image")
@RequiredArgsConstructor
@Slf4j
public class ImageRestController {

    private final ImageService imageService;
    private final ProductAdminService productAdminService;

    @GetMapping("/get/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
        byte[] imageBytes = imageService.getImage(imageName); // Получаем байты изображения
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG) // Укажите тип в зависимости от изображения
                .body(imageBytes);
    }

    @PostMapping(value = "/add/{productId:\\d+}")
    public ResponseEntity<Void> addImageForProduct(@RequestPart("file") MultipartFile file, @PathVariable(name = "productId") Long productId){
        String url = imageService.saveImageToStorage(file, productId);
        log.info("...... {}", url);
        productAdminService.saveImageUrlInBaseData(productId, url);
        imageService.saveImageToStorage(file, productId);
        return ResponseEntity.noContent().build();
    }
}
