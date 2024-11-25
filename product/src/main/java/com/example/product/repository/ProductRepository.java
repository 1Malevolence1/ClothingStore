package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Query(value = "UPDATE product SET image_url = :url WHERE product_id = :productId", nativeQuery = true)
    void updateImageUrl(@Param("productId") Long id, @Param("url") String url);


    @Query("SELECT p FROM Product p WHERE p.productName LIKE %:name%")
    List<Product> findProductsByProductName(@Param("name") String name);
}
