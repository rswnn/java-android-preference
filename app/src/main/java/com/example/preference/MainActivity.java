package com.example.preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(Preferences.getLoggedInStatus(getBaseContext())) {
            TextView nama = findViewById(R.id.tv_namaMain);

            nama.setText(Preferences.getLoggedInUser(getBaseContext()));
            System.out.println("--------- is login");
            System.out.println(Preferences.getLoggedInStatus(getBaseContext()));

            findViewById(R.id.button_logoutMain).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Preferences.clearLoggedInUser(getBaseContext());
                    startActivity(new Intent(getBaseContext(),LoginActivty.class));
                    finish();
                }
            });
        } else {
            startActivity(new Intent(getBaseContext(), LoginActivty.class));
            System.out.println("cannot login");
        }

    }
}
