package com.example.implicitintentsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Declare attributes
    Button btnCall;
    Button btnCallFriend;
    Button btnWeb;
    Button btnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Define Attributes
        btnCall = findViewById(R.id.btnCall);
        btnCallFriend = findViewById(R.id.btnCallFriend);
        btnWeb = findViewById(R.id.btnWeb);
        btnMap = findViewById(R.id.btnMap);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create implicit intent for opening Dial Phone Application
                Intent intent = new Intent((Intent.ACTION_DIAL));
                startActivity(intent);
            }
        });

        btnCallFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create implicit intent with specific number
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:89888447"));
                startActivity(intent);
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // A Web is viewed
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.locationLeesville)));
                startActivity(intent);

            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Map View
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Cementerio Leesville, Leesville, Roxana, Limón, Roxana"));
                startActivity(intent);
            }
        });
    }
}
