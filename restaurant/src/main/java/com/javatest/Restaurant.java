package com.javatest;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    
    public static void main(String args[]){
       FoodMenu menu = createMenu();
       menu.sortMenu();
       
       ProcessOrder program = new ProcessOrder(menu);
       program.run();
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