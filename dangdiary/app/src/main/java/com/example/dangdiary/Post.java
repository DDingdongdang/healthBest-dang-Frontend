package com.example.dangdiary;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("id")
    private long id;
    @SerializedName("title")
    private String title;
    @SerializedName("content")
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
