package com.samylle.api.product.product_api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.samylle.api.product.product_api.models.Category;
import com.samylle.api.product.product_api.models.dto.CategoryDTO;
import com.samylle.api.product.product_api.repositories.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryDTO> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(CategoryDTO::convert)
                .collect(Collectors.toList());
    }

    public Page<CategoryDTO> getAllPage(Pageable pageable) {
        Page<Category> categories = categoryRepository.findAll(pageable);
        return categories.map(CategoryDTO::convert);
    }

    public CategoryDTO findById(String categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        return CategoryDTO.convert(category);
    }

    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = categoryRepository.save(Category.convert(categoryDTO));
        return CategoryDTO.convert(category);
    }

    public CategoryDTO editCategory(String categoryId, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        if (categoryDTO.getNome() != null && !category.getNome().equals(categoryDTO.getNome())) {
            category.setNome(categoryDTO.getNome());
        }

        category = categoryRepository.save(category);
        return CategoryDTO.convert(category);
    }

    public void delete(String categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        categoryRepository.delete(category);
    }

    public List<CategoryDTO> queryByName(String name) {
        List<Category> categories = categoryRepository.findByNomeContaining(name);
        return categories.stream()
                .map(CategoryDTO::convert)
                .collect(Collectors.toList());
    }
}
