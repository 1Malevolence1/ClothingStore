package com.example.admin_panel.controller;


import com.example.admin_panel.dto.ProductCreateRequestDto;
import com.example.admin_panel.service.CategoryService;
import com.example.admin_panel.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("api/admin/product/add")
@RequiredArgsConstructor
@Slf4j
public class AdminAddProductAdminPanel {


    private final ProductService productService;
    private final CategoryService categoryService;


    @GetMapping()
    public String getAdminPanelMainPage(Model model){
        model.addAttribute("category", categoryService.getAllCategory());;
        return "add";
    }

    @PostMapping()
    public String addProduct(@ModelAttribute ProductCreateRequestDto dto, @RequestParam MultipartFile multipartFile){
        if (multipartFile == null) {
            log.error("МУЛЬТИФАЙЛ NULL");
             // или можно вернуть ошибку
        }
        productService.addProduct(dto, multipartFile);
        return "redirect:/api/admin";
    }

}
