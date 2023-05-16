package com.example.dangdiary;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BloodRegister2 extends AppCompatActivity {


    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    TextView present_date;
    TextView present_time;
    Button datePicker_btn;
    Button timePicker_btn;


    // 현재 날짜 표시해주는 메소드
    private String getDateFunc() {
        // 현재 시간을 가져와서 long 변수에 넣어주기
        long now = System.currentTimeMillis();
        Date date = new Date(now);

        // 현재 일자만
        SimpleDateFormat dataFormat1 = new SimpleDateFormat("yyyy/MM/dd");

        // 원하는 현재 시간을 string 형식으로
        String getDate = dataFormat1.format(date);

        return getDate;
    }

    // 현재 시간 표시해주는 메소드
    private String getTimeFunc() {
        // 현재 시간을 가져와서 long 변수에 넣어주기
        long now = System.currentTimeMillis();
        Date date = new Date(now);

        // 현재 시간만
        SimpleDateFormat dataFormat2 = new SimpleDateFormat("hh:mm");

        // 원하는 현재 시간을 string 형식으로
        String getTime = dataFormat2.format(date);

        return getTime;
    }


    /// 버튼 클릭 이벤트 코드
    public void onClick(View view){
        // 날짜 수정 버튼 클릭
        if (view == datePicker_btn) {
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    present_date.setText(year+"/"+(month+1)+"/"+dayOfMonth);
                }
            },mYear, mMonth, mDay);
            datePickerDialog.show();
        }

        // 시간 수정 버튼 클릭
        if (view == timePicker_btn){
            final Calendar c = Calendar.getInstance();
            int mHour = c.get(Calendar.HOUR);
            int mMinute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    present_time.setText(String.format("%02d:%02d", hourOfDay, minute));
                }
            },mHour, mMinute,false);
            timePickerDialog.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //layout 넘어오기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bloodregister2);
        Intent intent = getIntent();

        //textview 변수에 담기: 현재 날짜
        present_date = (TextView) findViewById(R.id.present_date);
        present_date.setText(getDateFunc());

        //textview 변수에 담기: 현재 시간
        present_time = (TextView) findViewById(R.id.present_time);
        present_time.setText(getTimeFunc());

        //버튼 변수에 담기
        datePicker_btn = findViewById(R.id.datePicker_btn);
        timePicker_btn = findViewById(R.id.timePicker_btn);


    }
} //BloodRegister2
