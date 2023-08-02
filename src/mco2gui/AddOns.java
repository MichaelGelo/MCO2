/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mco2gui;

/**
 * The AddOns class is the superclass for the items
 * in the special vending machine. It contains the 
 * price, calories, and descriptions of the items.
 */
public class AddOns {

    protected int price;
    protected float calories;
    protected String description;
    
    /**
     * Constructor for the AddOns class.
     */
    public AddOns(){

    }
    /**
     * Constructor for the AddOns class
     * 
     * @param price The price of the item
     * @param calories The calories of the item
     * @param description  The process of preparing the item
     */
    public AddOns(int price,float calories,String description){
        this.price = price;
        this.calories = calories;
        this.description = description;
    }
    
    /**
     * Sets the price of the AddOns
     * 
     * @param price The price of the item
     */
    public void setPrice (int price){
        this.price = price;
    }
    
    /**
     * gets the price of the AddOns
     * 
     * @return An integer value of the price of the AddOns 
     */
    public int getPrice() {
        return price;
    }
    
    /**
     * Gets the calories of the AddOns
     * 
     * @return An integer value of the calories of the AddOns.
     */
    public float getCalories() {
        return calories;
    }
    
    /**
     * Gets the description of the AddOns
     * 
     * @return A String variable representing the description of the AddOns.
     */
    public String getDescription(){
        return description;
    }
}
