package com.example.dangdiary.diet.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendFoodRecord {



    //사용자에게 받은 데이터를 전송
    @SerializedName("time")
    @Expose
    private Time time;

    @SerializedName("mealType")
    @Expose
    private String mealType;

    @SerializedName("sugar")
    @Expose
    private int sugar;

    public void setTime(Time time) {
        this.time = time;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }


    public class Time {
        @SerializedName("year")
        @Expose
        private int year;

        @SerializedName("month")
        @Expose
        private int month;

        @SerializedName("day")
        @Expose
        private int day;

        @SerializedName("hour")
        @Expose
        private int hour;

        @SerializedName("minute")
        @Expose
        private int minute;

        // Getters and setters for Time fields
    }

}







