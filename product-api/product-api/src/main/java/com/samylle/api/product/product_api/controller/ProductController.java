package com.samylle.api.product.product_api.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.samylle.api.product.product_api.models.dto.ProductDTO;
import com.samylle.api.product.product_api.services.ProductService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductDTO save(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable String id) {
        return productService.findById(id);
    }

    @GetMapping
    public List<ProductDTO> getAll() {
        return productService.getAll();
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> getProductByCategoryId(@PathVariable String categoryId) {
        return productService.getProductByCategoryId(categoryId);
    }

    @GetMapping("/{productIdentifier}")
    public ProductDTO findByProductIdentifier(@PathVariable String productIdentifier) {
        return productService.findByProductIdentifier(productIdentifier);
    }

    @GetMapping("/pageable")
    public Page<ProductDTO> getAllPage(Pageable pageable) {
        return productService.getAllPage(pageable);
    }

}
