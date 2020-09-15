package com.clothesshop.clothesshop.controller;

import com.clothesshop.clothesshop.modell.FilterTemplate;
import com.clothesshop.clothesshop.modell.Product;
import com.clothesshop.clothesshop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return ResponseEntity.ok().body(productService.saveProduct(product));
    }

    @PostMapping("/list")
    public ResponseEntity<List<Product>> listFilteredProducts(@RequestBody FilterTemplate filterTemplate){
        return ResponseEntity.ok().body(productService.getFilteredProducts(filterTemplate));
    }

    @DeleteMapping("/deleteproduct/{id}")
    public void deleteProduct(@PathVariable(value = "id") Long id){
        productService.deleteProduct(id);
    }


}
