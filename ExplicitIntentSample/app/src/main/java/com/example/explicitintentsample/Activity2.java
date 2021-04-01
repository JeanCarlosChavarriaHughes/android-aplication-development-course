package com.example.explicitintentsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    // Declare attributes
    TextView tvAct2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // Define attributes
        tvAct2 = findViewById(R.id.tvAct2);

        // Get data from intent that was put as extraData
        String name = getIntent().getStringExtra("dataName");

        tvAct2.setText(name + ", welcome to Activity 2");

    }
}
