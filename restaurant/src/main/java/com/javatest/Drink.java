package com.javatest;

public class Drink extends FoodItem {
    private Boolean lemon = false;
    private Boolean ice = false;
    
    Drink(String name, double price) {
        setName(name);
        setPrice(price);
        //setCuisine("Drink");
    }
    
    public void setLemon() {
        lemon = lemon ? false : true;
    }
    
    public void setIce() {
        ice = ice ? false : true;
    }
        
    public String toString() {
        String text = getName();
        text = lemon ? text + " " + "with lemon" : text;
        text = ice ? text + " " + "with ice" : text;
        text = text + " " + getPrice();
        return text;
    }
    
}