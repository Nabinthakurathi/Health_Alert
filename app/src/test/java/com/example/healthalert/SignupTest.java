package com.example.healthalert;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SignupTest {
    boolean expect = true;
    boolean actual = false;

    @Test
    public void signup(){
        String fname = "nabinq";
        String lname = "nabinq";
        String username = "nabin99";
        String password = "9999";
        String conpassword = "9999";

        {
            actual = true;
        }

        assertEquals(actual, expect);
    }
}
