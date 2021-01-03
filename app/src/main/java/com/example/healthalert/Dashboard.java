package com.example.healthalert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity {
    private DrawerLayout DL;
    private ActionBarDrawerToggle T;
    private NavigationView NV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        navigations();


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(T.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
    public void navigations(){
        DL = findViewById(R.id.activity_dashboard);
        T = new ActionBarDrawerToggle(this,DL,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        T.setDrawerIndicatorEnabled(true);
        DL.addDrawerListener(T);
        T.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NV = findViewById(R.id.NV);
        NV.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();
                DL.closeDrawer(GravityCompat.START);
                switch (id) {
                    case R.id.Home:
                        startActivity(new Intent(Dashboard.this, Dashboard.class));
                        return false;
                    case R.id.Logout:
                        final DialogInterface.OnClickListener dialog = new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                switch (which) {
                                    case DialogInterface.BUTTON_POSITIVE:

                                        Intent intent = new Intent(Dashboard.this, Login_Activity.class);
                                        startActivity(intent);
                                        finish();

                                        break;
                                    case DialogInterface.BUTTON_NEGATIVE:
                                        break;

                                }

                            }
                        };
                        AlertDialog.Builder builder = new AlertDialog.Builder(Dashboard.this);
                        builder.setMessage("Are You Sure You Want To Logout??")
                                .setTitle("Logout!!!!!")
                                .setPositiveButton("Yes", dialog)
                                .setNegativeButton("No", dialog);
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                        return false;

                    default:

                        return false;


                }
            }
        });
    }
}