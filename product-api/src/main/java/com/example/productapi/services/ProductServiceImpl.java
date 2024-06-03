package com.example.productapi.services;

import com.example.productapi.dtos.PartialProductDto;
import com.example.productapi.dtos.ProductDto;
import com.example.productapi.entities.Product;
import com.example.productapi.mappers.ProductMapper;
import com.example.productapi.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper = ProductMapper.INSTANCE;


    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::productToProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::productToProductDTO)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public ProductDto createProduct(PartialProductDto partialProductDto) {
        Product product = productMapper.partialProductDTOToProduct(partialProductDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.productToProductDTO(savedProduct);
    }

    @Override
    public ProductDto updateProduct(Long id, PartialProductDto partialProductDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(partialProductDto.getName());
        product.setPrice(partialProductDto.getPrice());
        Product updatedProduct = productRepository.save(product);
        return productMapper.productToProductDTO(updatedProduct);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void deleteProduct(ProductDto productDto) {
        productRepository.delete(productMapper.productDTOToProduct(productDto));
    }


}
