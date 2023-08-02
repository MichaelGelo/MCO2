/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mco2gui;
import java.util.ArrayList;
/**
 *  The SVM class is a special vending machine that sells a certain flavor
 * of milktea chosen at creation. It then asks the user for add-ons that will
 * be included to the creation of the milktea.
 */
public class SVM extends RVM{
    
    protected String fl;
    protected AddOns selectedFlavor;    // selected flavor of the vending machine
    protected AddOns selectedAddOns = new AddOns();  
    protected int totalPrice = 0;
    protected int totalSales = 0;
    
    //ArrayLists for the stock of each item in the vending machine
    protected ArrayList <BrownPearl> brownPearlList = new ArrayList<>();
    protected ArrayList <Tapioca> tapiocaList = new ArrayList<Tapioca>();
    protected ArrayList <PoppingBoba> poppingBobaList = new ArrayList<PoppingBoba>();
    protected ArrayList <Frappe> frappeList = new ArrayList<Frappe>();
    protected ArrayList <CreamCheese> creamCheeseList = new ArrayList<CreamCheese>();
    protected ArrayList <ChocolatePowder> chocolatePowderList = new ArrayList<ChocolatePowder>();
    protected ArrayList <NataDeCoco> nataDeCocoList = new ArrayList<NataDeCoco>();
    protected ArrayList <Lychee> lycheeList = new ArrayList<Lychee>();
    protected ArrayList <Integer> orderList = new ArrayList<Integer>(); 
    protected ArrayList <AddOns> flavorList = new ArrayList<AddOns>();
    ArrayList <String> allReceiptSVM = new ArrayList <>();
    
    // Variables for changing the price of the AddOns
    protected int price = 0;
    protected int price1 = 0;
    protected int price2 = 0;
    protected int price3 = 0;
    protected int price4 = 0;
    protected int price5 = 0;
    protected int price6 = 0;
    protected int price7 = 0;
    protected int price8 = 0;
    protected int price9 = 0;

    /**
     * Initializes the values of the special vending machine
     * 
     * @param stock Variable for the stock of the vending machine
     * @param fl Variable for the selected flavor of the milktea for the vending machine
     */
    public SVM (int stock, String fl){ // constructor
        super(stock);
        
        this.fl = fl;



        for (int i=0;i<stock;i++){
            brownPearlList.add(new BrownPearl(10, 68, "Catching fresh sugar-water clams for their pearls"));        
            tapiocaList.add(new Tapioca(5, 23, "Harboring Hawaiian pearls"));
            poppingBobaList.add(new PoppingBoba(10, 56, "Unpopping the bobas"));
            frappeList.add(new Frappe(15, 110, "Whipping the cream"));
            creamCheeseList.add(new CreamCheese(20, 120, "Cheesing the cream"));
            chocolatePowderList.add(new ChocolatePowder(10, 78, "Opening Milo packets"));
            nataDeCocoList.add(new NataDeCoco(7, 46, "Dicing the coconuts"));
            lycheeList.add(new Lychee(12, 43, "Traveling to china"));
            flavorList.add(new AddOns(Flavor.valueOf(fl).getPrice(), Flavor.valueOf(fl).getCalories(),Flavor.valueOf(fl).getDescription()));
        }
        
    }
    
    /**
     * Adds a variable of order to the orderList 
     * 
     * @param order Variable that represents the AddOn that is ordered. 
     */
    public void addToOrderList(int order){
        orderList.add(order);
    }
    
    /**
     * Executes the code for the vending machine features such as ordering,
     * adding computing the change, and giving the orders.
     * 
     * @return An integer representing the result of running the method. 1 represents stock running out,
     *         2 represents not enough money, 3 represents change running out, and 4 represents a success.
     */
    public int vmFeatures (){
    
        selectedFlavor = new AddOns(Flavor.valueOf(fl).getPrice(), Flavor.valueOf(fl).getCalories(),Flavor.valueOf(fl).getDescription() );
        int nReturn = 0;
        
        do{
            if(convertOrder(orderList) == 0){
                System.out.println("Not enough stock");
                nReturn = 1;
                break;
            }
            totalPrice = selectedFlavor.getPrice();

            for(int s:orderList){
                selectedAddOns = accessAddOns(s);
                totalPrice = totalPrice + selectedAddOns.getPrice();
            }
            change = userMoney.getTotalMoney() - totalPrice;
            
            if(userMoney.getTotalMoney() < totalPrice){
                nReturn = 2;
                userMoney.releaseChange();
                break;
            }

            if(userChange.computeChange(change, rvmMoney) == true){
                userChange.releaseChange();
            }
            else if(userChange.computeChange(change, rvmMoney) == false){
                nReturn = 3;
                transferMoney(rvmMoney, userChange);
                break;
            }
            
            allReceiptSVM.add(displaySvmReceipt(orderList, selectedFlavor));
            convertStock(orderList);
            nReturn = 4;
        } while (nReturn == 0);
        return nReturn;
    }
    
