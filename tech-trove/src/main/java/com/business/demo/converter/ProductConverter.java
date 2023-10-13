package com.business.demo.converter;

import com.business.demo.domain.ProductDTO;
import com.business.demo.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductConverter {
    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    Product toProduct(ProductDTO productDTO);

    ProductDTO toProductDTO(Product product);

    List<ProductDTO> toProductDTOList(List<Product> products);
}
