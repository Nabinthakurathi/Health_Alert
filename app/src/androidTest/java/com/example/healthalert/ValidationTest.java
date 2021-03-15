package com.example.healthalert;

import androidx.test.rule.ActivityTestRule;

import com.example.healthalert.DashBoardActivity.DashBoardActivity;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class ValidationTest {
    //test for wrong login
    @Rule
    public ActivityTestRule<Login_Activity> testRule = new ActivityTestRule(Login_Activity.class);
    private String username = "nabin99";
    private String password = "9999";

    @Test
    public void TestUI() throws Exception {
        onView(withId(R.id.etUsername)).perform(typeText(username));
        closeSoftKeyboard();
        onView(withId(R.id.etPassword)).perform(typeText(password));
        closeSoftKeyboard();

        onView(withId(R.id.btnLogin)).perform(click());
    }
}
