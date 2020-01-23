package com.javatest;

public abstract class FoodItem {
    protected String name;
    protected double price;
    
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
    
    public String toString() {
        return name + " " + price;
    }
    
}