package com.candy;

public class ChocolateWithFillings extends Candy{
    private String fillingsType;

    public ChocolateWithFillings(String name, int weight, int sugar_content, int price, String fillingsType) {
        super(name, weight, sugar_content, price);
        this.fillingsType = fillingsType;
    }
}
