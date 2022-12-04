package com.candy;

public class Candy {
    protected String name;
    protected int weight;
    protected int sugarContent;
    protected int price;

    public Candy(String name, int weight, int sugar_content, int price){
        this.name = name;
        this.price = price;
        this.sugarContent = sugar_content;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getSugarContent() {
        return sugarContent;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return "Name: " + this.name + " weight: " + this.weight + " price: "+ this.price + " sugar content: "+ this.sugarContent;
    }
}
