/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mco2gui;

/**
 * The CreamCheese class is a subclass of the AddOns class for
 * a specific item called Cream Cheese
 */
public class CreamCheese extends AddOns{
    
    /**
     * Constructor for the AddOns subclass
     * 
     * @param price The price of the item
     * @param calories The calories of the item
     * @param description  The process of preparing the item
     */
    public CreamCheese (int price,float calories,String description){
        super(price,calories,description);
    }
}
