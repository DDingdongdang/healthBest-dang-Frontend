package com.example.dangdiary;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class BloodView extends AppCompatActivity {

    // 상단 날짜 조절 버튼
    private Button main_back_btn;
    private Button main_next_btn;
    TextView main_today_textview;

    private RecyclerView mRecyclerView;
    private ArrayList<BloodViewItem> mList;
    private BloodViewAdapter mRecyclerViewAdapter;


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
        setContentView(R.layout.bloodview);

        Intent intent = getIntent();

        // 상단 날짜 조정 버튼
        main_back_btn = findViewById(R.id.main_back_btn);
        main_next_btn = findViewById(R.id.main_next_btn);

        // 오늘 날짜
        main_today_textview = (TextView) findViewById(R.id.main_today_textview);
        main_today_textview.setText(getDateFunc());


        mRecyclerView = (RecyclerView)findViewById(R.id.todayBloodSugar_recyclerView);
        mList = new ArrayList<>();
        // recyclerView에 넣어줄 값들
        for(int i = 0; i<5; i++){
            addItem("아침","식전",8,40, 260);
        }

        System.out.print(mList);

        mRecyclerViewAdapter = new BloodViewAdapter(mList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void addItem(String mealType, String mealTime, int date_hour, int date_minute, int sugar){
        BloodViewItem item = new BloodViewItem();
        item.setMealType(mealType);
        item.setMealTime(mealTime);
        item.setDate_hour(date_hour);
        item.setDate_minute(date_minute);
        item.setSugar(sugar);

        mList.add(item);
    }



}
