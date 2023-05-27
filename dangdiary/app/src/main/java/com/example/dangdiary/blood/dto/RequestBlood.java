package com.example.dangdiary.blood.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



//내가 혈당 조회할 때 보내는 값
public class RequestBlood {

    public class Date {
        @SerializedName("year")
        @Expose
        private int year;

        @SerializedName("month")
        @Expose
        private int month;

        @SerializedName("day")
        @Expose
        private int day;

        // Getters and setters for Time fields
    }

}