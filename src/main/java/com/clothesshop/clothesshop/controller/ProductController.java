package com.clothesshop.clothesshop.controller;

import com.clothesshop.clothesshop.modell.FilterTemplate;
import com.clothesshop.clothesshop.modell.Product;
import com.clothesshop.clothesshop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Filter;

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

    @GetMapping("/list")
    public ResponseEntity<List<Product>> getFilteredProducts(@RequestParam(required = false, name = "sex", defaultValue = "%") String sex,
                                                             @RequestParam(required = false, name = "category", defaultValue = "%") String category,
                                                             @RequestParam(required = false, name = "brand", defaultValue = "%") String brand,
                                                             @RequestParam(required = false, name = "priceMin", defaultValue = "0") int priceMin,
                                                             @RequestParam(required = false, name = "priceMax", defaultValue = "100000000") int priceMax
    ){

        FilterTemplate filterTemplate = new FilterTemplate();
        filterTemplate.setBrand(brand);
        filterTemplate.setCategory(category);
        filterTemplate.setSex(sex);
        filterTemplate.setPriceMax(priceMax);
        filterTemplate.setPriceMin(priceMin);

        return ResponseEntity.ok().body(productService.getFilteredProducts(filterTemplate));
    }

    @DeleteMapping("/deleteproduct/{id}")
    public void deleteProduct(@PathVariable(value = "id") Long id){
        productService.deleteProduct(id);
    }


}
