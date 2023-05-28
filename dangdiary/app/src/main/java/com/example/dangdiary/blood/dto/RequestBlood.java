package com.example.dangdiary.blood.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



//내가 혈당 조회할 때 보내는 값
public class RequestBlood {
    
    @SerializedName("year")
    @Expose
    private int year;
    public void setYear(int year){ this.year = year; }



    @SerializedName("month")
    @Expose
    private int month;
    public void setMonth(int month) { this.month = month; }



    @SerializedName("day")
    @Expose
    private int day;
    public void setDay(int day) { this.day = day;}



}
