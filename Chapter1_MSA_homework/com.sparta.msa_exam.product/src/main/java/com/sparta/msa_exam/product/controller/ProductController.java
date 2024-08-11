package com.sparta.msa_exam.product.controller;

import com.sparta.msa_exam.product.dto.ProductRequestDto;
import com.sparta.msa_exam.product.dto.ProductResponseDto;
import com.sparta.msa_exam.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

   private final ProductService productService;

   @Value("${server.port}")
   private Long serverPort;

    @PostMapping
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto requestDto) {
        return productService.createProduct(requestDto);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<ProductResponseDto>> getProduct() {
        List<ProductResponseDto> responseDto = productService.getProduct();
        return ResponseEntity.ok().body(responseDto);
    }

}
