package com.example.explicitintentsample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declare attributes
    EditText etName;
    Button btnAct2, btnAct3;
    TextView tvResults;

    final int ACTIVITY3 = 3;
    final String TAG_ResultCodes = "resultCodes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link visual Attributes
        etName = findViewById(R.id.etName);
        btnAct2 = findViewById(R.id.btnAct2);
        btnAct3 = findViewById(R.id.btnAct3);
        tvResults = findViewById(R.id.tvResults);

        // Set listener for btnAct2
        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameEntered;

                if (etName.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all fields!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    nameEntered = etName.getText().toString().trim();
                    // Open Activity 2 with Explicit Intent
                    // Because we know the exact class name to open
                    // Arguments (context, destination class)
                    Intent intent = new Intent(MainActivity.this, com.example.explicitintentsample.Activity2.class);

                    // Add required data to the intent
                    intent.putExtra("dataName", nameEntered);
                    startActivity(intent);

                }
            }
        });

        // Set listener for btnAct3
        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // We need to go to Act3, collect data and bring back to Main Act.

                Intent intent = new Intent(MainActivity.this,
                        com.example.explicitintentsample.Activity3.class);

                // No need to add extraData
                // Need to startActivity for return specific results.

                // Arguments (destinationActivity, and an unique Identifier of Activity
                startActivityForResult(intent, ACTIVITY3);

                // We need to override onActivityResult to read when activity 3 is finished
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACTIVITY3){
            switch (resultCode){
                case RESULT_OK:
                    //todo
                    Log.d(TAG_ResultCodes, "Result code is: " + String.valueOf(RESULT_OK));
                    String surnameText = data.getStringExtra("surnameData");
                    if (surnameText != null){
                        tvResults.setText(surnameText);
                    }
                    break
                    ;

                case RESULT_CANCELED:
                    //todo
                    Log.d(TAG_ResultCodes, "Result code is: " + String.valueOf(RESULT_CANCELED));
                    break
                    ;

                default:
                    //todo
                    Log.d(TAG_ResultCodes, "Result code is unknown: " + String.valueOf(requestCode));
                    break
                    ;
            }

        }
    }
}
