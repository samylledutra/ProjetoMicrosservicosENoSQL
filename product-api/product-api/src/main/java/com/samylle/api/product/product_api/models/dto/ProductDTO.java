package com.samylle.api.product.product_api.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String id;
    private String productIdentifier;
    private String nome;
    private String descricao;
    private Double preco;
    private CategoryDTO categoria;
}
