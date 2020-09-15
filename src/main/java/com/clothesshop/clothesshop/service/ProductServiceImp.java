package com.clothesshop.clothesshop.service;

import com.clothesshop.clothesshop.modell.FilterTemplate;
import com.clothesshop.clothesshop.modell.Product;
import com.clothesshop.clothesshop.modell.Stock;
import com.clothesshop.clothesshop.repository.ProductRepository;
import com.clothesshop.clothesshop.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        List<Product> productList =  productRepository.findAll();
        List<Product> sprtedList;
        if(!filterTemplate.getBrand().equals("")){
            sprtedList = new ArrayList<>();
            for (Product product: productList) {
                if(product.getBrand().equals(filterTemplate.getBrand())){
                    sprtedList.add(product);
                }
            }
            productList = sprtedList;
        }


        if(!filterTemplate.getCategory().equals("")){
            sprtedList = new ArrayList<>();
            for (Product product: productList) {
                if(product.getCategory().equals(filterTemplate.getCategory())){
                    sprtedList.add(product);
                }
            }
            productList = sprtedList;
        }


        if(!filterTemplate.getSex().equals("")){
            sprtedList = new ArrayList<>();
            for (Product product: productList) {
                if(product.getSex().equals(filterTemplate.getSex())){
                    sprtedList.add(product);
                }
            }
            productList = sprtedList;
        }
        if(filterTemplate.getPriceMax() > 0){
            sprtedList = new ArrayList<>();
            for (Product product: productList) {
                if(product.getPrice() <= filterTemplate.getPriceMax()){
                    sprtedList.add(product);
                }
            }
            productList = sprtedList;
        }
        if(filterTemplate.getPriceMin() > 0){
            sprtedList = new ArrayList<>();
            for (Product product: productList) {
                if(product.getPrice() >= filterTemplate.getPriceMin()){
                    sprtedList.add(product);
                }
            }
            productList = sprtedList;
        }


        return productList;
    }
}
