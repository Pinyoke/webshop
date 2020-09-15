package com.clothesshop.clothesshop.modell;

public class FilterTemplate {

    private int priceMin;
    private int priceMax;
    private String sex;
    private String category;
    private String brand;

    public FilterTemplate() {
    }

    public FilterTemplate(int priceMin, int priceMax, String sex, String category, String brand) {
        this.priceMin = priceMin;
        this.priceMax = priceMax;
        this.sex = sex;
        this.category = category;
        this.brand = brand;
    }

    public int getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(int priceMin) {
        this.priceMin = priceMin;
    }

    public int getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(int priceMax) {
        this.priceMax = priceMax;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
