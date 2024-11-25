package com.example.admin_panel.dto;


public record ProductRequestDto(String productName, String description, Long stockQuantity, String imageUrl, String category) {
}