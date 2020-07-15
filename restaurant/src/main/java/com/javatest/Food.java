package com.javatest;

public class Food implements FoodItem {
    protected String name;
    protected double price;
    
    Food(String name,double price){
		this.name = name;
		this.price = price;
	}
	
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String toString() {
        return name + " " + price;
    }
	
	public with(FoodItem item) {
		return new FoodWith(this,item);
	}
    
	public static Food lemon = new Food("Lemon",0d);
	public static Food ice = new Food("Ice",0d);
	
	private class FoodWith implements FoodItem {
		private FoodItem item1;
		private FoodItem item2;
		
		FoodWith(FoodItem item1, FoodItem item2){
			this.item = item1;
			this.item = item2;
		}
    
        public String getName() {
            return item1.getName() + " with " + item2.getName();
        }
    
        public double getPrice() {
            return item1.getPrice() + item2.getPrice();
        }
		
		public String toString() {
            return name + " " + price;
        }
	}
}