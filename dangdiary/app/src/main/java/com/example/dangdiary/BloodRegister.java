package com.example.dangdiary;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class BloodRegister extends AppCompatActivity {

    TextView dateText;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //layout 넘어오기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bloodregister);
        Intent intent = getIntent();

        //textview 변수에 담기
        dateText = findViewById(R.id.check_date_title);
        //버튼 변수에 담기
        Button datePicker_btn = findViewById(R.id.datePicker_btn);
        //버튼 클릭 이벤트 설정
        datePicker_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //오늘 날짜(년,월,일) 변수에 담기
                Calendar calendar = Calendar.getInstance();
                int pYear = calendar.get(Calendar.YEAR);
                int pMonth = calendar.get(Calendar.MONTH);
                int pDay = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(BloodRegister.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                month = month +1; //1월은 0부터 시작하기 때문에 +1 표기
                                String date = year+"/"+month+"/"+dayOfMonth;
                                dateText.setText(date);
                            }
                        }, pYear, pMonth, pDay);
                datePickerDialog.show();

            } //OnClick
        });
    } //onCreate

} //BloodRegister
