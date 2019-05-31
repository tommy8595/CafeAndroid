package com.example.myapplication.data;

public class DataProduct {

    private String pro_code;
    private Integer pro_cover;
    private String pro_name;
    private String pro_cate;
    private double pro_price;

    public DataProduct(String code, Integer cover, String name, String cate, double price){
        this.pro_code = code;
        this.pro_cover = cover;
        this.pro_name = name;
        this.pro_cate = cate;
        this.pro_price = price;
    }

    public void setProCode(String code){
        this.pro_code = code;
    }

    public void setProCover(Integer cover){
        this.pro_cover = cover;
    }

    public void setProName(String name){
        this.pro_name = name;
    }
    public void setProCate(String cate){
        this.pro_cate = cate;
    } public void setProPrice(double price){
        this.pro_price = price;
    }

    public String getProCode() { return this.pro_code;}
    public Integer getProCover() { return this.pro_cover;}
    public String getProName() { return this.pro_name;}
    public String getProCate() {return this.pro_cate;}
    public double getProPrice() {return this.pro_price;}
}
