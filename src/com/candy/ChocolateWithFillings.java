package com.candy;

public class ChocolateWithFillings extends Candy{
    private String fillingsType;

    public ChocolateWithFillings(String name, int weight, int sugar_content, int price, String fillings_type) {
        super(name, weight, sugar_content, price);
        this.fillingsType = fillings_type;
    }
}
