package com.business.demo.controller;

import com.business.demo.constants.ProductURIConstants;
import com.business.demo.domain.ProductDTO;
import com.business.demo.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Save a new product",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Successful operation"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @PostMapping(value = ProductURIConstants.PRODUCTS)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductDTO> save(@RequestBody @Valid ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @Operation(summary = "Get all products",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful operation"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @GetMapping(value = ProductURIConstants.PRODUCTS)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return productService.getProducts();
    }

    @Operation(summary = "Get product by code",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful operation"),
                    @ApiResponse(responseCode = "404", description = "Not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @GetMapping(value = ProductURIConstants.PRODUCTS_CODE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductDTO> getProduct(@PathVariable String code) {
        return productService.getProduct(code);
    }

    @Operation(summary = "Update a product",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful operation"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @PutMapping(value = ProductURIConstants.PRODUCTS_CODE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable String code, @RequestBody @Valid ProductDTO productDTO) {
        return productService.updateProduct(code, productDTO);
    }

    @Operation(summary = "Delete product",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Successful operation"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @DeleteMapping(value = ProductURIConstants.PRODUCTS_CODE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteProduct(@PathVariable String code) {
        return productService.deleteProduct(code);
    }
}
