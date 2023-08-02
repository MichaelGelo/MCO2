/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mco2gui;
import java.util.ArrayList;
/**
 * The Money class stores the values and functions that deal 
 * with the denominations and the storage of the money in
 * the vending machine
 */
public class Money {

    private int piso;
    private int five;
    private int ten;
    private int twenty;
    private int fifty;
    private int oneHundred;
    private int totalMoney;

    
    /**
     * Computes the total money from the given payment of the user
     * 
     * @param payment ArrayList containing the denominations the user has entered in this vending machine
     * @return total money computed from payment
     */
    public int paymentBox (ArrayList <Integer> payment){
        
        for (int p: payment){
            switch (p) {
                case 1:     this.piso ++;       break;
                case 5:     this.five ++;       break;
                case 10:    this.ten ++;        break;
                case 20:    this.twenty ++;     break;
                case 50:    this.fifty ++;      break;
                case 100:   this.oneHundred ++; break;
                default: ;
            }
            this.totalMoney += p;
        }
        return totalMoney;
    }

    /**
     * Computes the change to be given to the user in different denominations based on the money inside this class
     * 
     * @param change total change that the user will receive
     * @param rvmMoney Money class that contains all the money of this vending machine
     * @return Boolean value based on if the change can be given by this vending machine
     */
    public boolean computeChange (int change, Money rvmMoney){
        int temp = change;

        while (temp >= 100 && rvmMoney.getOneHundred() != 0){
            temp -= 100;
            rvmMoney.setOneHundred(rvmMoney.getOneHundred() - 1);
            this.oneHundred++;
        }
        while (temp >= 50 && rvmMoney.getFifty() != 0){
            temp -= 50;
            rvmMoney.setFifty(rvmMoney.getFifty() - 1);
            this.fifty++;
        }
        while (temp >= 20 && rvmMoney.getTwenty() != 0){
            temp -= 20;
            rvmMoney.setTwenty(rvmMoney.getTwenty() - 1);
            this.twenty++;
        }
        while (temp >= 10 && rvmMoney.getTen() != 0){
            temp -= 10;
            rvmMoney.setTen(rvmMoney.getTen() - 1);
            this.ten++;
        }
        while (temp >= 5 && rvmMoney.getFive() != 0){
            temp -= 5;
            rvmMoney.setFive(rvmMoney.getFive() - 1);
            this.five++;
        }
        while (temp >= 1 && rvmMoney.getPiso() != 0){
            temp -= 1;
            rvmMoney.setPiso(rvmMoney.getPiso() - 1);
            this.piso++;
        }

        if (this.getTotalMoney() != change){
            return false;
        }
        else{
            return true;
        }
    } 

    /**
     * Gets to total money that this Money class has
     * 
     * @return integer value of the total money
     */
    public int getTotalMoney (){
        this.totalMoney = (piso) + (five * 5) + (ten * 10) + (twenty * 20) + (fifty * 50) + (oneHundred * 100);
        return totalMoney;

    }

    /**
     * Sets the amount of piso denominations inside this Money class
     * 
     * @param piso variable of the amount of piso
     */
    public void setPiso(int piso) {
        this.piso = piso;
    }

        
    /**
     * Sets the amount of five peso denominations inside this Money class
     * 
     * @param five variable of the amount of five pesos
     */
    public void setFive (int five) {
        this.five = five;
    }

        
    /**
     * Sets the amount of ten peso denominations inside this Money class
     * 
     * @param ten variable of the amount of ten pesos
     */
    public void setTen(int ten) {
        this.ten = ten;
    }
    
        
    /**
     * Sets the amount of twenty peso denominations inside this Money class
     * 
     * @param twenty variable of the amount of twenty pesos
     */
    public void setTwenty (int twenty) {
        this.twenty = twenty;
    }
    
        
    /**
     * Sets the amount of fifty peso denominations inside this Money class
     * 
     * @param fifty variable of the amount of fifty pesos
     */
    public void setFifty (int fifty) {
        this.fifty = fifty;
    }

        
    /**
     * Sets the amount of one hundred peso denominations inside this Money class
     * 
     * @param oneHundred variable of the amount of one hundred pesos
     */
    public void setOneHundred (int oneHundred) {
        this.oneHundred = oneHundred;
    }

    /**
     * Gets the amount of piso denominations inside this Money class
     * 
     * @return amount of piso
     */
    public int getPiso (){
        return piso;
    }

    /**
     * Gets the amount of five peso denominations inside this Money class
     * 
     * @return amount of five
     */
    public int getFive (){
        return five;
    }

    /**
     * Gets the amount of ten peso denominations inside this Money class
     * 
     * @return amount of ten
     */
    public int getTen (){
        return ten;
    }

    /**
     * Gets the amount of twenty peso denominations inside this Money class
     * 
     * @return amount of twenty
     */
    public int getTwenty (){
        return twenty;
    }

    /**
     * Gets the amount of fifty peso denominations inside this Money class
     * 
     * @return amount of fifty
     */
    public int getFifty (){
        return fifty;
    }

    /**
     * Gets the amount of one hundred peso denominations inside this Money class
     * 
     * @return amount of one hundred
     */
    public int getOneHundred (){
        return oneHundred;
    }

    /**
     * Simulates the releasing of change done by this vending machine
     */
    public void releaseChange (){
        if (this.oneHundred != 0 || this.fifty != 0 || this.twenty != 0 || this.ten != 0 || this.five != 0 ||this.piso != 0)
        {
            System.out.println("Releasing ");
            System.out.print("Change ");
            for (int i = 0; i <3; i++){
                System.out.print(".");
                Designs.sleep();
            }
            System.out.print("\n");
            if (this.oneHundred != 0){
                System.out.println(Designs.BLUE_B + "*Brrrr*" + Designs.RESET);
                System.out.printf(Designs.GREEN +"%d One Hundred Bill/s\n",oneHundred);
                
            }
            if (this.fifty != 0){
                System.out.println(Designs.BLUE_B + "*Brrrr*" + Designs.RESET);
                System.out.printf(Designs.GREEN +"%d Fifty Bill/s\n",fifty);
                
            }
            if (this.twenty != 0){
                System.out.println(Designs.BLUE_B + "*Brrrr*" + Designs.RESET);
                System.out.printf(Designs.GREEN +"%d Twenty Bill/s\n",twenty);
                
            }  
            if (this.ten != 0){
                System.out.println(Designs.BLUE_B + "*Brrrr*" + Designs.RESET);
                System.out.printf(Designs.GREEN +"%d Ten Coin/s\n",ten);
              
            }    
            if (this.five != 0){
                System.out.println(Designs.BLUE_B + "*Brrrr*" + Designs.RESET);
                System.out.printf(Designs.GREEN +"%d Five Coin/s\n",five);
              
            }               
            if (this.piso != 0){
                System.out.println(Designs.BLUE_B + "*Brrrr*" + Designs.RESET);
                System.out.printf(Designs.GREEN +"%d Peso Coin/s\n",piso);
              
            }
            System.out.println("Release of Change is completed"+ Designs.RESET);
        }
    }
    
    /**
     * Clears all the money denominations in this class
     */
    public void clearMoney(){
        this.oneHundred = 0;
        this.fifty = 0;
        this.twenty = 0;
        this.ten = 0;
        this.five = 0;
        this.piso = 0;
    }

}
