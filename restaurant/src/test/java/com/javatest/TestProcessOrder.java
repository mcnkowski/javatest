package com.javatest;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.AfterEach;
//import java.io.InputStream;
//import java.io.ByteArrayInputStream;


/*
modified ProcessOrder class for testing
ends after one order has been processed
doesn't catch exceptions
*/

public class TestProcessOrder{
    private FoodMenu menu;
	private Scanner scanInput;
	
    
    TestProcessOrder(FoodMenu menu,InputStream in){ //pass an input stream that simulates user input
        if (missingContent(menu)){
            throw new IllegalArgumentException("Constructor has been passed an incomplete FoodMenu object.");
        }else{
            this.menu = menu;
			this.scanInput = new Scanner(in); //Use ByteArrayInputStream in = new ByteArrayInputStream(("1" + System.lineSeparator() + "2").getBytes()); to get multiple inputs for different keyboard.nextLine() calls.
        }
    }
    
    public Orders run(){
        Orders order = new Orders();
        Meal mealstorage;
        Meal dessertstorage;
        Drink drinkstorage;
        int inputSwCase, userin;
        
        menuLoop:
        while(true){
            System.out.println(""); //Empty line to make the menu easier to read.
            System.out.println("1. Order a lunch.");
            System.out.println("2. Order a drink.");
            System.out.println("3. Show total/Finalize order.");
            System.out.println("4. Cancel order.");
            System.out.println("0. Exit.");
            inputSwCase = userInput();
            switch (inputSwCase) {
                case 1:
                    mealstorage = processMeal();
                    dessertstorage = processDessert();
                    System.out.println("");
                    System.out.println("Confirm order:\r\n1.Yes\r\n2.No");
                    do {
                        userin = userInput();
                    }while(userin != 1 && userin != 2);
                    if (userin == 1){
                        order.addLunch(mealstorage,dessertstorage);
                    }
                    break;
                case 2:
                    drinkstorage = processDrink();
                    System.out.println("");
                    System.out.println("Confirm order:\r\n1.Yes\r\n2.No");
                    do {
                        userin = userInput();
                    }while(userin != 1 && userin != 2);
                    if (userin == 1) {
                        order.addDrink(drinkstorage);
                    }
                    break;
                case 3:
                    System.out.println("");
                    System.out.println(order);
                    System.out.println("Finalize order:\r\n1.Yes\r\n2.No");
                    do {
                        userin = userInput();
                    }while(userin != 1 && userin != 2);
                    if (userin == 1) {
                        //sendToChef(order);
						return order;
                        //order = new Orders(); //clean order
                        //System.out.println("\r\nOrder has been processed.");
                    }
                    break;
                case 4:
                    order = new Orders();
                    System.out.println("Order cancelled.");
                    break;
                case 0:
                    break menuLoop;
                default:
            }
        }
        System.out.println("Bye.");
		throw new UnsupportedOperationException("No order has been processed.");
    }
    
    private int userInput() { //get keyboard input and check if it's an integer
        int input;
        while(true){
            try{
                input = scanInput.nextInt();
                return input;
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please use integers only.");
                scanInput.nextLine(); //consume newline to avoid endless exception loop
            }
        }
    }
    
    private Meal processMeal(){
        Meal tempmeal;
        ArrayList<Meal> tempcuisine;
        int userin, userin2;
        
        arrayListPrinter(menu.getAllCuisines());
        userin = userInput();
        userin--; //substract because array indexing starts at 0
        tempcuisine = menu.getCuisine(userin);
    
        arrayListPrinter(tempcuisine);
        userin2 = userInput();
        userin2--;
        tempmeal = menu.getMeal(userin,userin2);
        return tempmeal;
    }
    
    private Meal processDessert() {
        int userin;

        arrayListPrinter(menu.getAllDesserts());
        userin = userInput();
        userin--;
        return menu.getDessert(userin);
    }

    private Drink processDrink() {
        Drink tempdrink;
        int userin, userin2;
        
        arrayListPrinter(menu.getAllDrinks());
        userin = userInput();
        userin--;
        tempdrink = new Drink(menu.getDrink(userin)); //needs a new object and not a reference so that we can edit lemon and ice states
        System.out.println("");
        System.out.println("1. Add lemon.");
        System.out.println("2. Add ice.");
        System.out.println("3. Add both.");
        System.out.println("4. None.");
        userin2 = userInput();
        if (userin2==1 || userin2==3) {
            tempdrink.setLemon();
        }
        if (userin2==2 || userin2==3) {
            tempdrink.setIce();
        }
        if (userin2>=1 && userin2<=4) { 
            return tempdrink;
            //this if-statement isn't necessary but it keeps the menu consistent
            //otherwise any integer other than 1,2,3 would return drink with no ice or lemon
        } 
        else {
            System.out.println("Invalid input.");
		    throw new UnsupportedOperationException("Invalid request.");
        }
    }
    
    private void arrayListPrinter(ArrayList<?> array){
        System.out.println("");
        array.forEach(x -> {
            int index = array.indexOf(x)+1;
            System.out.println(index + ". " + x.toString());
        });
    }
    
    private Boolean missingContent(FoodMenu menu){
        Boolean hasntdessert = menu.getAllDesserts().isEmpty();
        Boolean hasntdrink = menu.getAllDrinks().isEmpty();
        Boolean hasntmeal = menu.getAllCuisines().stream().anyMatch(FoodMenu.Cuisine::isEmpty);
        
        if (hasntdessert || hasntdrink || hasntmeal){
            return true;
        }else{
            return false;
        }
    }
}