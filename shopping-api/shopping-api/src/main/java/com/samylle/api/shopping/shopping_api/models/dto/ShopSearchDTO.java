package com.samylle.api.shopping.shopping_api.models.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopSearchDTO {
    private Date startDate;
    private Date endDate;
    private double minValue;

}
