package com.example.dangdiary.auth.dto;

import com.example.dangdiary.blood.dto.BloodTime;
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


    public SignUp(String loginId, String password, String nickname, String gender , int age, int heigth, int weight) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;

    }






}
