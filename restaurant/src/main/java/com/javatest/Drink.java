package com.javatest;

public class Drink extends FoodItem {
    private Boolean lemon = false;
    private Boolean ice = false;
    
    Drink(String name, double price) {
        setName(name);
        setPrice(price);
    }
    
    Drink(Drink copy){
        setName(copy.getName());
        setPrice(copy.getPrice());
        this.lemon = copy.checkLemon();
        this.ice = copy.checkIce();
    }
    
    public void setLemon() {
        lemon = lemon ? false : true;
    }
    
    public void setIce() {
        ice = ice ? false : true;
    }
    
    public Boolean checkLemon() {
        return lemon;
    }
    
    public Boolean checkIce() {
        return ice;
    }
        
    public String toString() {
        String text = getName();
        text = lemon ? text + " " + "with lemon" : text;
        text = ice ? text + " " + "with ice" : text;
        text = text + " " + getPrice();
        return text;
    }
    
}