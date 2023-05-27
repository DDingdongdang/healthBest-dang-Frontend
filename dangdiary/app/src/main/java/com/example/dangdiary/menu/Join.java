package com.example.dangdiary.menu;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dangdiary.R;

public class Join extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //layout 넘어오기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);
        Intent intent = getIntent();

    }

}
