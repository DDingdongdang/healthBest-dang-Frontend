package com.example.dangdiary.blood.dto;

import com.example.dangdiary.diet.dto.SendFoodRecord;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendBloodRecord {

    //혈당 등록시 보내는 값
    @SerializedName("time")
    @Expose
    private BloodTime time;

    @SerializedName("mealtype")
    @Expose
    private String mealtype;

    @SerializedName("mealtime")
    @Expose
    private String mealtime;


    @SerializedName("sugar")
    @Expose
    private int sugar;


//    public class Time {
//        @SerializedName("year")
//        @Expose
//        private int year;
//
//        @SerializedName("month")
//        @Expose
//        private int month;
//
//        @SerializedName("day")
//        @Expose
//        private int day;
//
//        @SerializedName("hour")
//        @Expose
//        private int hour;
//
//        @SerializedName("minute")
//        @Expose
//        private int minute;
//        // Getters and setters for Time fields
//    }

    public SendBloodRecord(BloodTime time, String mealtype, String mealtime, int sugar) {
        this.time = time;
        this.mealtype = mealtype;
        this.mealtime = mealtime;
        this.sugar = sugar;
    }
}

