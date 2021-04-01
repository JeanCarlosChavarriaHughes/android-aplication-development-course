package com.example.magicidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // Declare visual components
    EditText etID;
    Button btnSubmit;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect Java attributes to layout elements
        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);
        // Set Visibility as GONE
        tvResults.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When the button is pressed, when we need to retrieve the entered text.
                String idNumber = etID.getText().toString().trim();
                String dayBirth;

                // Extract day of birth from South African structure (first 6 characters)
                // https://www.westerncape.gov.za/sites/www.westerncape.gov.za/files/sa-id-number-new.png
                if (idNumber != null ){
                    dayBirth = idNumber.substring(0, 6);
                } else {
                    dayBirth = "";
                }

                // Extract the gender which are the next 4 digits.
                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));
                String sGender;
                // If value is 0-4 female. Else if 5-9 Male.
                if (gender < 5 && gender >= 0) {
                    sGender = "Female";
                } else if (gender >= 5 && gender <= 9){
                    sGender = "Male";
                } else {
                    sGender = "Unknown";
                }

                // Extract the citizenship which is the 10th character
                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));
                String sNationality;
                // If value is equal to 0: SA Citizen
                // If value is not equal to 0: Permanent Resident
                if (nationality == 0){
                    sNationality = "SA Citizen";
                } else {
                    sNationality = "Permanent Resident";
                }

                // Show the information to the user in tvResults
                String finalResult = "Date of Birth: " + dayBirth + "\n" +
                        "Gender: " + sGender + "\n" +
                        "Nationality: " + sNationality;
                tvResults.setText(finalResult);
                tvResults.setVisibility(View.VISIBLE);

            }
        });

    }
}
