/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mco2gui;
import java.util.ArrayList;
import java.util.List;

/**
 * The RVM class represents a regular vending machine that sells milktea of varying
 * flavors. it can also execute maintenance commands such as replenishing the stock 
 * and setting the price. 
 */
public class RVM{  
    
    protected int stock;
    protected Flavor flavor;
    protected Milktea milktea = new Milktea();
    protected Money rvmMoney = new Money();      
    protected Money userMoney = new Money(); 
    protected Money userChange = new Money();
    protected int change;
    protected Receipt receipt = new Receipt();
    protected ArrayList <Receipt> receiptList = new ArrayList<>();
    protected boolean notValid;
    protected ArrayList <Integer> payment = new ArrayList<>();
    
    /**
     * Class constructor that sets the stock for all the flavors of milktea
     * in this class
     * 
     * @param stock1 the initial amount of items in a single slot of milktea.
     */
    public RVM (int stock1) {

        
        this.stock = stock1;
        
        int k = 0;
        for (Flavor fl: Flavor.values()){
            fl.setStock(stock);
            
            k++;
        }
    }
    
    /**
     * Inserts money into the vending machine in denominations of 1, 5, 10
     * 20, 50, and 100 pesos and checks if the inserted money is valid
     * 
     * @param fund The amount of money inserted as payment.
     * @return An integer representing the possible outcomes of the algorithm, 
     *          with 1 being the success an d 0 being the fail outcome.
     */
    public int insertMoney(int fund){
        
        int nReturn;
        
        userMoney.clearMoney();
        userChange.clearMoney();
        if(fund == 1 || fund == 5 || fund == 10 || fund == 20 || fund == 50 || fund == 100){
            payment.add(fund);
            nReturn = 1;
            userMoney.paymentBox(payment);
        }
        else if(fund == 0){
            userMoney.paymentBox(payment);
            nReturn = 1;
        }
        else{
            userMoney.paymentBox(payment);
            nReturn = 0;
        }
       return nReturn;
    }
    /**
     * Executes the code for the vending machine features such as ordering,
     * adding computing the change, and giving the orders.
     * 
     * @param order The flavor of the milktea that is ordered.
     * @return An integer representing the result of running the method. 1 represents stock running out,
     *         2 represents not enough money, 3 represents change running out, and 4 represents a success.
     */
    public int vmFeatures (int order){ 
        int nReturn = 0;
        System.out.println(userMoney.getTotalMoney());
        do{
        flavor = milktea.convertOrder(order);
        if(flavor.getStock() <= 0){
                nReturn = 1;
                userMoney.releaseChange();
                break;
        }
        flavor.getPrice();
        if(userMoney.getTotalMoney() < flavor.getPrice()){
            nReturn = 2;
            userMoney.releaseChange();
            break;
        }
            transferMoney(rvmMoney, userMoney);
            //compute change
            change = userMoney.getTotalMoney() - flavor.getPrice();
            if (change != 0){
             if(userChange.computeChange(change, rvmMoney) == true){
                userChange.releaseChange();
            }
            else if(userChange.computeChange(change, rvmMoney) == false){
                nReturn = 3;
                transferMoney(rvmMoney, userChange);
                break;
            }
            }
            milktea.getProcess(order);

            receipt = new Receipt(flavor,userMoney, userChange);

            receiptList.add(receipt);
            flavor.setStock(flavor.getStock()-1);
            flavor.setStockBought(flavor.getStockBought()+1);
            nReturn = 4;

        } while (nReturn == 0);
      return nReturn;  
    }

    /**
     * Restocks the items in the vending machine by a certain value, up to
     * the maximum limit of the vending machine.
     * 
     * @param order The flavor of the milktea that is selected.
     * @param stock The number of items to be restocked.
     */
    public void stock (int order, int stock) {
        flavor = milktea.convertOrder(order);
        flavor.setStock((flavor.getStock() + stock));
       
        List<Receipt> itemsToRemove = new ArrayList<>();
        for (Receipt r : receiptList) {
            if (flavor.equals(r.getFlavor())){
                itemsToRemove.add(r);
            }
        }
        receiptList.removeAll(itemsToRemove);
        flavor.setStockBought(0);

    }
    
