package com.example.dangdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dangdiary.blood.java.BloodRegister;
import com.example.dangdiary.diet.java.FoodRegister;

public class BloodOrFood extends AppCompatActivity {

    private Button button_pblood;
    private Button button_pfood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //layout 넘어오기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bloodorfood);
        Intent intent = getIntent();



        //혈당 등록 클릭시 -> 혈당 등록 페이지로 넘어감
        button_pblood = findViewById(R.id.button_pblood);

        button_pblood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(BloodOrFood.this, BloodRegister.class);//현재,이동 적기
                startActivity(intent1);
            }

        });

        //식단 등록 -> 식단등록 페이지로 넘어감
        button_pfood = findViewById(R.id.button_pfood);

        button_pfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(BloodOrFood.this, FoodRegister.class);//현재,이동 적기
                startActivity(intent2);
            }

        });


    }
}
