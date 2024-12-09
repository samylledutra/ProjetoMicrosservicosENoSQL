package com.samylle.api.product.product_api.models.dto;

import com.samylle.api.product.product_api.models.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private String id;
    private String nome;

    public static CategoryDTO convert(Category category) {
        return new CategoryDTO(
                category.getId(),
                category.getNome());
                
    }
}
