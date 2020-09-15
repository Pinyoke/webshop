package com.clothesshop.clothesshop.service;

import com.clothesshop.clothesshop.modell.FilterTemplate;
import com.clothesshop.clothesshop.modell.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    void deleteProduct(Long id);

    List<Product> getFilteredProducts(FilterTemplate filterTemplate);


}
