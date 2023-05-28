package com.example.dangdiary.auth.api;


import com.example.dangdiary.auth.dto.SignUp;
import com.example.dangdiary.blood.dto.BloodCreateResponse;
import com.example.dangdiary.blood.dto.SendBloodRecord;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ARestApi {

    //회원가입정보 전송
    @POST("/api/v1/auth/sign-up")
    Call<SignUp> signup(@Body SignUp signUp);

}
