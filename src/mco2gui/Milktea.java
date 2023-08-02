/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mco2gui;

/**
 * The Milktea class handles the milktea flavors
 * and their conversion in the RVM code. It also handles the
 * descriptions on the processes of the flavors.
 */
public class Milktea {
    private Flavor flavor; 

    /**
     * Displays the items that are sold in this vending machine
     */
    public void displayItems(){ // lagay slots

        System.out.println(Designs.BLUE_U + "[1] Matcha Milktea            "  + "P "+ Flavor.Matcha.getPrice() +         "   Calories: " + Flavor.Matcha.getCalories() +          "   Stock: " + Flavor.Matcha.getStock()+Designs.RESET);   //cutting grass....
        System.out.println(Designs.BLUE_U + "[2] Wintermelon Milktea       "  + "P "+ Flavor.Wintermelon.getPrice() +    "   Calories: " + Flavor.Wintermelon.getCalories() +     "   Stock: " + Flavor.Wintermelon.getStock()+Designs.RESET); // freezing melons...
        System.out.println(Designs.BLUE_U + "[3] Okinawa Milktea           "  + "P "+ Flavor.Okinawa.getPrice() +        "   Calories: " + Flavor.Okinawa.getCalories() +         "   Stock: " + Flavor.Okinawa.getStock()+Designs.RESET);  // Travelling to Japan...
        System.out.println(Designs.BLUE_U + "[4] Coffee Milktea            "  + "P "+ Flavor.Coffee.getPrice() +         "   Calories: " + Flavor.Coffee.getCalories() +          "   Stock: " + Flavor.Coffee.getStock()+Designs.RESET);   // Waking you up....
        System.out.println(Designs.BLUE_U + "[5] Red Velvet Milktea        "  + "P "+ Flavor.Redvelvet.getPrice() +      "   Calories: " + Flavor.Redvelvet.getCalories() +       "   Stock: " + Flavor.Redvelvet.getStock()+Designs.RESET); // Listening to Kpop....
        System.out.println(Designs.BLUE_U + "[6] Taro Milktea              "  + "P "+ Flavor.Taro.getPrice() +           "   Calories: " + Flavor.Taro.getCalories() +            "   Stock: " + Flavor.Taro.getStock()+Designs.RESET); // What even is taro?...
        System.out.println(Designs.BLUE_U + "[7] Chocolate Milktea         "  + "P "+ Flavor.Chocolate.getPrice() +      "   Calories: " + Flavor.Chocolate.getCalories() +       "   Stock: " + Flavor.Chocolate.getStock()+Designs.RESET);    // going to Willy Wonka....
        System.out.println(Designs.BLUE_U + "[8] Hokkaido Milktea          "  + "P "+ Flavor.Hokkaido.getPrice() +       "   Calories: " + Flavor.Hokkaido.getCalories() +        "   Stock: " + Flavor.Hokkaido.getStock()+Designs.RESET); // Also travelling to Japan...
        System.out.println(Designs.BLUE_U + "[9] Cookies and Cream Milktea "  + "P "+ Flavor.CookiesAndCream.getPrice() +"   Calories: " + Flavor.CookiesAndCream.getCalories() + "   Stock: " + Flavor.CookiesAndCream.getStock()+Designs.RESET);  // Creaming the Cookies....
        System.out.println(Designs.BLUE_U + "[10] Classic Milktea          "  + "P "+ Flavor.Classic.getPrice() +        "   Calories: " + Flavor.Classic.getCalories() +         "   Stock: " + Flavor.Classic.getStock()+Designs.RESET); // Unranked Milk tea...
    }

    /**
     * Converts a value of int from order into a specific string variable
     * 
     * @param order Int variable that will be converted into string
     * @return Flavor class with a value of the converted order variable.
     */
    public Flavor convertOrder (int order){
        String fl="";
        switch (order){
            case 1: fl = "Matcha";break;
            case 2: fl = "Wintermelon";break;
            case 3: fl = "Okinawa";break;
            case 4: fl = "Coffee";break;
            case 5: fl = "Redvelvet";break;
            case 6: fl = "Taro";break;
            case 7: fl = "Chocolate";break;
            case 8: fl = "Hokkaido";break;
            case 9: fl = "CookiesAndCream";break;
            case 10: fl = "Classic";break;
        }
           flavor = Flavor.valueOf(fl);

           return flavor;
      }
     
    /**
     * Gets the process of creating the item in this vending machine.
     * 
     * @param order variable that gets the order input of the user
     */
    public String getProcess (int order){
        flavor = convertOrder(order);
        String nReturn = ""; 

        switch(flavor){
            case Matcha:    nReturn = "Cutting grass \n"; break;
            case Wintermelon:   nReturn = "freezing melons"; break;
            case Okinawa:       nReturn ="Travelling to Japan..."; break;
            case Coffee: nReturn = " Waking you up...."; break;
            case Redvelvet: nReturn = "Listening to Kpop..."; break;
            case Taro: nReturn = "What even is taro?..."; break;
            case Chocolate: nReturn = "Going to Willy Wonka..."; break;
            case Hokkaido: nReturn = "Also travelling to Japan..."; break;
            case CookiesAndCream: nReturn = "Creaming the Cookies...."; break;
            case Classic: nReturn = "Unranked Milk tea..."; break;
        }
        return nReturn;
    }
}
