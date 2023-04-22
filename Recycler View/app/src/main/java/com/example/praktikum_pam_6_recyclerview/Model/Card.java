package com.example.praktikum_pam_6_recyclerview.Model;

public class Card {
    String name, phoneNumber;
    int image;

    public Card(String name, int image, String phoneNumber) {
        this.name = name;
        this.image = image;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
