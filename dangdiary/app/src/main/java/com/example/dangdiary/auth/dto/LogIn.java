package com.example.dangdiary.auth.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogIn {

    @SerializedName("Id")
    @Expose
    private String Id;

    @SerializedName("Password")
    @Expose
    private String Password;

}
