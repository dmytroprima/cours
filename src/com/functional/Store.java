package com.functional;

import com.candy.Candy;
import com.candy.ChocolateWithFillings;
import com.candy.FruitJelly;
import com.candy.Lollipops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store {
    private List<Candy> storeList = new ArrayList<>();

    public Store(Candy ... candies){
        storeList.addAll(Arrays.asList(candies));
    }

    public List<Candy> getStore(){
        return storeList;
    }

    public boolean isCandyAvailable(String name){
        for(Candy candy : storeList)
            if (candy.getName().equals(name)){
                return true;
            }
        return false;
    }

    public Candy returnCandy(String name){
        Candy current = null;
        for(Candy candy : storeList)
            if (candy.getName().equals(name)){
                current = candy;
            }
        return current;
    }
}