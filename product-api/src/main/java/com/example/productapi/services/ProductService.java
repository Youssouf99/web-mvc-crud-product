package com.example.productapi.services;

import com.example.productapi.dtos.PartialProductDto;
import com.example.productapi.dtos.ProductDto;
import com.example.productapi.repositories.ProductRepository;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long id);

    ProductDto createProduct(PartialProductDto partialProductDto);

    ProductDto updateProduct(Long id, PartialProductDto partialProductDto);

    void deleteProductById(Long id);

    void deleteProduct(ProductDto productDto);
}
