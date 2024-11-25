package com.example.product.service;

import com.example.product.convert.ProductManagerMapper;
import com.example.product.dto.ProductCreateReuestDto;
import com.example.product.dto.ProductForAminPanelMainPageResponseDto;
import com.example.product.model.Category;
import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class ProductAdminServiceImpl implements ProductAdminService {



    private final ProductRepository productRepository;
    private final ImageService imageService;
    private final ProductManagerMapper productManagerMapper;
    private final CategoryService categoryService;



    @Override
    public List<ProductForAminPanelMainPageResponseDto> findAll() {
        return productManagerMapper.toProductForAdminManePage(
                productRepository.findAll()
        );
    }

    @Override
    public void deleteProduct(Long id) {
        imageService.deleteImage(id);
        productRepository.deleteById(id);
    }

    @Override
    public Long addProduct(ProductCreateReuestDto dto) {
        Category category = categoryService.findByCategoryName(dto.getCategoryName());
        Product product = productManagerMapper.toProductCreateModel(dto);
        product.setCategory(category);
        Product saveProduct = productRepository.save(product);
        return saveProduct.getId();
    }

    @Override
    @Transactional
    public void saveImageUrlInBaseData(Long productId, String url) {
        productRepository.updateImageUrl(productId, url);
    }
}
