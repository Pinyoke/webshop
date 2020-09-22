package com.clothesshop.clothesshop.repository;

import com.clothesshop.clothesshop.modell.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


    List<Product> findAll();

    List<Product> findByBrand(String brand);

    @Query(value = "SELECT * " +
            "FROM Products p " +
            "WHERE p.brand LIKE ?1 " +
            "and p.category LIKE ?2 " +
            "and p.sex like ?3 " +
            "and p.price >= ?4 " +
            "and p.price <= ?5", nativeQuery = true)
    List<Product> filteredProductList(String brand,String category, String sex, int priceMin, int priceMax);

}