    /**
     * Checks the orderList if the item ordered has stock.
     * 
     * @param orderList Arraylist for the AddOns that are ordered.
     * @return An integer value representing the result of executing the code.
     *          1 means it is available and 0 if not.
     */
    public int convertOrder(ArrayList <Integer> orderList){
        int nReturn = 0;
        for(int s : orderList){
            switch(s) {
                case 1: if(!brownPearlList.isEmpty()){
                    nReturn = 1;} break;
                case 2: if(!tapiocaList.isEmpty()){
                    nReturn = 1;} break;
                case 3: if(!poppingBobaList.isEmpty()){
                    nReturn = 1;} break;
                case 4: if(!frappeList.isEmpty()){
                    nReturn = 1;} break;
                case 5: if(!creamCheeseList.isEmpty()){
                    nReturn = 1;} break;
                case 6: if(!chocolatePowderList.isEmpty()){
                    nReturn = 1;} break;
                case 7: if(!nataDeCocoList.isEmpty()){
                    nReturn = 1;} break;
                case 8: if(!lycheeList.isEmpty()){
                    nReturn = 1;} break;
                case 9: if(!flavorList.isEmpty()){
                    nReturn = 1;} break;
            }
        }
        return nReturn;
    }

    /**
     * Gets the orderList of the vending machine.
     * 
     * @return Arraylist of integer value that represents the orderList.
     */
    public ArrayList<Integer> getOrderList(){
        return orderList;
    }
    
    /**
     * Removes an item from the stock inside the vending machine based
     * on the list of items ordered.
     * 
     * @param orderList ArrayList containing the orders of the user.
     */
    public void convertStock(ArrayList <Integer> orderList){
        for(int s : orderList){
            switch(s) {
                case 1: if(!brownPearlList.isEmpty()){
                    brownPearlList.remove(0);} break;
                case 2: if(!tapiocaList.isEmpty()){
                    tapiocaList.remove(0);} break;
                case 3: if(!poppingBobaList.isEmpty()){
                    poppingBobaList.remove(0);} break;
                case 4: if(!frappeList.isEmpty()){
                    frappeList.remove(0);} break;
                case 5: if(!creamCheeseList.isEmpty()){
                    creamCheeseList.remove(0);} break;
                case 6: if(!chocolatePowderList.isEmpty()){
                    chocolatePowderList.remove(0);} break;
                case 7: if(!nataDeCocoList.isEmpty()){
                    nataDeCocoList.remove(0);} break;
                case 8: if(!lycheeList.isEmpty()){
                    lycheeList.remove(0);} break;
                case 9: if(!flavorList.isEmpty()){
                    flavorList.remove(0);} break;
            }
        }
    }
    
    /**
     * Converts the integer value of order into the variable AddOns that it represents
     * 
     * @param order The item that is ordered by the user.
     * @return An AddOns variable for the converted order integer.
     */
    public AddOns accessAddOns(int order){
        switch(order) {
                case 1: selectedAddOns = brownPearlList.get(0); break;
                case 2: selectedAddOns = tapiocaList.get(0); break;
                case 3: selectedAddOns = poppingBobaList.get(0); break;
                case 4: selectedAddOns = frappeList.get(0); break;
                case 5: selectedAddOns = creamCheeseList.get(0); break;
                case 6: selectedAddOns = chocolatePowderList.get(0); break;
                case 7: selectedAddOns = nataDeCocoList.get(0); break;
                case 8: selectedAddOns = lycheeList.get(0); break;
            }
        return selectedAddOns;
    }
    
    
    /**
     * Checks the remaining stock inside a specific AddOns item.
     * 
     * @param order The item that is ordered by the user.
     * @return an
     */
    public int checkRestock(int order){
        return stock - checkStock(order);
    }
    
