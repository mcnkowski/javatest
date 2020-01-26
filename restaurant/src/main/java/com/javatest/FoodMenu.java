package com.javatest;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
//import java.util.function.Consumer;

public class FoodMenu {
    private ArrayList<Meal> desserts = new ArrayList<Meal>();
    private ArrayList<Drink> drinks = new ArrayList<Drink>();
    private ArrayList<Cuisine> courses = new ArrayList<Cuisine>();
    
    public void createCuisine(String name) {
        if (courses.stream().noneMatch((x) -> x.name == name)) { //Don't create cuisines with duplicate names
            courses.add(new Cuisine(name));
        }
    }
    
    public void createCuisine(String name,ArrayList<Meal> meals) {
        if (courses.stream().noneMatch((x) -> x.name == name)) {
            courses.add(new Cuisine(name,meals));
        }
    }
    
    /*public void addCourse(String name, Meal meal) {
        Consumer<Cuisine> LExpr = x -> {
            if(x.name == name){
                x.items.add(meal);
            }
        };
        courses.forEach(LExpr);
    }*/
    
    public void addCourse(String cuisineName, Meal meal) {
        courses.forEach(x -> {
            if(x.name == cuisineName){ //Go through all cuisines and if matching name is found, add meals to the menu
                x.items.add(meal);
            }
        });
    }

    public void addCourses(String cuisineName, Collection<? extends Meal> meals){
        courses.forEach(x -> {
            if(x.name == cuisineName){
                x.items.addAll(meals);
            }
        });
    }
    
    public void addCourses(String cuisineName, Meal[] meals){
        ArrayList<Meal> courses = new ArrayList<Meal>(Arrays.asList(meals));
        this.addCourses(cuisineName,courses);
    }
    
    public ArrayList<Cuisine> getAllCuisines(){
        return courses;
    }
    
    public ArrayList<Meal> getCuisine(int index){
        return courses.get(index).items;
    }
    
    public Meal getMeal(int cuisineID, int mealID){
        return courses.get(cuisineID).items.get(mealID);
    }
    
    public void addDessert(Meal dessert) {
        this.desserts.add(dessert);
    }
    
    public void addDesserts(Collection<? extends Meal> desserts) {
        this.desserts.addAll(desserts);
    }
    
    public void addDesserts(Meal[] desserts){
        this.addDesserts(new ArrayList<Meal>(Arrays.asList(desserts)));
    }
    
    public ArrayList<Meal> getAllDesserts(){
        return desserts;
    }
    
    public Meal getDessert(int index) {
        return desserts.get(index);
    }
    
    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }
    
    public void addDrinks(Collection<? extends Drink> drinks) {
        this.drinks.addAll(drinks);
    }
    
    public void addDrinks(Drink[] drinks){
        this.addDrinks(new ArrayList<Drink>(Arrays.asList(drinks)));
    }
    
    public ArrayList<Drink> getAllDrinks(){
        return drinks;
    }
    
    public Drink getDrink(int index) {
        return drinks.get(index);
    }
    
    public void sortMenu() { //sort menu items alphabetically; cuisines stay in the order they were added
        courses.forEach(x -> x.items.sort(Comparator.comparing(Meal::getName)));
        desserts.sort(Comparator.comparing(Meal::getName));
        drinks.sort(Comparator.comparing(Drink::getName));
    }
    
    public class Cuisine {
        protected String name;
        protected ArrayList<Meal> items;
        
        Cuisine(String name, ArrayList<Meal> items) {
            this.name = name;
            this.items = items;
        }
        
        Cuisine(String name) {
            this.name = name;
            items = new ArrayList<Meal>();
        }
        
        public Boolean isEmpty() {
            return items.isEmpty();
        }
        
        public String toString(){
            String output = this.name;
            for (int x=0; x<items.size(); x++){
                output = output.concat("\r\n" + this.items.get(x).toString());
            }
            return output;
        }
    }
}