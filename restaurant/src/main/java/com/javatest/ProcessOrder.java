package com.javatest;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ProcessOrder{
    private FoodMenu menu;
    
    ProcessOrder(FoodMenu menu){
        this.menu = menu;
        //add an exception for when the menu is empty
    }
    
    public void run(){
        Orders order = new Orders();
        Meal mealstorage;
        Dessert dessertstorage;
        Drink drinkstorage;
        int inputSwCase, userin;
        
        menuLoop:
        while(true){
            System.out.println(""); //Empty line to make the menu easier to read.
            System.out.println("1. Order a lunch.");
            System.out.println("2. Order a drink.");
            System.out.println("3. Finalize order.");
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
                        order = new Orders(); //clean order
                        System.out.println("\r\nOrder has been processed.");
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
    }
    
    private int userInput() { //get keyboard input and check if it's an integer
        Scanner scanInput = new Scanner(System.in);
        int input;
        while(true){
            try {
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
        
        while(true){
            arrayListPrinter(menu.getAllCuisines());
            try {
                userin = userInput();
                userin--; //substract because array indexing starts at 0
                tempcuisine = menu.getCuisine(userin);
                break;
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid item index.");
            }
        }
            
        while(true){
            arrayListPrinter(tempcuisine);
            try {
                userin2 = userInput();
                userin2--;
                tempmeal = menu.getMeal(userin,userin2);
                return tempmeal;
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid item index.");
            }
        }
    }
    
    private Dessert processDessert() {
        int userin;
        
        while(true){
            arrayListPrinter(menu.getAllDesserts());
            try {
                userin = userInput();
                userin--;
                return menu.getDessert(userin);
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid item index.");
            }
        }
    }
    
    private Drink processDrink() {
        Drink tempdrink;
        int userin, userin2;
        
        while (true) {
            arrayListPrinter(menu.getAllDrinks());
            try {
                userin = userInput();
                userin--;
                tempdrink = new Drink(menu.getDrink(userin)); //needs a new object so that we can edit lemon and ice states
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
                if (userin2==1 || userin2==2 || userin2 ==3 || userin2==4) { 
                    return tempdrink;
                    //this if-statement isn't necessary but it keeps the menu consistent
                    //otherwise any integer other than 1,2,3 would return drink with no ice or lemon
                } 
                else {
                    System.out.println("Invalid input.");
                }
            }
            catch(IndexOutOfBoundsException e) {
                System.out.println("Invalid item index.");
            }
        }
    }
    
    private void arrayListPrinter(ArrayList<?> array){
        System.out.println("");
        array.forEach(x -> {
            int index = array.indexOf(x)+1;
            System.out.println(index + ". " + x.toString());
        });
    }
}