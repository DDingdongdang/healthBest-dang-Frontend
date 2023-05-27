package com.example.dangdiary.blood.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendBloodRecord {

    //식단 등록시 보내는 값
    public class DateTime {
        @SerializedName("time")  //class로 만들기 swagger보고
        @Expose
        private int time;

        @SerializedName("mealtype")
        @Expose
        private String mealtype;

        @SerializedName("mealtime")
        @Expose
        private String mealtime;


        @SerializedName("sugar")
        @Expose
        private int sugar;

        // Getters and setters for Time fields
    }


}
