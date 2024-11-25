package com.example.admin_panel.controller;


import com.example.admin_panel.service.CategoryService;
import com.example.admin_panel.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/admin")
@RequiredArgsConstructor
public class AdminPanelMainPageController {

    private final ProductService productService;
    private final CategoryService categoryService;


    @GetMapping()
    public String getAdminPanelMainPage(Model model){
        model.addAttribute("category", categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProduct().getBody());
        return "main";
    }
}
