package com.sparta.msa_exam.product.service;

import com.sparta.msa_exam.product.client.ProductClient;
import com.sparta.msa_exam.product.dto.ProductRequestDto;
import com.sparta.msa_exam.product.dto.ProductResponseDto;
import com.sparta.msa_exam.product.entity.Product;
import com.sparta.msa_exam.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductClient productClient;

    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = productRepository.save(new Product(requestDto));
        return new ProductResponseDto(product);
    }

    public List<ProductResponseDto> getProduct() {
//        productClient.getProduct(productId);
        return productRepository.findAll().stream().map(ProductResponseDto::new).toList();
    }
}
