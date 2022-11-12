package com.candy;

public class Lollipops extends Candy{
    private String taste;

    public Lollipops(String name, int weight, int sugar_content, int price, String taste) {
        super(name, weight, sugar_content, price);
        this.taste = taste;
    }
}
