package com.example.intentschallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateContactActivity extends AppCompatActivity {

    // Declare Activity Attributes
    EditText etName;
    EditText etNumber;
    EditText etWebPage;
    EditText etLocation;
    ImageView imgSaveHappy;
    ImageView imgSaveNeutral;
    ImageView imgSaveSad;

    // private variables
    private boolean allDataReady = false;
    private String contactName;
    private String contactNumber;
    private String contactWebPage;
    private String contactLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        // Define Activity Attributes
        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        etWebPage = findViewById(R.id.etWebPage);
        etLocation = findViewById(R.id.etLocation);
        imgSaveHappy = findViewById(R.id.imgSaveHappy);
        imgSaveNeutral = findViewById(R.id.imgSaveNeutral);
        imgSaveSad = findViewById(R.id.imgSaveSad);

        Toast missingInfo = Toast.makeText(CreateContactActivity.this,
                "All fields are required!",
                Toast.LENGTH_SHORT);

        // Verify all data was entered
        if(etName == null ||
           etNumber == null ||
           etWebPage == null ||
           etLocation == null
        ) {
            missingInfo.show();
            allDataReady = false;
        } else {
            allDataReady = true;
        }

        // Possible options to save happy, neutral or sad
        imgSaveHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allDataReady){
                    readData();
                    Intent intent = new Intent();
                    setExtraData(intent);
                    intent.putExtra("feeling", String.valueOf(R.string.feelingHappy));
                    setResult(RESULT_OK, intent);
                    CreateContactActivity.this.finish();
                }
            }
        });

        imgSaveNeutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allDataReady){
                    readData();
                    Intent intent = new Intent();
                    setExtraData(intent);
                    intent.putExtra("feeling", String.valueOf(R.string.feelingNeutral));
                    setResult(RESULT_OK, intent);
                    CreateContactActivity.this.finish();
                }
            }
        });

        imgSaveSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (allDataReady){
                    readData();
                    Intent intent = new Intent();
                    setExtraData(intent);
                    intent.putExtra("feeling", String.valueOf(R.string.feelingSad));
                    setResult(RESULT_OK, intent);
                    CreateContactActivity.this.finish();
                }
            }
        });
    }

    private void readData(){
        contactName = etName.getText().toString().trim();
        contactNumber = etNumber.getText().toString().trim();
        contactWebPage = etWebPage.getText().toString().trim();
        contactLocation = etLocation.getText().toString().trim();
    }

    private void setExtraData(Intent finalIntent){
        finalIntent.putExtra("contactName", contactName);
        finalIntent.putExtra("contactNumber", contactNumber);
        finalIntent.putExtra("contactWebPage", contactWebPage);
        finalIntent.putExtra("contactLocation", contactLocation);
    }


}
