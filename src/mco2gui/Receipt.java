/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mco2gui;
import java.util.ArrayList;
/**
 * Receipt is the class that generates and stores the receipts from both
 * regular and special vending machines.
 */
public class Receipt {
    private Flavor flavor;
    private Money userMoney;
    private Money userChange;
    private ArrayList<Integer> orderList = new ArrayList<Integer>();
    
    /**
     * Class constructor that initializes the following variables into the class
     * 
     * @param flavor Flavor variable of the item bought
     * @param userMoney Money variable that the user entered
     * @param userChange Money variable that the user will recieve as change
     */
    public Receipt(Flavor flavor,Money userMoney, Money userChange){
        this.flavor = flavor;
        this.userMoney = userMoney;
        this.userChange = userChange;
    }
    
    /**
     * Class constructor that initializes the following variables into the class
     * 
     * @param orderList ArrayList for the AddOns items.
     * @param userMoney Money variable that the user entered
     * @param userChange Money variable that the user will recieve as change
     */
    public Receipt(ArrayList <Integer> orderList,Money userMoney, Money userChange){
        this.orderList = orderList;
        this.userMoney = userMoney;
        this.userChange = userChange;
    }

    /**
     * Class constructor that initializes this receipt class
     */
    public Receipt (){

    }

    /**
     * Displays the current receipt
     * 
     * @return String variable of the receipt
     */
    public String displayCurrentReceipts(){
        String display =    
        "<p>=====================</p>" +
        "<p>      Receipt        </p>" +
        "<p>=====================</p>" +
        "<p>Item: " +  flavor.name() +"(Cal:" + flavor.getCalories() + ")" + "... Price: P " + flavor.getPrice() + "</p>" + 
        "<p> Inserted Money: " + userMoney.getTotalMoney() + "</p>" + 
        "<p> Change: " + userChange.getTotalMoney() + "</p>" +
        "<p>Thank you for using our vending machine!</p>" +
        "<p>=====================</p>" ;

        return display;
    }

    /**
     * Gets the Flavor variable for this receipt
     * 
     * @return flavor variable
     */
    public Flavor getFlavor (){
        return flavor;
    }

    /**
     * Gets the user's money entered
     * 
     * @return user's money
     */
    public Money getUserMoney (){
        return userMoney;
    }

    /**
     * Gets the user's change to be given
     * 
     * @return user's change
     */
    public Money getUserChange (){
        return userChange;
    }

    /**
     * Gets the orderList of the receipts class
     * 
     * @return ArrayList variable representing the orderList.
     */
    public ArrayList<Integer> getOrderList() {
        return orderList;
    }
    }