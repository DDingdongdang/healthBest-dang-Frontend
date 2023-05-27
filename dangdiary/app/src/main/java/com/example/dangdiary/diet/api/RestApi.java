package com.example.dangdiary.diet.api;

import com.example.dangdiary.diet.dto.Post;
import com.example.dangdiary.diet.dto.SendFoodName;
import com.example.dangdiary.diet.dto.FoodInfo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Path;
import retrofit2.http.Query;

/*public interface RestApi {
    @GET("/api/v1/test2")  ///api/v1/test2로 HTTP GET요청을 수행
    Call<List<Post>> getPosts(); //서버에서 받은 응답을 처리하기 위한 메서드
}*/

public interface RestApi {
    @GET("/api/v1/test2")  ///api/v1/test2로 HTTP GET요청을 수행
    Call<Post> getPosts(); //서버에서 받은 응답을 처리하기 위한 메서드
    //Call<List<Post>> getPosts();

    @GET("/api/v1/foods/info")
    Call<FoodInfo> SendFoodName(@Query("name") String foodName );




}


