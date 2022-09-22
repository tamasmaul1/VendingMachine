package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    static String COMMANDOPTIONS = "fill(balance), buy, exit";
    static int BALANCE = 0;

    public static void run(ArrayList<Item> inventory) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ented the command you want to use: " + COMMANDOPTIONS);
        String command = scanner.nextLine();
        while(!command.equals("exit")){
            UserInterface.processCommand(command, scanner, inventory);
            System.out.println("Ented the command you want to use: " + COMMANDOPTIONS);
            command = scanner.nextLine();
        }
        scanner.close();
    }

    private static void processCommand(String command, Scanner scanner, ArrayList<Item> inventory) {
        switch(command){
            case "fill":{
                System.out.println("Your current balance is: " + BALANCE);
                System.out.println("How much do you want to deposit?: ");
                int fill = scanner.nextInt();
                BALANCE = BALANCE + fill;
            }
            case "buy":{
                System.out.println("What do you want to buy?: ");
                String productName = scanner.nextLine();
                Item item = InventoryController.find(productName, inventory);
                if(item != null){
                    if(BALANCE >= item.getCost()){
                        if(item.getNumOfItems() > 0){
                            System.out.println("You have bought a(n) " + item.getName());
                            item.setNumOfItems(item.getNumOfItems()-1);
                            BALANCE = BALANCE - item.getCost();
                            System.out.println("Your remaining balance is: " + BALANCE);
                        }
                        else{
                            System.out.println("Sorry, we are out of " + item.getName());
                        }
                    }
                    else{
                        System.out.println("You dont have enough credit");
                    }
                }
                else{
                    System.out.println("There is no product with this name.");
                }
            }
        }

    }

    public static void printInventory(ArrayList<Item> inventory) {
        for(Item item : inventory){
            System.out.println(item.getData());
        }
    }
}
