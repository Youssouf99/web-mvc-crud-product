package com.example.productapi.controllers;

import com.example.productapi.dtos.PartialProductDto;
import com.example.productapi.dtos.ProductDto;
import com.example.productapi.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody PartialProductDto partialProductDto) {
        return productService.createProduct(partialProductDto);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody PartialProductDto partialProductDto) {
        return productService.updateProduct(id, partialProductDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }




}
