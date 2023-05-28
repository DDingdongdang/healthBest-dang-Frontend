package com.example.dangdiary.blood.java;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dangdiary.blood.api.BRestApi;
import com.example.dangdiary.blood.dto.BloodCreateResponse;
import com.example.dangdiary.blood.dto.BloodTime;
import com.example.dangdiary.blood.dto.SendBloodRecord;
import com.example.dangdiary.diet.api.RestApi;
import com.example.dangdiary.diet.dto.FoodInfo;
import com.example.dangdiary.diet.dto.SendFoodName;
import com.example.dangdiary.diet.java.WriteFood;
import com.example.dangdiary.menu.BloodOrFood;
import com.example.dangdiary.menu.HomeMenu;
import com.example.dangdiary.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class BloodRegister extends AppCompatActivity {


    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    TextView present_date; // 입력된 날짜 저장되는 곳
    TextView present_time; // 입력된 시간 저장되는 곳
    Button datePicker_btn;
    Button timePicker_btn;
    EditText bloodsugar_editText;

    Button bloodsugar_register_button;

    RadioGroup time_radioGroup;
    String selected_time;
    RadioGroup eatOrNot_radioGroup;
    String selected_eatORNot;

    EditText blood_sugar;

    int mYear;
    int mMonth;
    int mDay;
    int mHour;
    int mMinute;

    int yerin;

    int num;

    private BRestApi jsonPlaceHolderApi;




    // 현재 날짜 표시해주는 메소드
    private String getDateFunc() {
        // 현재 시간을 가져와서 long 변수에 넣어주기
        long now = System.currentTimeMillis();
        Date date = new Date(now);

        // 현재 일자만
        SimpleDateFormat dataFormat1 = new SimpleDateFormat("yyyy/MM/dd");

        // 원하는 현재 시간을 string 형식으로
        String getDate = dataFormat1.format(date);

        return getDate; //string
    }

    // 현재 시간 표시해주는 메소드
    private String getTimeFunc() {
        // 현재 시간을 가져와서 long 변수에 넣어주기
        long now = System.currentTimeMillis();
        Date date = new Date(now);

        // 현재 시간만
        SimpleDateFormat dataFormat2 = new SimpleDateFormat("HH:mm");

        // 원하는 현재 시간을 string 형식으로
        String getTime = dataFormat2.format(date);

        return getTime; //string
    }


    /// 버튼 클릭 이벤트 코드
    public void onClick(View view) {
        // 날짜 수정 버튼 클릭
        if (view == datePicker_btn) {

            final Calendar c = Calendar.getInstance(); // 현재 시간을 담고 있는 calendar를 리턴
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    if (month < 10) {
                        if (dayOfMonth < 10) {
                            present_date.setText(year + "/0" + (month + 1) + "/0" + dayOfMonth);
                        } else {
                            present_date.setText(year + "/0" + (month + 1) + "/" + dayOfMonth);
                        }
                    } else {
                        if (dayOfMonth < 10) {
                            present_date.setText(year + "/" + (month + 1) + "/0" + dayOfMonth);
                        } else {
                            present_date.setText(year + "/" + (month + 1) + "/" + dayOfMonth);
                        }
                    }
                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }

        // 시간 수정 버튼 클릭
        if (view == timePicker_btn) {
            final Calendar c = Calendar.getInstance();
            int mHour = c.get(Calendar.HOUR);
            int mMinute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    // 24시 기준으로 시간 표시해줌!
                    present_time.setText(String.format("%02d:%02d", hourOfDay, minute));
                }
            }, mHour, mMinute, false);
            timePickerDialog.show();
        }

        // 등록 버튼 누르면 홈 화면으로 이동하기

    }


        @Override
        protected void onCreate(Bundle savedInstanceState) {

            //layout 넘어오기
            super.onCreate(savedInstanceState);
            setContentView(R.layout.bloodregister);
            Intent intent = getIntent();


            //통신을 위한 !
            Gson gson = new GsonBuilder().setLenient().create();
            Retrofit retrofit = new Retrofit.Builder() //retorfit 인스턴스 생성
                    .baseUrl("http://43.201.18.52:8080")//서버를 돌릴 ip주소 : port번호
                    .addConverterFactory(GsonConverterFactory.create(gson)) //json 데이터를 자바 객체로 변환
                    .build(); //Retrofit인스턴스를 만들고 반환


            //textview 변수에 담기: 현재 날짜
            present_date = (TextView) findViewById(R.id.present_date);
            present_date.setText(getDateFunc());

            //textview 변수에 담기: 현재 시간
            present_time = (TextView) findViewById(R.id.present_time);
            present_time.setText(getTimeFunc());

            //버튼 변수에 담기
            datePicker_btn = findViewById(R.id.datePicker_btn);
            timePicker_btn = findViewById(R.id.timePicker_btn);

            bloodsugar_register_button = findViewById(R.id.bloodsugar_register_button);

            time_radioGroup = findViewById(R.id.time_radioGroup);
            eatOrNot_radioGroup = findViewById(R.id.eatOrNot_radioGroup);

            blood_sugar = (EditText) findViewById(R.id.bloodsugar_editText);


            // 아침 점심 저녁 라디오 그룹에서 결과값 : selected_time에 저장
            // -> 저장이 되는지는 어캐 확인하는지 모르겠음
            time_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId) {
                        case R.id.breakfast_button:
                            selected_time = "아침";
                            break;
                        case R.id.lunch_button:
                            selected_time = "점심";
                            break;
                        case R.id.dinner_button:
                            selected_time = "저녁";
                            break;

                    }
                }
            });

            //식전 식후 라디오그룹에서 결과값: selected_eatORNot에 저장
            // -> 저장이 되는지는 어캐 확인하는지 모르겠음
            eatOrNot_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId) {
                        case R.id.before_button:
                            selected_eatORNot = "식전";
                            break;
                        case R.id.after_button:
                            selected_eatORNot = "식후";
                            break;
                    }
                }
            });


            bloodsugar_editText = findViewById(R.id.bloodsugar_editText);

            blood_sugar = (EditText) findViewById(R.id.bloodsugar_editText);
            //int bloodSugar_submitted = Integer.parseInt(bloodsugar_editText.getText().toString());
            try{
                String str = bloodsugar_editText.getText().toString().trim();

                 num = Integer.parseInt(str);
            } catch(NumberFormatException e){
                Toast.makeText(this,"숫자만 입력하세요",Toast.LENGTH_SHORT).show();
            }

            //yerin = 100;


            jsonPlaceHolderApi = retrofit.create(BRestApi.class);


            bloodsugar_register_button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    //int year = 2023;
                    BloodTime time = new BloodTime(mYear, mMonth, mDay, mHour, mMinute);
                    SendBloodRecord sendBloodRecord = new SendBloodRecord(time, selected_time, selected_eatORNot, num);

                    Call<BloodCreateResponse> call = jsonPlaceHolderApi.sendBloodRecord(sendBloodRecord);
                    call.enqueue(new Callback<BloodCreateResponse>() {
                        @Override
                        public void onResponse(Call<BloodCreateResponse> call, Response<BloodCreateResponse> response) {
                            if (response.isSuccessful()) {
                                BloodCreateResponse bloodCreateResponse = response.body();
                            }
                        }
                        @Override
                        public void onFailure(Call<BloodCreateResponse> call, Throwable t) {
                        }
                    });





                    Intent intent1 = new Intent(BloodRegister.this, HomeMenu.class);//현재,이동 적기
                    startActivity(intent1);

                }


            });

        }


}
