package com.example.dangdiary.menu;

public class HomeFoodViewItem {

    private String food_photo;
    private String mealType;
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

    public double getFoodSugar() {
        return foodSugar;
    }

    public void setFoodSugar(double foodSugar) {
        this.foodSugar = foodSugar;
    }

    public double getCarbon() { return carbon;}
    public void setCarbon(double carbon) { this.carbon = carbon;}

    public String getFood_photo() {
        return food_photo;
    }

    public void setFood_photo(String food_photo) {
        this.food_photo = food_photo;
    }


}
