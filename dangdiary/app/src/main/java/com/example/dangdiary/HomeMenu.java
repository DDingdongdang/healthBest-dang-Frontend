package com.example.dangdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class HomeMenu extends AppCompatActivity {

    // 하단 네비게이션 바 버튼
    private Button btn_plus;
    private Button btn_home;
    private Button btn_blood;
    private Button btn_food;
    private Button btn_mypage;

    // ListView
    private ListView whatIEat_layout;

    // 상단 날짜 조절 버튼
    Button main_back_btn;
    Button main_next_btn;

    TextView main_today_textview;

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

    /// 버튼 클릭 이벤트 코드
    public void onClick(View view) {
        // 전날 버튼 클릭
        if (view == main_back_btn) {

        }

        // 다음날 버튼 클릭
        if (view == main_next_btn) {

        }


        // + 버튼 누르고 화면 이동
        if (view == btn_plus){
            Intent intent1 = new Intent(HomeMenu.this, BloodOrFood.class);//현재,이동 적기
            startActivity(intent1);
        }

        // mypage 버튼 누르고 화면 이동 :: my page 파일 만들기!!
//        if (view == btn_mypage){
//            Intent intent1 = new Intent(HomeMenu.this, myPage.class);//현재,이동 적기
//            startActivity(intent1);
//        }

        // food 버튼 누르고 화면 이동
//        if (view == btn_food){
//            Intent intent1 = new Intent(HomeMenu.this, 식단조회페이지.class);//현재,이동 적기
//            startActivity(intent1);
//        }

        // blood 버튼 누르고 화면 이동
//        if (view == btn_blood){
//            Intent intent1 = new Intent(HomeMenu.this, 혈당조회페이지.class);//현재,이동 적기
//            startActivity(intent1);
//        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homemenu);
        //tv_sub = findViewById(R.id.tv_sub);
        Intent intent = getIntent();
        //String str = intent.getStringExtra("str");
        //tv_sub.setText(str);

        //ListView
        whatIEat_layout = (ListView) findViewById(R.id.whatIEat_layout);

        //하단 네이게이션 바 버튼
        btn_plus = findViewById(R.id.btn_plus);
        btn_blood = findViewById(R.id.btn_blood);
        btn_food = findViewById(R.id.btn_food);
        btn_home = findViewById(R.id.btn_home);
        btn_mypage = findViewById(R.id.btn_mypage);

        // 상단 날짜 조정 버튼
        main_back_btn = findViewById(R.id.main_back_btn);
        main_next_btn = findViewById(R.id.main_next_btn);

        // 오늘 날짜
        main_today_textview = (TextView) findViewById(R.id.main_today_textview);
        main_today_textview.setText(getDateFunc());

//        btn_plus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HomeMenu.this, BloodOrFood.class);//현재,이동 적기
//                startActivity(intent);
//            }
//
//        });

    }

    // Adapter
    class MyAdapter extends BaseAdapter{

    }
}









