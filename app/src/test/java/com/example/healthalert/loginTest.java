package com.example.healthalert;

import com.example.healthalert.Bll.LoginBll;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class loginTest {
    boolean expect = true;
    boolean actual = false;

    @Test
    public void login() {
        String username = "nabin99";
        String password = "9999";

        LoginBll loginBLL = new LoginBll();

        if (loginBLL.checkUser(username, password)) {

            actual = true;
        }

        assertEquals(actual, expect);
    }

}
