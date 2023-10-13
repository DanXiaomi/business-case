package com.business.demo.converter;

import com.business.demo.domain.ProductDTO;
import com.business.demo.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-13T17:06:27-0500",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 1.8.0_321 (Oracle Corporation)"
)
public class ProductConverterImpl implements ProductConverter {

    @Override
    public Product toProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.code( productDTO.getCode() );
        product.name( productDTO.getName() );
        product.brand( productDTO.getBrand() );
        product.price( productDTO.getPrice() );
        product.category( productDTO.getCategory() );
        product.stock( productDTO.getStock() );

        return product.build();
    }

    @Override
    public ProductDTO toProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO.ProductDTOBuilder productDTO = ProductDTO.builder();

        productDTO.code( product.getCode() );
        productDTO.name( product.getName() );
        productDTO.brand( product.getBrand() );
        productDTO.price( product.getPrice() );
        productDTO.category( product.getCategory() );
        productDTO.stock( product.getStock() );

        return productDTO.build();
    }

    @Override
    public List<ProductDTO> toProductDTOList(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( products.size() );
        for ( Product product : products ) {
            list.add( toProductDTO( product ) );
        }

        return list;
    }
}
