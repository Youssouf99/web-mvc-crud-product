package com.example.productapi;

import com.example.productapi.entities.Product;
import com.example.productapi.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ProductApiApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private ProductRepository productRepository;


    @Test
    public void testCreateProduct() {
        Product prod = new Product(null, "PC Dell", 2200.500, null);

        productRepository.save(prod);

        Optional<Product> foundProduct = productRepository.findById(prod.getId());
        assertThat(foundProduct).isPresent();
        assertThat(foundProduct.get().getName()).isEqualTo(prod.getName());
        assertThat(foundProduct.get().getPrice()).isEqualTo(prod.getPrice());
        assertThat(foundProduct.get().getDateCreate()).isEqualTo(prod.getDateCreate());
    }

    @Test
    public void testFindProduct() {
        Product p = productRepository.findById(1L).orElse(null);
        assertThat(p).isNotNull();
        System.out.println(p);
    }

    @Test
    public void testUpdateProduct() {
        Product p = productRepository.findById(1L).orElse(null);
        assertThat(p).isNotNull();

        p.setPrice(1000.0);
        productRepository.save(p);

        Product updatedProduct = productRepository.findById(1L).orElse(null);
        assertThat(updatedProduct).isNotNull();
        assertThat(updatedProduct.getPrice()).isEqualTo(1000.0);
    }

    @Test
    public void testDeleteProduct() {
        Product prod = new Product(null, "PC Test", 1500.0, null);
        productRepository.save(prod);

        productRepository.deleteById(prod.getId());

        Optional<Product> deletedProduct = productRepository.findById(prod.getId());
        assertThat(deletedProduct).isNotPresent();
    }

    @Test
    public void testListProducts() {
        List<Product> prods = productRepository.findAll();

        assertThat(prods).isNotNull();

        for (Product p : prods) {
            System.out.println(p);
        }
    }




}