    /**
     * Checks the amount of items in the stock of an AddOns.
     * 
     * @param order The item that is ordered by the user.
     * @return An integer representing the value of the stock or the order.
     */
    public int checkStock(int order){
        int nReturn = 0;
        switch(order) {
            case 1: nReturn = brownPearlList.size(); break;
            case 2: nReturn = tapiocaList.size(); break;
            case 3: nReturn = poppingBobaList.size(); break;
            case 4: nReturn = frappeList.size(); break;
            case 5: nReturn = creamCheeseList.size(); break;
            case 6: nReturn = chocolatePowderList.size(); break;
            case 7: nReturn = nataDeCocoList.size(); break;
            case 8: nReturn = lycheeList.size(); break;
            case 9: nReturn = flavorList.size(); break;
        }
    return nReturn;
    }

    
    /**
     * Executes the stock option in the maintenance features.
     * Restocks the AddOns items based on the input of the user, up to the
     * maximum that it can hold.
     * 
     * @param order The item that is ordered by the user.
     * @param add The amount of items to be added to the stock.
     */
    @Override
    public void stock(int order, int add){
        for(int i = 0; i < add; i++){
            if(price == 0){
                switch(order){
                    case 1: brownPearlList.add(new BrownPearl(10, 68, "Catching fresh sugar-water clams for their pearls")); break;
                    case 2: tapiocaList.add(new Tapioca(5, 23, "Harboring Hawaiian pearls"));break;
                    case 3: poppingBobaList.add(new PoppingBoba(10, 56, "Unpopping the bobas"));break;
                    case 4: frappeList.add(new Frappe(15, 110, "Whipping the cream"));break;
                    case 5: creamCheeseList.add(new CreamCheese(20, 120, "Cheesing the cream"));break;
                    case 6: chocolatePowderList.add(new ChocolatePowder(10, 78, "Opening Milo packets"));break;
                    case 7: nataDeCocoList.add(new NataDeCoco(7, 46, "Dicing the coconuts"));break;
                    case 8: lycheeList.add(new Lychee(12, 43, "Traveling to china")); break;
                    case 9: flavorList.add(new AddOns(Flavor.valueOf(fl).getPrice(), Flavor.valueOf(fl).getCalories(),Flavor.valueOf(fl).getDescription())); break;
                }
            }
            else{
                switch(order){
                    case 1: brownPearlList.add(new BrownPearl(price1, 68, "Catching fresh sugar-water clams for their pearls"));  break;
                    case 2: tapiocaList.add(new Tapioca(price2, 23, "Harboring Hawaiian pearls"));break;
                    case 3: poppingBobaList.add(new PoppingBoba(price3, 56, "Unpopping the bobas"));break;
                    case 4: frappeList.add(new Frappe(price4, 110, "Whipping the cream"));break;
                    case 5: creamCheeseList.add(new CreamCheese(price5, 120, "Cheesing the cream"));break;
                    case 6: chocolatePowderList.add(new ChocolatePowder(price6, 78, "Opening Milo packets"));break;
                    case 7: nataDeCocoList.add(new NataDeCoco(price7, 46, "Dicing the coconuts"));break;
                    case 8: lycheeList.add(new Lychee(price8, 43, "Traveling to china"));   break;
                    case 9: flavorList.add(new AddOns(price9, Flavor.valueOf(fl).getCalories(),Flavor.valueOf(fl).getDescription()));break;
                }
            }
        }
        }

    
    /**
     * Replaces the initial price of an item into a value
     * entered by the user.
     * 
     * @param order The item that is ordered by the user.
     * @param price The new price designated to the item.
     */
    @Override
    public void price(int order, int price){

        switch(order) {
                case 1: for(int i = 0; i <= brownPearlList.size(); i++){
                            brownPearlList.get(i).setPrice(price);
                            price1 = price; }
                    break;
                case 2: for(int i = 0; i <= tapiocaList.size(); i++){
                            tapiocaList.get(i).setPrice(price);
                            price2 = price; }
                    break;
                case 3: for(int i = 0; i <= poppingBobaList.size(); i++){
                            poppingBobaList.get(i).setPrice(price);
                            price3 = price;}
                    break;
                case 4: for(int i = 0; i <= frappeList.size(); i++){
                            frappeList.get(i).setPrice(price); 
                            price4 = price;}
                    break;
                case 5: for(int i = 0; i <= creamCheeseList.size(); i++){
                            creamCheeseList.get(i).setPrice(price);
                            price5 = price; }
                    break;
                case 6: for(int i = 0; i <= chocolatePowderList.size(); i++){
                            chocolatePowderList.get(i).setPrice(price); 
                            price6 = price;}
                    break;
                case 7: for(int i = 0; i <= nataDeCocoList.size(); i++){
                            nataDeCocoList.get(i).setPrice(price); 
                            price7 = price;}
                    break;
                case 8: for(int i = 0; i <= lycheeList.size(); i++){
                            lycheeList.get(i).setPrice(price); 
                            price8 = price;} break;
                case 9: for(int i = 0; i <= flavorList.size(); i++){
                            flavorList.get(i).setPrice(price); 
                            price9 = price;}
                    break;
        }
    }
    
