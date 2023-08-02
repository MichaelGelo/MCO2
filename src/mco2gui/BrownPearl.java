/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mco2gui;

/**
 * The BrownPearl class is a subclass of the AddOns class for
 * a specific item called brown sugar pearl
 */
public class BrownPearl extends AddOns{
    
    /**
     * Constructor for the AddOns subclass
     * 
     * @param price The price of the item
     * @param calories The calories of the item
     * @param description  The process of preparing the item
     */
    public BrownPearl (int price,float calories,String description){
        super(price,calories,description);
    }
}
