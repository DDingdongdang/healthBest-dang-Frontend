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

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.dangdiary.BloodOrFood;
import com.example.dangdiary.BloodRegister;
import com.example.dangdiary.R;
import com.example.dangdiary.diet.api.RestApi;
import com.example.dangdiary.diet.dto.FoodInfo;
import com.example.dangdiary.diet.dto.Post;
import com.example.dangdiary.diet.dto.SendFoodName;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class WriteFood extends AppCompatActivity {


    private Button btn_send;
    private EditText food_name;
    private TextView textViewResult; //영양성분 결과

    private RestApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //화면 전환
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writefood);
        Intent intent = getIntent();

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



        //버튼 클릭시
        btn_send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String foodName = food_name.getText().toString();

                // SendFoodName 객체 생성 및 데이터 설정
                SendFoodName sendFoodName = new SendFoodName();
                sendFoodName.setName(foodName);


                String SendFoodName;
                Call<FoodInfo> call = jsonPlaceHolderApi.SendFoodName("불고기"); //이름을 보내고
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
    /*private void request() {
        textViewResult = findViewById(R.id.text_view_result); //결과가 나올 txt view
        Retrofit retrofit = new Retrofit.Builder() //retorfit 인스턴스 생성
                .baseUrl("http://43.201.18.52:8080")//서버를 돌릴 ip주소 : port번호
                .addConverterFactory(GsonConverterFactory.create()) //json 데이터를 자바 객체로 변환
                .build(); //Retrofit인스턴스를 만들고 반환

        RestApi jsonPlaceHolderApi = retrofit.create(RestApi.class); //restapi 인스턴스 생성
        //  Call<Post> call = jsonPlaceHolderApi.getPosts(); //서버에 대한 http get요청을 나타내는 call 객체 생성
        //restapi에서 정의했던 getPosts 메서드를 호출

        Call<FoodInfo> call = jsonPlaceHolderApi.SendFoodName(sendData());

        call.enqueue(new Callback<FoodInfo>() {
            @Override
            public void onResponse(Call<FoodInfo> call, Response<FoodInfo> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                FoodInfo foodInfo = response.body(); //응답을 처리하는 부분 List<post>형식으로 반환

                String content = "";
                content += "열량 : " + foodInfo.getCalorie() + "\n";
                content += "탄수화물 : " + foodInfo.getCarbohydrate() + "\n";
                content += "단백질 : " + foodInfo.getProtein() + "\n";
                content += "지방 : " + foodInfo.getFat() + "\n";
                content += "당류 : " + foodInfo.getSugars() + "\n";
                content += "염분 : " + foodInfo.getSodium() + "\n";

                textViewResult.append(content); //content에 추가한다.
            }

            @Override
            public void onFailure(Call<FoodInfo> call, Throwable t) {

            }

        });
    }

    private SendFoodName sendData() {

        //edit text에서 음식 이름 가져오기
        String foodName = food_name.getText().toString();

        SendFoodName sendFoodName = new SendFoodName();
        sendFoodName.setName(foodName); //객체에 이름을 넣어

        return sendFoodName;
    }


}*/


