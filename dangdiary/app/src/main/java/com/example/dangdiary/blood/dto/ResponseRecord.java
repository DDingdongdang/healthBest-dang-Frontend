package com.example.dangdiary.blood.dto;

public class ResponseRecord {

    private BloodTime time;
    private String mealType;
    private String mealTime;
    private int sugar;

    public BloodTime getTime(){
        return time;
    }
    public String getMealType() {
        return mealType;
    }

    public String getMealTime() {
        return mealTime;
    }

    public int getSugar() {
        return sugar;
    }




}
