/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mco2gui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The Designs class deals with all the delays and colors when printing.
 */
public class Designs {
    //public static Timer timer;
    public static final String RESET    = "\033[0m"; 

    public static final String RED      = "\033[0;31m";   
    public static final String GREEN    = "\033[0;32m";  
    public static final String YELLOW   = "\033[0;33m"; 
    public static final String BLUE     = "\033[0;34m";  

    public static final String RED_B    = "\033[1;31m";  
    public static final String GREEN_B  = "\033[1;32m";  
    public static final String YELLOW_B = "\033[1;33m"; 
    public static final String BLUE_B   = "\033[1;34m";  
 
    public static final String RED_U    = "\033[4;31m";
    public static final String GREEN_U  = "\033[4;32m"; 
    public static final String YELLOW_U = "\033[4;33m"; 
    public static final String BLUE_U   = "\033[4;34m";  

    /**
     * This method is used to clear the console screen for much better design.
     */
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * This method is used to represent the effect that the program is loading.
     */
    public static void sleep(){
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
    
    /**
     * This method is used to represent the effect that the program is loading.
     */
    public static void sleep(int time){
        try{
            Thread.sleep(time);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

}

