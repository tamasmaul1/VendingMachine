package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryController {

    public static Item find(String productName, ArrayList<Item> inventory){
        for(Item item : inventory){
            if(item.getName().equals(productName)){
                return item;
            }
        }
        return null;
    }


    public static ArrayList<Item> OpenLibrary(){
        try{
            File file = new File("Inventory.txt");
            if (file.exists()) {
                FileReader fr = new FileReader(file);
                Scanner scanner = new Scanner(fr);
                ArrayList<Item> inventory = new ArrayList<Item>();
                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    String[] data = line.split(",",3);
                    Item item = new Item();
                    item.setData(data[0], data[1], data[2]);
                    inventory.add(item);
                }
                scanner.close();
                
                return inventory;
            }
            else{
                file.createNewFile();
                System.out.println("File created");
            }
        }
        catch(IOException e){
            System.out.println("IOException Occured");
            e.printStackTrace();
            return null;
        }
        return null;
    }


    public static void CloseLibrary(ArrayList<Item> inventory){
        try{
            File file = new File("inventory.txt");
            if (file.exists()) {
                FileWriter fw = new FileWriter(file);
                for(Item item : inventory){
                    fw.write(item.getName() + "," + item.getCost() + "," + item.getNumOfItems());
                    fw.write(System.getProperty( "line.separator" ));
                }
                fw.close();
            }
        }
        catch(IOException e){
            System.out.println("IOException Occured");
                e.printStackTrace();
        }
    }
}
