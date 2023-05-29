package com.example.dangdiary.diet.java;

public class FoodViewItem {
    private int food_photo;
    private String mealType;
    private String date_hour;
    private String menuName;
    private double foodSugar;
    private double carbon;

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public String getDate_hour() {
        return date_hour;
    }

    public void setDate_hour(String date_hour) {
        this.date_hour = date_hour;
    }

    public double getFoodSugar() {
        return foodSugar;
    }

    public void setFoodSugar(double foodSugar) {
        this.foodSugar = foodSugar;
    }

    public double getCarbon() { return carbon;}
    public void setCarbon(double carbon) { this.carbon = carbon;}

    public int getFood_photo() {
        return food_photo;
    }

    public void setFood_photo(int food_photo) {
        this.food_photo = food_photo;
    }

}
