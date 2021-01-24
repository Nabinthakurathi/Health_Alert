package com.example.healthalert.Bll;

import com.example.healthalert.Api.Userapi;
import com.example.healthalert.ServerResponse.SignUpResponse;
import com.example.healthalert.Url.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBll {
     Boolean isSuccess = false;


    public boolean checkUser(String username, String password){

        Userapi usersApi = Url.getInstance().create(Userapi.class);
        Call<SignUpResponse> usersCall = usersApi.CheckUser(username, password);

        try{
            Response<SignUpResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() &&
                    loginResponse.body().getStatus().equals("Login success!")) {

                Url.token += loginResponse.body().getToken();

                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
 }
}
