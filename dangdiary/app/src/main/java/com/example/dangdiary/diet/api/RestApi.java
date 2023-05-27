package com.example.dangdiary.diet.api;

import com.example.dangdiary.diet.dto.Post;
import com.example.dangdiary.diet.dto.SendFoodName;
import com.example.dangdiary.diet.dto.FoodInfo;
import com.example.dangdiary.diet.dto.SendRecord;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/*public interface RestApi {
    @GET("/api/v1/test2")  ///api/v1/test2로 HTTP GET요청을 수행
    Call<List<Post>> getPosts(); //서버에서 받은 응답을 처리하기 위한 메서드
}*/

public interface RestApi {

    //통신test
    @GET("/api/v1/test2")  ///api/v1/test2로 HTTP GET요청을 수행
    Call<Post> getPosts(); //서버에서 받은 응답을 처리하기 위한 메서드
    //Call<List<Post>> getPosts();


    //영양성분을 가져오기 위한 음식 이름 전송
    @GET("/api/v1/foods/info")
    Call<FoodInfo> SendFoodName(@Query("name") String foodName );


    //음식기록 전송
    @POST("/api/v1/diets")
    Call<SendRecord> sendRecord(@Body SendRecord sendRecord);







}


