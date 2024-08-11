package com.sparta.msa_exam.order.entity;

import com.sparta.msa_exam.order.dto.OrderRequestDto;
import com.sparta.msa_exam.order.dto.OrderResponseDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "product_ids")
    private List<Long> product_ids;

    public Order(OrderRequestDto requestDto) {
        this.name = requestDto.getName();
        this.product_ids = requestDto.getProduct_ids();
    }

    public static Order createOrder(List<Long> productIds) {
        return Order.builder().build();
    }
}

