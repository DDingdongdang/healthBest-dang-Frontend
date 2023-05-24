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

package com.example.dangdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import com.example.dangdiary.Post;

/* 여기서부터
public class WriteFood extends AppCompatActivity {
    private TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //화면 전환
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writefood);
        Intent intent = getIntent();

        textViewResult = findViewById(R.id.text_view_result); //결과가 나올 txt view
        Retrofit retrofit = new Retrofit.Builder() //retorfit 인스턴스 생성
                .baseUrl("http://43.201.18.52:8080")//서버를 돌릴 ip주소 : port번호
                .addConverterFactory(GsonConverterFactory.create()) //json 데이터를 자바 객체로 변환
                .build(); //Retrofit인스턴스를 만들고 반환

        RestApi jsonPlaceHolderApi = retrofit.create(RestApi.class); //restapi 인스턴스 생성
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts(); //서버에 대한 http get요청을 나타내는 call 객체 생성
        //restapi에서 정의했던 getPosts 메서드를 호출
        call.enqueue(new Callback<List<Post>>() { //enqueue() 메서드는 비동기적으로 요청을 실행(응답 기다리지X)
            //Callback<List<Post>> -> 비동기적인 http 요청결과를 처리하는 메서드 정의

            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                List<Post> posts = response.body(); //응답을 처리하는 부분 List<post>형식으로 반환
                for (Post post : posts) { //post목록에 있는 각 게시물을 가져온다
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Content: " + post.getContent() + "\n\n";
                    textViewResult.append(content); //content에 추가한다.
                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}여기까지 돌아가는거 확인 밑에는 list 제거하는 코드*/

public class WriteFood extends AppCompatActivity {
    private TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //화면 전환
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writefood);
        Intent intent = getIntent();

        textViewResult = findViewById(R.id.text_view_result); //결과가 나올 txt view
        Retrofit retrofit = new Retrofit.Builder() //retorfit 인스턴스 생성
                .baseUrl("http://43.201.18.52:8080")//서버를 돌릴 ip주소 : port번호
                .addConverterFactory(GsonConverterFactory.create()) //json 데이터를 자바 객체로 변환
                .build(); //Retrofit인스턴스를 만들고 반환

        RestApi jsonPlaceHolderApi = retrofit.create(RestApi.class); //restapi 인스턴스 생성
        Call<Post> call = jsonPlaceHolderApi.getPosts(); //서버에 대한 http get요청을 나타내는 call 객체 생성
        //restapi에서 정의했던 getPosts 메서드를 호출
        call.enqueue(new Callback<Post>() { //enqueue() 메서드는 비동기적으로 요청을 실행(응답 기다리지X)
            //Callback<List<Post>> -> 비동기적인 http 요청결과를 처리하는 메서드 정의

            @Override
            public void onResponse(Call<Post> call, Response<Post>response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                Post post = response.body(); //응답을 처리하는 부분 List<post>형식으로 반환

                String content = "";
                content += "ID: " + post.getId() + "\n";
                content += "Title: " + post.getTitle() + "\n";
                content += "Content: " + post.getContent() + "\n\n";
                textViewResult.append(content); //content에 추가한다.

            }
            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}