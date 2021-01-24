package com.example.healthalert;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import com.example.healthalert.DashBoardActivity.DashBoardActivity;
import com.example.healthalert.DashBoardActivity.TaskFragment;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DashboardTest {
    @Rule
    public ActivityTestRule<DashBoardActivity> testRule = new ActivityTestRule(DashBoardActivity.class);
    private DashBoardActivity dashboardActivity=null;


    @Before
    public void setUp() throws Exception {
        dashboardActivity=testRule.getActivity();
    }
    @Test
    public void testLaunch(){
        View view=dashboardActivity.findViewById(R.id.task_list);
        assertNotNull(view);

    }

    @After
    public void tearDown() throws Exception {
        dashboardActivity=null;
    }
}
