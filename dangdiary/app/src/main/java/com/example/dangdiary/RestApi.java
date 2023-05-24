package com.example.dangdiary;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/*public interface RestApi {
    @GET("/api/v1/test2")  ///api/v1/test2로 HTTP GET요청을 수행
    Call<List<Post>> getPosts(); //서버에서 받은 응답을 처리하기 위한 메서드
}*/

public interface RestApi {
    @GET("/api/v1/test2")  ///api/v1/test2로 HTTP GET요청을 수행
    Call<List<Post>> getPosts(); //서버에서 받은 응답을 처리하기 위한 메서드
}
