/*
package com.example.dangdiary;

import android.content.Intent;
import android.os.Bundle;
//import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import androidx.appcompat.app.AppCompatActivity;


public class WriteFood extends AppCompatActivity {

    TextView str_info; //받아올 정보
    EditText str_foodname; //전송할 음식 이름

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //layout 넘어오기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writefood);
        Intent intent = getIntent();

        str_info = (TextView)findViewById(R.id.str_info);
        str_foodname = (EditText)findViewById(R.id.str_foodname);
    }


}
*/

package com.example.dangdiary.diet.java;

import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;

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


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.dangdiary.R;
import com.example.dangdiary.blood.java.BloodRegister;
import com.example.dangdiary.diet.api.RestApi;
import com.example.dangdiary.diet.dto.FoodInfo;
import com.example.dangdiary.diet.dto.SendFoodName;
import com.example.dangdiary.menu.BloodOrFood;
import com.example.dangdiary.menu.HomeMenu;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class WriteFood extends AppCompatActivity {


    private Button btn_send;
    private Button btn_register;

    private EditText food_name;
    private TextView textViewResult; //영양성분 결과

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







    private RestApi jsonPlaceHolderApi;


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

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //화면 전환
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writefood);
        Intent intent = getIntent();


        present_date = (TextView) findViewById(R.id.present_date);
        present_date.setText(getDateFunc());

        //textview 변수에 담기: 현재 시간
        present_time = (TextView) findViewById(R.id.present_time);
        present_time.setText(getTimeFunc());

        //버튼 변수에 담기
        datePicker_btn = findViewById(R.id.datePicker_btn);
        timePicker_btn = findViewById(R.id.timePicker_btn);


        time_radioGroup = findViewById(R.id.time_radioGroup);



        time_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
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


        //안되면 여기 주석 열기
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder() //retorfit 인스턴스 생성
                .baseUrl("http://43.201.18.52:8080")//서버를 돌릴 ip주소 : port번호
                .addConverterFactory(GsonConverterFactory.create(gson)) //json 데이터를 자바 객체로 변환
                .build(); //Retrofit인스턴스를 만들고 반환





        jsonPlaceHolderApi = retrofit.create(RestApi.class);

        //뷰 초기화
        food_name = (EditText)findViewById(R.id.food_name);
        textViewResult = findViewById(R.id.text_view_result);
        btn_send = findViewById(R.id.btn_send);
        btn_register = findViewById(R.id.btn_register);


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(WriteFood.this, HomeMenu.class);//현재,이동 적기
                startActivity(intent1);
            }

        });



        //버튼 클릭시
        btn_send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String foodName = food_name.getText().toString();

                // SendFoodName 객체 생성 및 데이터 설정
                SendFoodName sendFoodName = new SendFoodName();
                sendFoodName.setName(foodName);


                String SendFoodName;
                Call<FoodInfo> call = jsonPlaceHolderApi.SendFoodName(foodName); //이름을 보내고
                //FoodInfo를 받아온다.
                call.enqueue(new Callback<FoodInfo>() {
                    @Override
                    public void onResponse(Call<FoodInfo> call, Response<FoodInfo> response) {
                        if (response.isSuccessful()) {
                            FoodInfo foodInfo = response.body();
                            // 받은 응답을 처리하는 로직 작성
                            String result = "" +
                                    "이름: " + foodInfo.getName() + "\n" +
                                    "칼로리: " + foodInfo.getCalorie() + "\n" +
                                    "탄수화물: " + foodInfo.getCarbohydrate() + "\n" +
                                    "단백질: " + foodInfo.getProtein() + "\n" +
                                    "지방: " + foodInfo.getFat() + "\n" +
                                    "당류: " + foodInfo.getSugars() + "\n" +
                                    "나트륨: " + foodInfo.getSodium();

                            textViewResult.setText(result);
                        } else {
                            textViewResult.setText("Code: " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<FoodInfo> call, Throwable t) {
                        textViewResult.setText(t.getMessage());
                    }
                });
            }
        });


    }
}


