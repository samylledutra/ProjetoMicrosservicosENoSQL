package com.samylle.api.product.product_api.controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.samylle.api.product.product_api.models.dto.CategoryDTO;
import com.samylle.api.product.product_api.services.CategoryService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public CategoryDTO save(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.save(categoryDTO);
    }

    @GetMapping
    public List<CategoryDTO> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public CategoryDTO findById(@PathVariable String id) {
        return categoryService.findById(id);
    }

    @PutMapping("/{id}")
    public CategoryDTO update(@PathVariable String id, @RequestBody CategoryDTO categoryDTO) {
        return categoryService.editCategory(id, categoryDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        categoryService.delete(id);
    }

    @GetMapping("/pageable")
    public Page<CategoryDTO> getAllPage(Pageable pageable) {
        return categoryService.getAllPage(pageable);
    }

    
}
