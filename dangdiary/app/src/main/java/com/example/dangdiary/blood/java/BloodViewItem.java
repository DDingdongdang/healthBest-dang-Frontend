package com.example.dangdiary.blood.java;

public class BloodViewItem {

    private String mealType; //아침점심저녁
    private int date_hour;
    private int date_minute;
    private String mealTime; //식전 식후
    private int sugar; // 혈당량


    //recycle view 보여주는 함수
    public String getMealType() {
        return mealType;
    } //가지고 있는걸 보여주는거
    public int getDate_hour() {return date_hour;}
    public int getDate_minute() {return date_minute;}
    public String getMealTime() {
        return mealTime;
    }
    public int getSugar() {
        return sugar;
    }



    //spring으로터 값을 받는 set

    public void setMealType(String mealType) {
        this.mealType = mealType;
    } //값을 받는거
    public void setDate_hour(int date_hour) {
        this.date_hour = date_hour;
    }
    public void setDate_minute(int date_minute) {
        this.date_minute = date_minute;
    }
    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }
    public void setSugar(int sugar) {
        this.sugar = sugar;
    }



    /*public void setDate_year(int year) {
        this.date_hour = year;
    }
    public void setDate_month(int month) {
        this.date_hour = month;
    }
    public void setDate_day(int day) {
        this.date_hour = day;
    }*/


}
