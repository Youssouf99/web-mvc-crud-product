package com.example.productapi.mappers;

import com.example.productapi.dtos.PartialProductDto;
import com.example.productapi.dtos.ProductDto;
import com.example.productapi.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto productToProductDTO(Product product);

    Product productDTOToProduct(ProductDto productDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateCreate", ignore = true)
    Product partialProductDTOToProduct(PartialProductDto partialProductDto);


}
