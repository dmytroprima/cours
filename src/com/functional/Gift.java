package com.functional;

import com.candy.Candy;

import java.util.*;

public class Gift {
    private String name;
    private List<Candy> candies;

    public Gift(String name) {
        candies = new ArrayList<>();
        this.name = name;
    }

    public String getGiftName(){
        return this.name;
    }

    public List<Candy> getCandies(){
        return candies;
    }

    public void addCandy(Candy candy){
        this.candies.add(candy);
    }

    public int priceGift(){
        int price =0;
        for (Candy candy:candies){
            price += candy.getPrice();
        }
        return price;
    }

    public void deleteCandy(String candyName){
        for (Candy candy:candies){
            if (candy.getName().equals(candyName)){
                this.candies.remove(candy);
                return;
            }
        }
        System.out.println("Incorrect name of candy!");
    }

    public void sortGift(String param) {
        while (true) {
            if (param.equals("ABC")) {
                Collections.sort(candies, new Comparator<Candy>() {
                    @Override
                    public int compare(Candy o1, Candy o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                return;
            }else if (param.equals("sugar")) {
                Collections.sort(candies, new Comparator<Candy>() {
                    @Override
                    public int compare(Candy o1, Candy o2) {
                        return -(o1.getSugarContent() - o2.getSugarContent());
                    }
                });
                return;
            }
            else
                System.out.println("Incorrect parameter for sorting");
        }
    }
}