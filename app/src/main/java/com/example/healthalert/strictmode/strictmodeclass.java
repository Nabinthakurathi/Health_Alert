package com.example.healthalert.strictmode;

public class strictmodeclass {

    public static void StrictMode() {
        android.os.StrictMode.ThreadPolicy policy =
                new android.os.StrictMode.ThreadPolicy.Builder()
                        .permitAll().build();

        android.os.StrictMode.setThreadPolicy(policy);
    }
}
