package com.sparta.msa_exam.order.dto;

import com.sparta.msa_exam.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {
    private Long order_id;
//    private String name;
    private List<Long> product_ids;

    public OrderResponseDto(Order order) {
        this.order_id = order.getOrder_id();
//        this.name = order.getName();
        this.product_ids = order.getProduct_ids();
    }
}
