package com.business.demo.service;

import com.business.demo.domain.ProductDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ResponseEntity<ProductDTO> save(ProductDTO productDTO);

    ResponseEntity<List<ProductDTO>> getProducts();

    ResponseEntity<ProductDTO> getProduct(String code);

    ResponseEntity<ProductDTO> updateProduct(String code, ProductDTO productDTO);

    ResponseEntity<Void> deleteProduct(String code);
}
