package com.example.dangdiary.diet.java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dangdiary.R;
import com.example.dangdiary.blood.java.BloodView;
import com.example.dangdiary.menu.BloodOrFood;
import com.example.dangdiary.menu.HomeMenu;
import com.example.dangdiary.menu.MyPage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FoodView extends AppCompatActivity {

    // 하단 네비게이션 바 버튼
    private Button btn_plus;
    private Button btn_home;
    private Button btn_blood;
    private Button btn_food;
    private Button btn_mypage;

    // 상단 날짜 조절 버튼
    private Button main_back_btn;
    private Button main_next_btn;
    TextView main_today_textview;

    private RecyclerView mRecyclerView;
    private ArrayList<FoodViewItem> mList;
    private FoodViewAdapter mRecyclerViewAdapter;


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
// + 버튼 누르고 화면 이동
        if (view == btn_plus) {
            Intent intent1 = new Intent(FoodView.this, BloodOrFood.class);//현재,이동 적기
            startActivity(intent1);
        }

        // food 버튼 누르고 화면 이동
        if (view == btn_blood) {
            Intent intent3 = new Intent(FoodView.this, BloodView.class);//현재,이동 적기
            startActivity(intent3);
        }

        //home 버튼 누르고 화면 이동
        if (view == btn_home){
            Intent intent1 = new Intent(FoodView.this, HomeMenu.class);//현재,이동 적기
            startActivity(intent1);
        }

        //mypage 버튼 누르고 화면 이동
        if (view == btn_mypage){
            Intent intent1 = new Intent(FoodView.this, MyPage.class);//현재,이동 적기
            startActivity(intent1);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodview);

        Intent intent = getIntent();

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


        mRecyclerView = (RecyclerView)findViewById(R.id.todayMeal_recyclerView);
        mList = new ArrayList<>();
        // recyclerView에 넣어줄 값들
        for(int i = 0; i<5; i++){
            addItem("iconName","아침","미역국",300, 20.3);
        }

        System.out.print(mList);

        mRecyclerViewAdapter = new FoodViewAdapter(mList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void addItem(String food_photo, String mealType, String menuName, double dangAmount, double carbon){
        FoodViewItem item = new FoodViewItem();
        item.setFood_photo(food_photo);
        item.setMealType(mealType);
        item.setMenuName(menuName);
        item.setFoodSugar(dangAmount);
        item.setCarbon(carbon);

        mList.add(item);
    }

}
