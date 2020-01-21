package com.javatest;

import java.util.ArrayList;

public class Restaurant {

    public static void main(String args[]){
        Meal testmeal = new Meal("Pierogi",10.20);
        Meal testmeal2 = new Meal("Kotlet",11.00);
        Meal testmeal3 = new Meal("Kurczak",10.0);
        Drink testdrink = new Drink("Woda",2);
        testdrink.setIce();
        
        ArrayList<Meal> mealarray = new ArrayList<Meal>();
        
        FoodMenu menu = new FoodMenu();
        menu.createCuisine("Polish");
        mealarray.add(testmeal);
        mealarray.add(testmeal2);
        mealarray.add(testmeal3);
        menu.addCourses("Polish",mealarray);
        
        menu.createCuisine("Polish AGAIN");
        menu.addCourse("Polish AGAIN",testmeal2);
        menu.addCourse("Polish AGAIN",testmeal);
        
        menu.getAllCourses().forEach(System.out::println);
        
        ArrayList<FoodItem> testorders = new ArrayList<FoodItem>();
        testorders.add(testmeal);
        testorders.add(testdrink);
        
        System.out.println(testorders.get(0));
        System.out.println(testorders.get(1));
        System.out.println(testorders.get(0) instanceof Meal);
        System.out.println(testorders.get(0) instanceof FoodItem);
        System.out.println(testorders.get(1) instanceof Drink);
        System.out.println(testorders.get(1) instanceof FoodItem);
        
        //Drink testdrink = new Drink("Water",2.00);
        //Dessert testdessert = new Dessert("Tiramisu",14.50);
        
        //System.out.println("PLACEHOLDER");
        /*System.out.println(testmeal);
        System.out.println(testdrink);
        System.out.println(testdessert);
        
        testdrink.setLemon();
        System.out.println(testdrink);
        testdrink.setIce();
        System.out.println(testdrink);
        testdrink.setLemon();
        System.out.println(testdrink); */
    }
    

}