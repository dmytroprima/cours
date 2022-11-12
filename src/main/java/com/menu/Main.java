package com.menu;

import com.candy.ChocolateWithFillings;
import com.candy.FruitJelly;
import com.candy.Lollipops;
import com.functional.Gift;
import com.functional.Store;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class Main {
    private static  final Logger logger = LoggerFactory.getLogger(Main.class);

    static List<Gift> giftsList = new ArrayList<>();
    static Store store = new Store(
    new ChocolateWithFillings("korivka", 20, 15, 5, "caramel"),
    new FruitJelly("bdjilka", 15, 8, 3, "orange"),
    new Lollipops("diushes", 20, 10, 3, "pear"));
    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();
        while (true){
            System.out.print("Select command:" + mainMenu.getCommands() +"\nYour command: ");
            String command = scan.next();
            mainMenu.execute(command);
        }
    }

    public static Gift createGift(){
        logger.info("Start of work");
        System.out.print("Enter gift name: ");
        String name = scan.next();
        Gift gift = new Gift(name);
        while (true){
            System.out.println("Store");
            System.out.println(store.getStore());
            System.out.print("Select candy (Enter \"save\" if gift are ready):");
            String candyName = scan.next();
            if (candyName.equals("save")){
                break;
            }
            if(store.isCandyAvailable(candyName)){
                gift.addCandy(store.returnCandy(candyName));
            }
        }
        giftsList.add(gift);
        return gift;
    }

    static public Gift sortGift(){
        Gift currentGift = findGift();
        System.out.print("Available parameters for sorting of gift composition - ABC, sugar\nSorting by the: ");
        String param = scan.next();
        currentGift.sortGift(param);
        return currentGift;
    }

    static public void printGiftComposition(){
        Gift currentGift = findGift();

        while (true){
            System.out.println(currentGift.getCandies());
            System.out.println("Final price: " + currentGift.priceGift());
            System.out.print("Delete candy(\"save\" for exit): ");
            String candyName = scan.next();
            if (candyName.equals("save")){
                break;
            }
            currentGift.deleteCandy(candyName);
        }
    }

    static public void deleteGift(){
        System.out.print("List of Gifts: ");
        for (Gift gift:giftsList){
            System.out.print(gift.getGiftName()+" ");
        }
        System.out.print("\nSelect gift for deleting: ");
        String giftName = scan.next();
        for (Gift gift:giftsList){
            if (gift.getGiftName().equals(giftName)){
                giftsList.remove(gift);
                break;
            }
        }
    }

    static public Gift findGift(){
        System.out.print("List of Gifts: ");
        for (Gift gift:giftsList){
            System.out.print(gift.getGiftName()+" ");
        }
        System.out.print("\nSelect gift: ");
        String giftName = scan.next();
        Gift currentGift = null;
        for (Gift gift:giftsList){
            if (gift.getGiftName().equals(giftName)){
                currentGift =  gift;
            }
        }
        return currentGift;
    }
}