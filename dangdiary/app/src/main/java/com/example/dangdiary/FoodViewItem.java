package com.example.dangdiary;

import java.time.LocalDateTime;

public class FoodViewItem {
    private int food_photo;
    private String mealType;
    private LocalDateTime inputTime;
    private String menuName;
    private int foodSugar;

    public FoodViewItem(int food_photo, String mealType, LocalDateTime inputTime, String menuName, int foodSugar){
        this.food_photo = food_photo;
        this.mealType = mealType;
        this.inputTime = inputTime;
        this.menuName = menuName;
        this.foodSugar = foodSugar;
    }

    public int getFood_photo(){
        return this.food_photo;
    }

    public void setMealType(String mealType){
        this.mealType = mealType;
    }
    public String getMealType(){
        return this.mealType;
    }

    public void setInputTime(LocalDateTime inputTime){
        this.inputTime = inputTime;
    }
    public LocalDateTime getInputTime(){
        return this.inputTime;
    }

    public void setMenuName(String menuName){
        this.menuName = menuName;
    }
    public String getMenuName(){
        return this.menuName;
    }

    public void setFoodSugar(int foodSugar){
        this.foodSugar = foodSugar;
    }
    public int getFoodSugar(){
        return this.foodSugar;
    }

}
