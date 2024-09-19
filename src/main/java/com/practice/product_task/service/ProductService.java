package com.practice.product_task.service;

import com.practice.product_task.model.Product;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public List<Product> findAll() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts(Integer priceFrom, Integer priceTo) {
        if (priceFrom != null && priceTo != null) {
            return products.stream().filter(product -> product.getPrice() >= priceFrom && product.getPrice() <= priceTo).toList();
        } else if (priceFrom != null) {
            return products.stream().filter(product -> product.getPrice() >= priceFrom).toList();
        } else if (priceTo != null) {
            return products.stream().filter(product -> product.getPrice() <= priceTo).toList();
        }
        return products;
    }
}
