package com.example;

public class Item {
    private String name;
    private int cost;
    private int numOfItems;

    public String getName(){
        return this.name;
    }
    public void SetName(String name){
        this.name = name;
    }
    public int getCost(){
        return this.cost;
    }
    public int getNumOfItems(){
        return this.numOfItems;
    }
    public void setNumOfItems(int numOfItems){
        this.numOfItems = numOfItems;
    }

    public void setData(String name, String cost, String numOfItems){
        this.name = name;
        this.cost = Integer.valueOf(cost);
        this.numOfItems = Integer.valueOf(numOfItems);
    }
    public String getData() {
        return "ProductName: "+this.name+", Cost: "+this.cost+", NumItems: "+this.numOfItems;
    }
    
}
