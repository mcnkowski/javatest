package com.javatest;

public abstract class FoodItem { //implements Comparable<FoodItem>
    protected String name;
    protected double price;
    //protected String cuisine;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setCuisine(String name) {
        //cuisine = name;
    }
    
    public String getCuisine() {
        //return cuisine;
        return "PLACEHOLDER";
    }
    
    public String toString() {
        return name + " " + price;
    }
    
    /*public int compareTo(FoodItem compItem) {
        String cuisine = this.cuisine.toUpperCase();
        String compCuisine = compItem.getCuisine().toUpperCase();
        int comparison = cuisine.compareTo(compCuisine);
        
        if (comparison != 0) {
            return comparison;
        } else {
            String name = this.name.toUpperCase();
            String compName = compItem.getName().toUpperCase();
            return name.compareTo(compName);
        }
    }*/
}