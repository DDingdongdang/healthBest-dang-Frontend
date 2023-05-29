package com.example.dangdiary.diet.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FoodTime {
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

    public FoodTime(int year, int month, int day, int hour, int minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }
}
