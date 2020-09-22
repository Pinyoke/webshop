package com.clothesshop.clothesshop.service;

import com.clothesshop.clothesshop.modell.FilterTemplate;
import com.clothesshop.clothesshop.modell.Product;
import com.clothesshop.clothesshop.modell.Stock;
import com.clothesshop.clothesshop.repository.ProductRepository;
import com.clothesshop.clothesshop.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final StockRepository stockRepository;

    public ProductServiceImp(ProductRepository productRepository, StockRepository stockRepository) {
        this.productRepository = productRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        for (Stock stock: product.getStockList())
        {
            stock.setProduct(product);
        }
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getFilteredProducts(FilterTemplate filterTemplate) {
        List<Product> productList = productRepository.filteredProductList(filterTemplate.getBrand(),filterTemplate.getCategory(),filterTemplate.getSex(),filterTemplate.getPriceMin(),filterTemplate.getPriceMax());

        return productList;
    }
}
