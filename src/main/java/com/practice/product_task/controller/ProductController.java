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
    public List<Product> getProducts(@RequestParam Integer priceFrom,
                                     @RequestParam Integer priceTo) {
      return productService.getProducts(priceFrom,priceTo);
    }

    @PostMapping("/products/add")
    public Product addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return product;
    }
}
