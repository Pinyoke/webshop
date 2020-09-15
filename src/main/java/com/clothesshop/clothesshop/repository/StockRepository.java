package com.clothesshop.clothesshop.repository;

import com.clothesshop.clothesshop.modell.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {
}
