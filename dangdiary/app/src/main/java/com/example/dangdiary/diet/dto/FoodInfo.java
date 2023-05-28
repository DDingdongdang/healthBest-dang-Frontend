package com.example.dangdiary.diet.dto;

public class FoodInfo {


    private long id;
    private String name;




    private int amount;
    private double calorie;
    private double carbohydrate;
    private double protein;
    private double fat;
    private double sugars;
    private double sodium;



    public long getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public double getCalorie() {
        return calorie;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getSugars() {
        return sugars;
    }

    public double getSodium() {
        return sodium;
    }
}
