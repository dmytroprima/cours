package com.candy;

public class FruitJelly extends Candy{
    private String fruitType;

    public FruitJelly(String name, int weight, int sugar_content, int price, String fruit_type) {
        super(name, weight, sugar_content, price);
        this.fruitType = fruit_type;
    }
}
