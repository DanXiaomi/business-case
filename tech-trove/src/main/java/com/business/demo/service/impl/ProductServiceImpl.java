package com.business.demo.service.impl;

import com.business.demo.converter.ProductConverter;
import com.business.demo.domain.ProductDTO;
import com.business.demo.model.Product;
import com.business.demo.repository.ProductRepository;
import com.business.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ResponseEntity<ProductDTO> save(ProductDTO productDTO) {
        Product product = ProductConverter.INSTANCE.toProduct(productDTO);
        product.setCreatedAt(LocalDateTime.now());
        return new ResponseEntity<>(
                ProductConverter.INSTANCE.toProductDTO(productRepository.save(product)),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return new ResponseEntity<>(
                ProductConverter.INSTANCE.toProductDTOList(productRepository.findAll()),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDTO> getProduct(String code) {
        Optional<Product> product = productRepository.findByCode(code);
        return new ResponseEntity<>(
                ProductConverter.INSTANCE.toProductDTO(product.orElse(null)),
                product.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<ProductDTO> updateProduct(String code, ProductDTO productDTO) {
        if (productRepository.findByCode(code).isPresent()) {
            Product product = ProductConverter.INSTANCE.toProduct(productDTO);
            product.setUpdatedAt(LocalDateTime.now());
            return new ResponseEntity<>(
                    ProductConverter.INSTANCE.toProductDTO(productRepository.save(product)),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Void> deleteProduct(String code) {
        productRepository.deleteByCode(code);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
