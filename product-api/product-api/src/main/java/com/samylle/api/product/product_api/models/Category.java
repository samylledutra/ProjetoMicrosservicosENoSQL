package com.samylle.api.product.product_api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.samylle.api.product.product_api.models.dto.CategoryDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "categories")
public class Category {
    @Id
    private String id;
    private String nome;

    public static Category convert(CategoryDTO categoryDTO) {
        return new Category(
            categoryDTO.getId(),
            categoryDTO.getNome()
        );
    }
}

