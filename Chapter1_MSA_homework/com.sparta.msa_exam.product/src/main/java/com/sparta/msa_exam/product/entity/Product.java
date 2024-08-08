package com.sparta.msa_exam.product.entity;


import com.sparta.msa_exam.product.dto.ProductRequestDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    private String name;
    private Integer supply_price;

    public Product(ProductRequestDto requestDto) {
        this.name = requestDto.getName();
        this.supply_price = requestDto.getSupply_price();
    }


}
