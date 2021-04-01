package com.example.explicitintentsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.Inet4Address;

public class Activity3 extends AppCompatActivity {

    // Declare attributes
    EditText editText3;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        // Declare attributes
        editText3 = findViewById(R.id.editText3);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String surnameEntered;
                if (editText3.getText().toString().isEmpty()){
                    Toast.makeText(Activity3.this, "Please enter all fields!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    surnameEntered = editText3.getText().toString().trim();

                    // Send the surnameEntered back to Main Activity

                    Intent intent = new Intent();

                    // We dont need to start any activity.
                    // Only send the collected data
                    intent.putExtra("surnameData", surnameEntered);

                    // We need to explicitly set result
                    setResult(RESULT_OK, intent);

                    // Finish the Activity
                    Activity3.this.finish();

                }
            }
        });
    }
}
