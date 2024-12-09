package com.samylle.api.shopping.shopping_api.models.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopDTO {
    private String userIdentifier;
    private List<ItemDTO> items;
    private double total;

}
