package com.example.dangdiary;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class FoodView extends AppCompatActivity {

    // 상단 날짜 조절 버튼
    private Button main_back_btn;
    private Button main_next_btn;
    TextView main_today_textview;

    ListView listView;
    FoodViewAdapter foodViewAdapter;
    ArrayList<FoodViewItem> FoodViewItemArrList;

    // 현재 날짜 표시해주는 메소드
    private String getDateFunc() {
        // 현재 시간을 가져와서 long 변수에 넣어주기
        long now = System.currentTimeMillis();
        Date date = new Date(now);

        // 현재 일자만
        SimpleDateFormat dataFormat1 = new SimpleDateFormat("MM월 dd일");

        // 원하는 현재 시간을 string 형식으로
        String getDate = dataFormat1.format(date);

        return getDate;
    }

    public void onClick(View view) {
        // 전날 버튼 클릭
        if (view == main_back_btn) {

        }

        // 다음날 버튼 클릭
        if (view == main_next_btn) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodview);
        listView = (ListView)findViewById(R.id.todayMeal_listview);
        FoodViewItemArrList = new ArrayList<FoodViewItem>();

        Intent intent = getIntent();

        // 상단 날짜 조정 버튼
        main_back_btn = findViewById(R.id.main_back_btn);
        main_next_btn = findViewById(R.id.main_next_btn);

        // 오늘 날짜
        main_today_textview = (TextView) findViewById(R.id.main_today_textview);
        main_today_textview.setText(getDateFunc());

//        FoodViewItemArrList.add(new FoodViewItem(R.mipmap.ic_launcher,"아침", "미역국", 300));
//
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            FoodViewItemArrList.add(new FoodViewItem(R.mipmap.ic_launcher,"아침", "미역국", 300));
//            FoodViewItemArrList.add(new FoodViewItem(R.mipmap.ic_launcher,"아침", LocalDateTime.now(), "미역국", 300));
        }

        // adapter 객체 생성 후 listview 객체에 setAdapter를 통해 Adapter 연결
        foodViewAdapter = new FoodViewAdapter(FoodView.this, FoodViewItemArrList);
        listView.setAdapter(foodViewAdapter);

    }



}
