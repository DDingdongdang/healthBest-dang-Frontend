package com.example.dangdiary.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dangdiary.R;
import com.example.dangdiary.blood.java.BloodView;
import com.example.dangdiary.diet.java.FoodView;

public class MyPage extends AppCompatActivity {

    // 하단 네비게이션 바 버튼
    private Button btn_plus;
    private Button btn_home;
    private Button btn_blood;
    private Button btn_food;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);
        //하단 네이게이션 바 버튼
        btn_plus = findViewById(R.id.btn_plus);
        btn_blood = findViewById(R.id.btn_blood);
        btn_food = findViewById(R.id.btn_food);
        btn_home = findViewById(R.id.btn_home);
    }

    public void onClick(View view) {
        // + 버튼 누르고 화면 이동
        if (view == btn_plus) {
            Intent intent1 = new Intent(MyPage.this, BloodOrFood.class);//현재,이동 적기
            startActivity(intent1);
        }

        // food 버튼 누르고 화면 이동
        if (view == btn_food) {
            Intent intent3 = new Intent(MyPage.this, FoodView.class);//현재,이동 적기
            startActivity(intent3);
        }

        //blood 버튼 누르고 화면 이동
        if (view == btn_blood){
            Intent intent1 = new Intent(MyPage.this, BloodView.class);//현재,이동 적기
            startActivity(intent1);
        }

        //home 버튼 누르고 화면 이동
        if (view == btn_home){
            Intent intent1 = new Intent(MyPage.this, HomeMenu.class);//현재,이동 적기
            startActivity(intent1);
        }
    }
}
