package com.example.dangdiary;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Join extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //layout 넘어오기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);
        Intent intent = getIntent();

    }

}
