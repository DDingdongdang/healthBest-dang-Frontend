package com.example.dangdiary.auth.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignUp {

    @SerializedName("loginId")
    @Expose
    private String loginId;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("nickname")
    @Expose
    private String nickname;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("age")
    @Expose
    private int age;

    @SerializedName("height")
    @Expose
    private int height;

    @SerializedName("weight")
    @Expose
    private int weight;


}
