package com.example.dangdiary.diet.dto;

import com.google.gson.annotations.SerializedName;

public class Post {


    private long id;

    private String title;

    private String content;

    public long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }

}
