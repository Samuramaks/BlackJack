package com.example;

public class Cards {
    public String name;
    public int price;

    public Cards(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void Enter() {
        System.out.println(String.format("Name: %s\nprice: %d", name, price));
    }
}
