package com.example.temperaturecricket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declare Attributes
    EditText inputCount;
    Button submitButton;
    TextView textView2;

    int tempValue = 0;
    int tempCelsius;

    String TAG = "tempSample";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect to java atributes
        inputCount = findViewById(R.id.editText2);
        submitButton = findViewById(R.id.button);
        textView2 = findViewById(R.id.textView2);

        // Hide textView2
        textView2.setVisibility(View.GONE);

        // Create algorithm for temperature calculation
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Validate the input
                String inputStr = inputCount.getText().toString().trim();
                Log.d(TAG, "inputStr " + inputStr);

                if (inputStr != null){
                    tempValue = Integer.parseInt(inputStr);
                } else {
                    // Input is not valid
                    tempValue = 0;
                }

                // Perform calculation
                // tempCelsius = ( count / 3 ) + 4
                tempCelsius = (tempValue / 3) + 4;
                Log.d(TAG, "tempCelsius: " + tempCelsius);

                // Show result
                String finalResult = "Temp is " + String.valueOf(tempCelsius) + " Celsius";
                Log.d(TAG, "finalResult " + finalResult);
                textView2.setText(finalResult);
                textView2.setVisibility(View.VISIBLE);
            }
        });
    }
}
