package com.sparta.msa_exam.product.dto;

import com.sparta.msa_exam.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
    private Long productId;
    private String name;
    private Integer supply_price;

    public ProductResponseDto(Product product) {
        this.productId = product.getProduct_id();
        this.name = product.getName();
        this.supply_price = product.getSupply_price();
    }
}
