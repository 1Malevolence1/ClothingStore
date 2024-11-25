package com.example.admin_panel.controller;


import com.example.admin_panel.dto.ProductDetailInformationResponseDto;
import com.example.admin_panel.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/admin/product/{productId:\\d+}")
@RequiredArgsConstructor
@Slf4j
public class AdminDetailInformationController {


    private final ProductService productService;


    @ModelAttribute("product")
    public ProductDetailInformationResponseDto product(@PathVariable(name = "productId") Long productId){
        return productService.getProductById(productId);

    }


    @GetMapping()
    public String getPageDetailInformationAboutProduct(@ModelAttribute("product") ProductDetailInformationResponseDto dto, Model model){
        log.info("{}", dto);
        model.addAttribute("product", dto);
        return "detail_information";
    }


    @PostMapping("/delete")
    public String deleteProduct(@PathVariable(name = "productId") Long productId){
        log.info("---------> {}", productId);
        productService.deleteProduct(productId);
        return "redirect:/api/admin";
    }
}
