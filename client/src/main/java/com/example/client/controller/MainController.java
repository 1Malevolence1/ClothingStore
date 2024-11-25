package com.example.client.controller;


import com.example.client.service.CategoryService;
import com.example.client.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("api/client/main")
@RequiredArgsConstructor
public class MainController {


    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping()
    public String getMainPage(Model model){
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("category", categoryService.getAllCategory());
        return "main";
    }


    @GetMapping("/product")
    public String getProductByProductName(Model model, @RequestParam(name = "productName") String productName){
        if (productName != null && !productName.isEmpty()) {
            model.addAttribute("products", productService.getAllProducts(productName));  // Фильтрация по имени продукта
        } else {
            model.addAttribute("products", productService.getAllProducts());  // Все товары, если нет поиска
        }
        model.addAttribute("category", categoryService.getAllCategory());
        return "main";
    }

}
