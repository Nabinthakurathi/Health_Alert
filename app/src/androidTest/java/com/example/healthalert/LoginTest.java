package com.example.healthalert;

import com.example.healthalert.Bll.LoginBll;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LoginTest {

    @Test
    public void testLogin()
    {
        LoginBll loginBll = new LoginBll();
        boolean result = loginBll.checkUser("nabin99","9999");
        assertEquals(true, result);

    }
}
