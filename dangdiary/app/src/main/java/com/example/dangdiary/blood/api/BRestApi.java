package com.example.dangdiary.blood.api;

import com.example.dangdiary.blood.dto.BloodCreateResponse;
import com.example.dangdiary.blood.dto.RequestBlood;
import com.example.dangdiary.blood.dto.SendBloodRecord;
import com.example.dangdiary.diet.dto.FoodInfo;
import com.example.dangdiary.diet.dto.SendFoodRecord;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BRestApi {


    //혈당기록 전송
    @POST("/api/v1/sugars")
    Call<BloodCreateResponse> sendBloodRecord(
            @Body SendBloodRecord sendBloodRecord);



    //혈당 조회 요청
    @GET("/api/v1/sugars")
    Call<RequestBlood> requestBlood(
            @Query("year") int year,
            @Query("month") int month,
            @Query("day") int day );




    //Call<FoodInfo> SendFoodName(@Query("name") String foodName );

}
