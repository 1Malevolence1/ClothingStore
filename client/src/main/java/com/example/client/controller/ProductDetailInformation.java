package com.example.client.controller;


import com.example.client.dto.ProductDetailInformationResponseDto;
import com.example.client.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/user/product/{productId:\\d+}")
@RequiredArgsConstructor
public class ProductDetailInformation {

    private final ProductService productService;

    @ModelAttribute("product")
    public ProductDetailInformationResponseDto product(@PathVariable(name = "productId") Long productId){
        return productService.getProduct(productId);
    }


    @GetMapping()
    public String getPageDetailInformationAboutProduct(@ModelAttribute("product") ProductDetailInformationResponseDto dto, Model model){
        model.addAttribute("product", dto);
        return "detail_information";
    }
}
