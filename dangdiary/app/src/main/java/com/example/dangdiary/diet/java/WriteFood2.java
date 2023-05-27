package com.example.dangdiary.diet.java;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dangdiary.R;


public class WriteFood2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //layout 넘어오기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writefood2);
        Intent intent = getIntent();
    }

}