package com.candy;

public class GlazedLiquor extends Candy{
    private int amountOfLiquor;

    public GlazedLiquor(String name, int weight, int sugar_content, int price, int amountOfLiquor) {
        super(name, weight, sugar_content, price);
        this.amountOfLiquor = amountOfLiquor;
    }
}
