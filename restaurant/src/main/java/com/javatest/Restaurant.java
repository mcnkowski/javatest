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
        FoodItem plmeal1 = new FoodItem("Pierogi",11.0);
        FoodItem plmeal2 = new FoodItem("Cutlet",12.0);
        FoodItem plmeal3 = new FoodItem("Bigos",10.0);
        FoodItem mexmeal1 = new FoodItem("Enchiladas",15.0);
        FoodItem mexmeal2 = new FoodItem("Quesadilla", 12.0);
        FoodItem mexmeal3 = new FoodItem("Burrito", 11.0);
        FoodItem itmeal1 = new FoodItem("Carbonara", 16.0);
        FoodItem itmeal2 = new FoodItem("Gnocchi",13.0);
        FoodItem itmeal3 = new FoodItem("Ravioli",14.0);
        FoodItem dessert1 = new FoodItem("Panna Cotta",10.0);
        FoodItem dessert2 = new FoodItem("Cheesecake", 9.0);
        FoodItem drink1 = new FoodItem("Water", 2.0);
        FoodItem drink2 = new FoodItem("Soda", 6.0);
        
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