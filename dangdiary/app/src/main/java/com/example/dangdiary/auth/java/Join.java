package com.example.dangdiary.auth.java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dangdiary.R;
import com.example.dangdiary.auth.api.ARestApi;
import com.example.dangdiary.auth.dto.SignUp;
import com.example.dangdiary.auth.dto.UserCreateResponse;
import com.example.dangdiary.blood.api.BRestApi;
import com.example.dangdiary.blood.dto.BloodCreateResponse;
import com.example.dangdiary.blood.dto.BloodTime;
import com.example.dangdiary.blood.dto.SendBloodRecord;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Join extends AppCompatActivity {

    private Button btn_register, validateButton;
    private RadioGroup sex_radioGroup;
    private EditText et_id, et_pass, et_passck, et_height, et_weight, et_age, et_nickname;
    private String selected_sex;
    String userID;
    String userPass;
    String userPassCk;
    String userNickname;
    int userAge, userHeight, userWeight;

    private ARestApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder() //retorfit 인스턴스 생성
                .baseUrl("http://43.201.18.52:8080")//서버를 돌릴 ip주소 : port번호
                .addConverterFactory(GsonConverterFactory.create(gson)) //json 데이터를 자바 객체로 변환
                .build(); //Retrofit인스턴스를 만들고 반


        jsonPlaceHolderApi = retrofit.create(ARestApi.class);



        //layout 넘어오기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);
        Intent intent = getIntent();

        //아이디 값 찾아주기
        et_id=findViewById(R.id.et_id);
        et_pass=findViewById(R.id.et_pass);
        et_nickname=findViewById(R.id.et_nickname);
        et_age=findViewById(R.id.et_age);
        et_height=findViewById(R.id.et_height);
        et_weight=findViewById(R.id.et_weight);
        et_passck=findViewById(R.id.et_passck);

        // 중복확인 버튼
        validateButton = (Button) findViewById(R.id.validateButton);

        sex_radioGroup = findViewById(R.id.sex_radioGroup);
        sex_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn_female:
                        selected_sex = "FEMALE";
                        break;
                    case R.id.btn_male:
                        selected_sex = "MALE";
                        break;
                }
            }
        });







        // 회원가입 버튼
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //editText에 입력되어있는 값을 get(가져온다)해온다
                userID=et_id.getText().toString();
                userPass=et_pass.getText().toString();
                userPassCk=et_passck.getText().toString();
                userNickname=et_nickname.getText().toString();
                try{
                    String str = et_age.getText().toString().trim();

                    userAge = Integer.parseInt(str);
                } catch(NumberFormatException e){
                }
                try{
                    String str = et_height.getText().toString().trim();

                    userWeight = Integer.parseInt(str);
                } catch(NumberFormatException e){
                }
                try{
                    String str = et_weight.getText().toString().trim();

                    userHeight = Integer.parseInt(str);
                } catch(NumberFormatException e){
                }

                Intent intent = new Intent(Join.this, MainActivity.class);//현재,이동 적기
                startActivity(intent);


                SignUp signUp = new SignUp(userID, userPass, userNickname, selected_sex, userAge, userHeight, userWeight);


                Call<SignUp> call = jsonPlaceHolderApi.signup(signUp);

                call.enqueue(new Callback<SignUp>() {
                    @Override
                    public void onResponse(Call<SignUp> call, Response<SignUp> response) {
                        if (response.isSuccessful()) {
                            SignUp userCreateResponse = response.body();
                        }
                    }

                    @Override
                    public void onFailure(Call<SignUp> call, Throwable t) {

                    }


                });



            }



        });


    }

}
