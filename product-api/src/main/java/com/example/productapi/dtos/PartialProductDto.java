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
public class PartialProductDto {
        private String name;
        private Double price;
}
