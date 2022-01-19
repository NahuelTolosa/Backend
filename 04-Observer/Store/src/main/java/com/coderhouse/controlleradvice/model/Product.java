package com.coderhouse.controlleradvice.model;

public class Product {

    private String id;
    private String title;
    private Double price;
    private String thumbnail;

    public Product() {

    }

    public Product(String title, Double price, String thumbnail) {
        //Momentaneamente hasta que se implemente db
        this.id = String.valueOf((int) (Math.random() * 1001));
        this.title = title;
        this.price = price;
        this.thumbnail = thumbnail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