    /**
     * Gets the stock of the selected flavor of the item.
     * 
     * @param order The flavor of the milktea that is selected.
     * @return An integer value representing the stock of the selected item.
     */
    public int getFlavorStock(int order){
        flavor = milktea.convertOrder(order);
        return flavor.getStock();
    }
    
    /**
     * Changes the price of a certain item in the vending machine into 
     * the price inputted by the user.
     * 
     * @param order The flavor of the milktea that is selected.
     * @param price the new price for the selected item.
     */
    public void price (int order, int price){ 
        flavor = milktea.convertOrder(order);
        flavor.setPrice(price);
    }
    
    /**
     * Gets the current price of the selected item in the vending machine
     * 
     * @param order The flavor of the milktea that is selected.
     * @return An integer value representing the price of the selected item.
     */
    public int getFlavorPrice (int order){
        flavor = milktea.convertOrder(order);
        return flavor.getPrice();
    }
    
    /**
     * Collects all the money inside the vending machine, including the money used as change.
     * 
     * @return An integer value representing the total mount of money inside
     */
    public String collectMoney (){ 
        String temp = "Total Money: " + rvmMoney.getTotalMoney();
        rvmMoney.clearMoney();
        return temp;
    }
    
    /**
     * Replenishes the money inside the vending machine with the denominations 1, 5, 10, 20, 50, and 100.
     * 
     * @param one Variable for the one peso denomination
     * @param five Variable for the five peso denomination
     * @param ten Variable for the ten peso denomination
     * @param twenty Variable for the twenty peso denomination
     * @param fifty Variable for the fifty peso denomination
     * @param oneHun  Variable for the one hundred peso denomination
     */
    public void replenishMoney (int one, int five, int ten, int twenty, int fifty, int oneHun){
        
        rvmMoney.setPiso(rvmMoney.getPiso()+one); 
        rvmMoney.setFive(rvmMoney.getFive()+five); 
        rvmMoney.setTen(rvmMoney.getTen()+ten); 
        rvmMoney.setTwenty(rvmMoney.getTwenty()+twenty); 
        rvmMoney.setFifty(rvmMoney.getFifty()+fifty); 
        rvmMoney.setOneHundred(rvmMoney.getOneHundred()+oneHun);
    }

    /**
     * Prints the summary of transactions that happened since last restocking.
     * It displays the receipts and the amount the is sold from each item.
     */
    public void printSummary(){
        System.out.println("\n\nSummary of all transactions, items sold, and total sales.");
        System.out.println(receiptList.get(0));
        System.out.println("Items Bought:");
        for (Flavor fl: Flavor.values())
            System.out.println(fl.name() + ": " + fl.getStockBought());
        flavor.clearSales();
        
    }

    /**
     * Displays all the receipts from previous transactions.
     * 
     * @return A String variable representing the receipts
     */
    public String displayAllReceipt(){ //MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM//
        String display = "";
        
        for (Receipt r: receiptList){
            display += r.displayCurrentReceipts();
        }
        return ("<html>" +"<body>" +"<p>" +"Total Sales since the previous stocking: " + flavor.getSales() +"</p>" +display +"</body>" +"</html>");
    }

    /**
     * Transfers the money in denominations from one Money class into another
     * @param reciever Money class that receives the denominations
     * @param sender Money class that sends the denominations
     */
    public void transferMoney(Money reciever, Money sender){
        reciever.setOneHundred(reciever.getOneHundred() + sender.getOneHundred());
        reciever.setFifty(reciever.getFifty() + sender.getFifty());
        reciever.setTwenty(reciever.getTwenty() + sender.getTwenty());
        reciever.setTen(reciever.getTen() + sender.getTen());
        reciever.setFive(reciever.getFive() + sender.getFive());
        reciever.setPiso(reciever.getPiso() + sender.getPiso());
    }   

    /**
     * Gets the stock value of the vending machine
     * 
     * @return An integer of the stock value.
     */
    public int getStock(){
        return stock;
    }
    
  
    
}