    /**
     * Gets the price of the AddOns item asked by the user.
     * 
     * @param order The item that is ordered by the user.
     * @return An integer variable of the AddOns item price.
     */
    public int getAddOnsPrice (int order){
        int nReturn = 0;
        switch(order){
            case 1: selectedAddOns = brownPearlList.get(0);break;
            case 2: selectedAddOns = tapiocaList.get(0);break;
            case 3: selectedAddOns = poppingBobaList.get(0);break;
            case 4: selectedAddOns = frappeList.get(0);break;
            case 5: selectedAddOns = creamCheeseList.get(0);break;
            case 6: selectedAddOns = chocolatePowderList.get(0);break;
            case 7: selectedAddOns = nataDeCocoList.get(0);break;
            case 8: selectedAddOns = lycheeList.get(0);break;
            case 9: nReturn = selectedFlavor.getPrice();break;
        }
        if(order != 9){
            nReturn = selectedAddOns.getPrice();
        }
        return nReturn;
    }
    
    
   /**
    * Prints the summary of the transaction in the vending machine.
    */
    @Override
    public void printSummary(){ 
        //System.out.println("\n\nSummary of all transactions, items sold, and total sales.");
       // System.out.println(this.displayAllReceipt());
       // System.out.println(" total sales:" + totalSales);
    }

    /**
     * Displays all the receipts in this vending machine
     */
    @Override
    public String displayAllReceipt(){ 
        String display = "";
        
        for (String r: allReceiptSVM){
            display += r;
        }
        return ("<html>" +"<body>" +"<p>" +"Total Sales since the previous stocking: " + (this.totalSales/2)+"</p>"+display +"</body>" +"</html>");
    }

    
    /**
     * Displays the receipt of the vending machine which includes 
     * the order, the payment, and the change.
     * 
     * @param orderList ArrayList of the orders of the user.
     * @param fl The variable for the flavor of the milktea.
     * @return A String variable representing the receipts of the vending machine. 
     */
    public String displaySvmReceipt(ArrayList <Integer> orderList, AddOns fl) { // [][]
     
        
        String details = "";
        
        String display =
        
        "<p>=====================</p>" +
        "<p>      Receipt        </p>" +
        "<p>=====================</p>" +
        "<p>Total Price: " + totalPrice + "</p>" +
        "<p>Flavor: " + this.fl + "</p>" +
        "<p>Add Ons: </p>";

        for(int t : orderList){
            selectedAddOns = accessAddOns(t);
            switch(t) {
                case 1: if(!brownPearlList.isEmpty()){
                    details += "<p>1x BrownPearl Cal:" + selectedAddOns.getCalories()+ " P" + selectedAddOns.getPrice()+ "</p>";
                    totalSales = totalSales + selectedAddOns.getPrice();                    
                    } break;
                case 2: if(!tapiocaList.isEmpty()){
                    details += "<p>1x Tapioca Cal:" + selectedAddOns.getCalories()+ " P"+ selectedAddOns.getPrice()+ "</p>";
                    totalSales = totalSales + selectedAddOns.getPrice();                    
                    } break;
                case 3: if(!poppingBobaList.isEmpty()){
                    details += "<p>1x Popping Boba Cal:" + selectedAddOns.getCalories()+ " P" + selectedAddOns.getPrice()+ "</p>";
                    totalSales = totalSales + selectedAddOns.getPrice();
                    
                    } break;
                case 4: if(!frappeList.isEmpty()){
                    details += "<p>1x Frappe Cal:" + selectedAddOns.getCalories()+ " P" + selectedAddOns.getPrice()+ "</p>";
                    totalSales = totalSales + selectedAddOns.getPrice();
                    
                    } break;
                case 5: if(!creamCheeseList.isEmpty()){
                    details +=  "<p>1x Cream Cheese Cal:" + selectedAddOns.getCalories()+ " P" + selectedAddOns.getPrice()+ "</p>";
                    totalSales = totalSales + selectedAddOns.getPrice();
                    
                    } break;
                case 6: if(!chocolatePowderList.isEmpty()){
                    details += "<p>1x Chocolate powder Cal:" + selectedAddOns.getCalories()+ " P" + selectedAddOns.getPrice()+ "</p>";
                    totalSales = totalSales + selectedAddOns.getPrice();
                    
                    } break;
                case 7: if(!nataDeCocoList.isEmpty()){
                    details += "<p>1x Nata De Coco Cal:" + selectedAddOns.getCalories()+ " P" + selectedAddOns.getPrice()+ "</p>";
                    totalSales = totalSales + selectedAddOns.getPrice();
                    
                    } break;
                case 8: if(!lycheeList.isEmpty()){
                    details += "<p>1x lychee Cal:" + selectedAddOns.getCalories()+ " P" + selectedAddOns.getPrice() + "</p>";
                    totalSales = totalSales + selectedAddOns.getPrice();
                    
                    } break;
            }
        }
        
        totalSales = totalSales + fl.getPrice();
        
        details += "<p>=====================</p>";
        return ("<html>" +"<body>"+ display + " " + details + "</body>" +"</html>");
    }
    
}

