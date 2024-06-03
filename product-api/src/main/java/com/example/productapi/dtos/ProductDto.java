package com.example.productapi.dtos;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
        private Long id;
        private String name;
        private Double price;
        private Date dateCreate;
}
