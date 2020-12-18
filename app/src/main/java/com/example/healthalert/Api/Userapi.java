package com.example.healthalert.Api;

import com.example.healthalert.Model.User;
import com.example.healthalert.ServerResponse.ImageResponse;
import com.example.healthalert.ServerResponse.SignUpResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;

public interface Userapi {
    @POST("/users/signup")
    Call<SignUpResponse> registerUser(@Body User user);

    @FormUrlEncoded
    @POST("users/login")
    Call<SignUpResponse> CheckUser(@Field("username") String username, @Field("password") String password);



    @Multipart
    @POST("upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

    @GET("users/me")
    Call<User> getUserDetails(@Header("Authorization") String token);

    @PUT("users/me")
    @FormUrlEncoded
    Call<User> updateUserDetails(
            @Header("Authorization") String token,
            @Field("firstName") String name,
            @Field("lastName") String lastnme,
            @Field("usernme") String username,
            @Field("image") String imageurl
    );
}
