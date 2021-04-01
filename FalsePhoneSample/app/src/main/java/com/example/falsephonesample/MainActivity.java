package com.example.falsephonesample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMessage = findViewById(R.id.tvMessage);

        if (getIntent().getDataString() != null){
            tvMessage.setText(getIntent().getData().toString());
        } else {
            tvMessage.setText("No tel received");
        }
    }
}
