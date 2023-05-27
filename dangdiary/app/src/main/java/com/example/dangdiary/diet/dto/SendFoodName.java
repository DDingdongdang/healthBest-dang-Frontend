package com.example.dangdiary.diet.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendFoodName {

    @SerializedName("name")
    @Expose
    private String name;

    public void setName(String name) {
        this.name = name;
    }



}
