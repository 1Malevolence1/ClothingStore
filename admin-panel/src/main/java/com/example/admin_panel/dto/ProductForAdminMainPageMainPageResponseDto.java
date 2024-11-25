package com.example.admin_panel.dto;


public record ProductForAdminMainPageMainPageResponseDto(Long id, String productName, CategoryResponseDto category, Long stockQuantity) {
}