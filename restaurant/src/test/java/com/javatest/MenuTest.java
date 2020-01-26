package com.javatest;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.AfterEach;
//import java.io.InputStream;
//import java.io.ByteArrayInputStream;

public class MenuTest {
    
    private FoodMenu testedmenu;
    private Meal meal11 = new Meal("Meal A", 1d);
    private Meal meal12 = new Meal("Meal B", 2d);
    private Meal meal21 = new Meal("Meal C", 3d); 
    private Meal meal22 = new Meal("Meal D", 4d);
    private Meal meal23 = new Meal("Meal F", 5d);
    private Meal[] cuisine1 = {meal11,meal12};
    private Meal[] cuisine2 = {meal21,meal22};
    
    @BeforeEach
    public void before(){
        testedmenu = new FoodMenu(); //create clean menu in case one of the tests modifies its states
        testedmenu.createCuisine("Test Cuisine 1");
        testedmenu.createCuisine("Test Cuisine 2");

    }
    
    @Test
    public void addTest(){
        testedmenu.addCourses("Test Cuisine 1", cuisine1);
        testedmenu.addCourses("Test Cuisine 2", cuisine2);
        testedmenu.addCourse("Test Cuisine 2", meal23);
        Meal[] temp = {meal21,meal22,meal23};
		
        Assertions.assertAll(
            "Addition test",
            () -> Assertions.assertArrayEquals(cuisine1,testedmenu.getCuisine(0).toArray()),
            () -> Assertions.assertArrayEquals(temp,testedmenu.getCuisine(1).toArray())
        );
    }
    
    @Test
    public void duplicateTest1(){
        testedmenu.createCuisine("Test Cuisine 1"); //create a new cuisine using the same name as before
        Assertions.assertEquals(2,testedmenu.getAllCuisines().size()); //check if the amount of cuisines changed
    }
    
    @Test public void duplicateTest2(){
        testedmenu.addCourses("Test Cuisine 1",cuisine1); //check if an existing cuisine doesn't get overwritten
        testedmenu.createCuisine("Test Cuisine 1");
        Assertions.assertArrayEquals(cuisine1,testedmenu.getCuisine(0).toArray());
    }
        
}