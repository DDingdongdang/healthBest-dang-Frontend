package com.example.dangdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class HomeMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
        //tv_sub = findViewById(R.id.tv_sub);
        Intent intent = getIntent();
        //String str = intent.getStringExtra("str");
        //tv_sub.setText(str);
    }


}
