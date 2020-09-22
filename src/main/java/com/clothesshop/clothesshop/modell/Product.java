package com.clothesshop.clothesshop.modell;



import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "Products")
@Entity
@NoArgsConstructor
public class Product extends BaseEntity{

    private String name;

    private int price;
    private String currency;
    private String description;
    private String sex;
    private String category;
    private String brand;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Stock> stockList;

    private String imageUrl;


}
