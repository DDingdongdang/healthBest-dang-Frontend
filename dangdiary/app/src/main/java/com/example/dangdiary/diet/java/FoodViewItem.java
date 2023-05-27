package com.example.dangdiary.diet.java;

public class FoodViewItem {
    private String food_photo;
    private String mealType;
    //private LocalDateTime inputTime;
    private String menuName;
    private int foodSugar;

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

    public int getFoodSugar() {
        return foodSugar;
    }

    public void setFoodSugar(int foodSugar) {
        this.foodSugar = foodSugar;
    }

    public String getFood_photo() {
        return food_photo;
    }

    public void setFood_photo(String food_photo) {
        this.food_photo = food_photo;
    }



//    public void setInputTime(LocalDateTime inputTime){
//        this.inputTime = inputTime;
//    }
//    public LocalDateTime getInputTime(){
//        return this.inputTime;
//    }



}
