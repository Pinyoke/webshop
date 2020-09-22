package com.clothesshop.clothesshop.modell;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class FilterTemplate {

    private int priceMin;
    private int priceMax;
    private String sex;
    private String category;
    private String brand;

}
