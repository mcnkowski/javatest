package com.javatest;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    static FoodMenu menu = createMenu();
    public static void main(String args[]){
        //try putting all of this as a method inside of a processing class of some sort
        Orders order = new Orders();
        Meal tempMeal;
        Drink tempDrink;
        int userInput;
        int userInput2;
        Scanner scanInput = new Scanner(System.in);
        menuLoop:
        while(true){
            System.out.println("1. Order a lunch.");
            System.out.println("2. Order a drink.");
            System.out.println("3. Finalize order.");
            System.out.println("4. Cancel order.");
            System.out.println("0. Exit.");
            userInput = scanInput.nextInt(); //put all scanInput.nextInt(); into a method that will catch exceptions!!!!
            switch (userInput) {
                case 1:
                    //catch exceptions for out of bounds indexes
                    arrayListPrinter(menu.getAllCuisines());
                    userInput = scanInput.nextInt();
                    userInput--;
                    
                    arrayListPrinter(menu.getCuisine(userInput));
                    userInput2 = scanInput.nextInt();
                    userInput2--;
                    tempMeal = menu.getMeal(userInput,userInput2);
                    
                    arrayListPrinter(menu.getAllDesserts());
                    userInput = scanInput.nextInt();
                    userInput--;
                    order.addLunch(tempMeal,menu.getDessert(userInput));
                    break;
                case 2:
                    arrayListPrinter(menu.getAllDrinks());
                    userInput = scanInput.nextInt();
                    userInput--;
                    try {
                        tempDrink = new Drink(menu.getDrink(userInput)); //needs a new object so that we can edit lemon and ice states
                        System.out.println("1. Add lemon.");
                        System.out.println("2. Add ice.");
                        System.out.println("3. Add both.");
                        userInput = scanInput.nextInt();
                        if (userInput==1 || userInput==3) {
                            tempDrink.setLemon();
                        }
                        if (userInput==2 || userInput==3) {
                            tempDrink.setIce();
                        }
                        order.addDrink(tempDrink);
                    }
                    catch(IndexOutOfBoundsException e) {
                        System.out.println("Invalid item index.");
                    }
                    break;
                case 3:
                    System.out.println(order);
                    //in an actual software this would also pass the order to the kitchen
                    order = new Orders(); //clean order
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
    }
    
    private static void arrayListPrinter(ArrayList<?> array){
        array.forEach(x -> {
            int index = array.indexOf(x)+1;
            System.out.println(index + " " + x.toString());
        });
    }
    
    private static FoodMenu createMenu(){
        Meal plmeal1 = new Meal("Pierogi",11.0);
        Meal plmeal2 = new Meal("Cutlet",12.0);
        Meal plmeal3 = new Meal("Bigos",10.0);
        Meal mexmeal1 = new Meal("Enchiladas",15.0);
        Meal mexmeal2 = new Meal("Quesadilla", 12.0);
        Meal mexmeal3 = new Meal("Burrito", 11.0);
        Meal itmeal1 = new Meal("Carbonara", 16.0);
        Meal itmeal2 = new Meal("Gnocchi",13.0);
        Meal itmeal3 = new Meal("Ravioli",14.0);
        Dessert dessert1 = new Dessert("Panna Cotta",10.0);
        Dessert dessert2 = new Dessert("Cheesecake", 9.0);
        Drink drink1 = new Drink("Water", 2.0);
        Drink drink2 = new Drink("Soda", 6.0);
        
        FoodMenu menu = new FoodMenu();
        menu.createCuisine("Polish");
        menu.createCuisine("Mexican");
        menu.createCuisine("Italian");

        menu.addCourse("Polish",plmeal1);
        menu.addCourse("Polish",plmeal2);
        menu.addCourse("Polish",plmeal3);
        menu.addCourse("Mexican",mexmeal1);
        menu.addCourse("Mexican",mexmeal2);
        menu.addCourse("Mexican",mexmeal3);
        menu.addCourse("Italian",itmeal1);
        menu.addCourse("Italian",itmeal2);
        menu.addCourse("Italian",itmeal3);
        menu.addDessert(dessert1);
        menu.addDessert(dessert2);
        menu.addDrink(drink1);
        menu.addDrink(drink2);
        
        return menu;
    }

}