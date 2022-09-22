package com.example;

import java.util.ArrayList;

public final class App {
    public static void main(String[] args) {
        ArrayList<Item> inventory = InventoryController.OpenLibrary();
        UserInterface.printInventory(inventory);
        UserInterface.run(inventory);
        InventoryController.CloseLibrary(inventory);
    }
}
