package com.example.myfood_nhduong;

public class Food_NHDuong {
    private int id;
    private String name;
    private int price;
    private int restaurantId;
    private String image;

    // Constructor đầy đủ
    public Food_NHDuong(int id, String name, int price, int restaurantId, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.restaurantId = restaurantId;
        this.image = image;
    }

    // Constructor không có id (khi thêm mới)
    public Food_NHDuong(String name, int price, int restaurantId, String image) {
        this.name = name;
        this.price = price;
        this.restaurantId = restaurantId;
        this.image = image;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
