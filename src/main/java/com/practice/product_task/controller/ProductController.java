package com.practice.product_task.controller;

import lombok.RequiredArgsConstructor;
import com.practice.product_task.model.Product;
import org.springframework.web.bind.annotation.*;
import com.practice.product_task.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts(@RequestParam(required = false) Integer priceFrom,
                                     @RequestParam(required = false) Integer priceTo) {
        if (priceFrom != null && priceTo != null) {
            return productService.findAll().stream().filter(product -> product.getPrice() >= priceFrom && product.getPrice() <= priceTo).toList();
        } else if (priceFrom != null) {
            return productService.findAll().stream().filter(product -> product.getPrice() >= priceFrom).toList();
        } else if (priceTo != null) {
            return productService.findAll().stream().filter(product -> product.getPrice() <= priceTo).toList();
        } else {
            return productService.findAll();
        }
    }

    @PostMapping("/products/add")
    public Product addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return product;
    }
}
