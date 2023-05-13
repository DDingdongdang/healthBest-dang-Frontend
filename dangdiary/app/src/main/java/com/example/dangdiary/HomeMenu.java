package com.example.dangdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeMenu extends AppCompatActivity {

    private Button button_plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homemenu);
        //tv_sub = findViewById(R.id.tv_sub);
        Intent intent = getIntent();
        //String str = intent.getStringExtra("str");
        //tv_sub.setText(str);


        //plus_btn 입력시 -> 혈당 식단 중 하나 고름

        button_plus = findViewById(R.id.btn_plus);

        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeMenu.this, BloodOrFood.class);//현재,이동 적기
                startActivity(intent);
            }

        });

    }
}









