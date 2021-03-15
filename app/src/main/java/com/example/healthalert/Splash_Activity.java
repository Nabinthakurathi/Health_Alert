package com.example.healthalert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class Splash_Activity extends AppCompatActivity {
    ImageView imglogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_);

        imglogo = findViewById(R.id.imglogo);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Activity.this, Login_Activity.class);
                startActivity(intent);
                finish();
            }
        },2000);

        RotateAnimation rotate = new RotateAnimation(30, 360, Animation.RELATIVE_TO_SELF, 0.5f,  Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(2000);
        imglogo.startAnimation(rotate);

    }
}