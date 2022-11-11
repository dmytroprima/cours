package com.candy;

public class GlazedLiquor extends Candy{
    private int amountOfLiquor;

    public GlazedLiquor(String name, int weight, int sugar_content, int price, int amount_of_liquor) {
        super(name, weight, sugar_content, price);
        this.amountOfLiquor = amount_of_liquor;
    }
}
