package com.sparta.msa_exam.order.client;

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
}
