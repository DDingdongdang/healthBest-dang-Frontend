package com.example.dangdiary.menu;

public class HomeBloodSugarViewItem {

    private String mealType; //아침점심저녁
    private int date_hour;
    private int date_minute;
    private String mealTime; //식전 식후
    private int sugar; // 혈당량

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public int getDate_hour() {
        return date_hour;
    }

    public void setDate_hour(int date_hour) {
        this.date_hour = date_hour;
    }

    public int getDate_minute() {
        return date_minute;
    }

    public void setDate_minute(int date_minute) {
        this.date_minute = date_minute;
    }

    public String getMealTime() {
        return mealTime;
    }

    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }


}
