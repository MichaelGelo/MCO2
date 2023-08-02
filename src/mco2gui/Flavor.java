/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mco2gui;

/**
 * The Flavor class is the enum values of the flavors in the RVM.
 * It handles the stock, price, adn description of the flavors in
 * the RVM.
 */
public enum Flavor {
    Matcha(115,280f,0,0,"Cutting grass..."),
    Wintermelon (102,157f,0,0,"Freezing melons..."),
    Okinawa (121,185f,0,0,"Travelling to Japan..."),
    Coffee (145,215f,0,0,"Waking you up...."),
    Redvelvet (123,500f,0,0,"Listening to Kpop..."),
    Taro (105,278f,0,0,"What even is taro?..."),
    Chocolate (115,361f,0,0,"Going to Willy Wonka..."),
    Hokkaido (110,224f,0,0,"Also travelling to Japan..."),
    CookiesAndCream (102,852f,0,0,"Creaming the Cookies...."),
    Classic (101,450f,0,0,"Unranked Milk tea...");
    
    private float calories;
    private int stock;
    private int price;
    private int stockBought;
    private int sales;
    private String description;

    /**
     * Enum constructor for the Flavor variables
     * 
     * @param price variable for the price of the items
     * @param calories variable for the calories of the items
     * @param stock variable for the stock of the items
     * @param stockBought variable for the amount sold from each items
     */
    Flavor(int price, float calories,int stock, int stockBought,String description) {
        this.price = price;
        this.calories = calories;
        this.stock = stock;
        this.description = description;
    }

    /**
     * Sets the variable for this price
     * 
     * @param price variable of the price
     */
    public void setPrice (int price){
        this.price = price;
    }

    /**
     * Sets the variable for this stock
     * 
     * @param stock variable of the stock
     */
    public void setStock (int stock){
        this.stock = stock;
    }
    
    /**
     * Sets the variable for this calories
     * @param calories variable of the calories
     */
    public void setCalories (float calories){
        this.calories = calories;
    }
    
    /**
     * Sets the variable for this stock bought
     * @param stockBought variable of the stock bought
     */
    public void setStockBought (int stockBought){
        this.stockBought = stockBought;
    }


    /**
     * Gets the price of this item
     * 
     * @return variable for the price
     */
    public int getPrice() {
        return price;
    }
    
    /**
     * Gets the calories of this item
     * 
     * @return variable for the calories
     */
    public float getCalories() {
        return calories;
    }

    /**
     * Gets the stock of this item
     * 
     * @return variable for the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Gets the stock bought of this item
     * 
     * @return variable for the stock bought
     */
    public int getStockBought() {
        return stockBought;
    }

    public String getDescription() {
        return description;
    }
    /**
     * Gets the total sales of all the enum variables
     * 
     * @return variable for total sales
     */
    public int getSales(){
        this.sales += Matcha.getPrice() * Matcha.getStockBought();
        this.sales += Wintermelon.getPrice() * Wintermelon.getStockBought();
        this.sales += Okinawa.getPrice() * Okinawa.getStockBought();
        this.sales += Coffee.getPrice() * Coffee.getStockBought();
        this.sales += Redvelvet.getPrice() * Redvelvet.getStockBought();
        this.sales += Taro.getPrice() * Taro.getStockBought();
        this.sales += Chocolate.getPrice() * Chocolate.getStockBought();
        this.sales += Hokkaido.getPrice() * Hokkaido.getStockBought();
        this.sales += CookiesAndCream.getPrice() * CookiesAndCream.getStockBought();
        this.sales += Classic.getPrice() * Classic.getStockBought();
        
        return this.sales;
    }

    /**
     * Clears the sales for a specific enum variable
     */
    public void clearSales(){
        this.sales = 0;
    }

}
