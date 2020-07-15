package com.javatest;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
//import java.util.function.Consumer;

public class FoodMenu {
    private ArrayList<FoodItem> desserts = new ArrayList<FoodItem>();
    private ArrayList<FoodItem> drinks = new ArrayList<FoodItem>();
    private ArrayList<Cuisine> courses = new ArrayList<Cuisine>();
    
    public void createCuisine(String name) {
        if (courses.stream().noneMatch((x) -> x.name == name)) { //Don't create cuisines with duplicate names
            courses.add(new Cuisine(name));
        }
    }
    
    public void createCuisine(String name,ArrayList<FoodItem> meals) {
        if (courses.stream().noneMatch((x) -> x.name == name)) {
            courses.add(new Cuisine(name,meals));
        }
    }
    
    /*public void addCourse(String name, FoodItem meal) {
        Consumer<Cuisine> LExpr = x -> {
            if(x.name == name){
                x.items.add(meal);
            }
        };
        courses.forEach(LExpr);
    }*/
    
    public void addCourse(String cuisineName, FoodItem meal) {
        courses.forEach(x -> {
            if(x.name == cuisineName){ //Go through all cuisines and if matching name is found, add meals to the menu
                x.items.add(meal);
            }
        });
    }

    public void addCourses(String cuisineName, Collection<? extends FoodItem> meals){
        courses.forEach(x -> {
            if(x.name == cuisineName){
                x.items.addAll(meals);
            }
        });
    }
    
    public void addCourses(String cuisineName, FoodItem[] meals){
        ArrayList<FoodItem> courses = new ArrayList<FoodItem>(Arrays.asList(meals));
        this.addCourses(cuisineName,courses);
    }
    
    public ArrayList<Cuisine> getAllCuisines(){
        return courses;
    }
    
    public ArrayList<FoodItem> getCuisine(int index){
        return courses.get(index).items;
    }
    
    public FoodItem getMeal(int cuisineID, int mealID){
        return courses.get(cuisineID).items.get(mealID);
    }
    
    public void addDessert(FoodItem dessert) {
        this.desserts.add(dessert);
    }
    
    public void addDesserts(Collection<? extends FoodItem> desserts) {
        this.desserts.addAll(desserts);
    }
    
    public void addDesserts(FoodItem[] desserts){
        this.addDesserts(new ArrayList<FoodItem>(Arrays.asList(desserts)));
    }
    
    public ArrayList<FoodItem> getAllDesserts(){
        return desserts;
    }
    
    public FoodItem getDessert(int index) {
        return desserts.get(index);
    }
    
    public void addDrink(FoodItem drink) {
        this.drinks.add(drink);
    }
    
    public void addDrinks(Collection<? extends FoodItem> drinks) {
        this.drinks.addAll(drinks);
    }
    
    public void addDrinks(FoodItem[] drinks){
        this.addDrinks(new ArrayList<FoodItem>(Arrays.asList(drinks)));
    }
    
    public ArrayList<FoodItem> getAllDrinks(){
        return drinks;
    }
    
    public FoodItem getDrink(int index) {
        return drinks.get(index);
    }
    
    public void sortMenu() { //sort menu items alphabetically; cuisines stay in the order they were added
        courses.forEach(x -> x.items.sort(Comparator.comparing(FoodItem::getName)));
        desserts.sort(Comparator.comparing(FoodItem::getName));
        drinks.sort(Comparator.comparing(FoodItem::getName));
    }
    
    public class Cuisine {
        protected String name;
        protected ArrayList<FoodItem> items;
        
        Cuisine(String name, ArrayList<FoodItem> items) {
            this.name = name;
            this.items = items;
        }
        
        Cuisine(String name) {
            this.name = name;
            items = new ArrayList<FoodItem>();
        }
        
        public Boolean isEmpty() {
            return items.isEmpty();
        }
        
        public String toString(){
            String output = this.name;
            for (int x=0; x<items.size(); x++){ //for (FoodItem item : items)
                output = output.concat("\r\n" + this.items.get(x).toString()); //= output.concat("\r\n" + item.toString());
            }
            return output;
        }
    }
}