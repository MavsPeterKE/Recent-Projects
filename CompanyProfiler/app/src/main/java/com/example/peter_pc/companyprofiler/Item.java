package com.example.peter_pc.companyprofiler;

/**
 * Created by Peter-PC on 11/28/2016.
 */

public class Item {
    private String name,email,phone,location;
    String imgUrl;
    int img;

    public Item(String name, String email, String phone, String location, String imgUrl) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.imgUrl = imgUrl;
    }

    public Item(String name, String email, String phone, String location) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.location = location;
    }

    public Item(String name, String email, String phone, String location, int img) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.img = img;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLocation() {
        return location;
    }
}
