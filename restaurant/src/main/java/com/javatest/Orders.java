package com.javatest;

import java.util.ArrayList;

public class Orders{
    ArrayList<FoodItem> order = new ArrayList<FoodItem>();
    
    public void addLunch(Meal meal, Dessert dessert){
        Lunch lunch = new Lunch(meal,dessert);
        order.add(lunch);
    }
    
    public void addDrink(Drink drink){
        order.add(drink);
    }
    
    public ArrayList<FoodItem> getOrders(){
        return order;
    }
    
    public double total(){
        double Total = order.stream().mapToDouble(FoodItem::getPrice).sum();
        return Total;
    }
    
    public String toString(){
        String output = "Order: ";
        for (int x=0; x<order.size(); x++){
            output = output.concat("\r\n" + order.get(x).toString());
        }
        output = output.concat("\r\n TOTAL: " + total() + "\r\n___________");
        return output;
    }
    
    private class Lunch extends FoodItem{
        Lunch(Meal meal, Dessert dessert){
            this.setName(meal.getName() + " + " + dessert.getName());
            this.setPrice(meal.getPrice() + dessert.getPrice());
        }
    }
}