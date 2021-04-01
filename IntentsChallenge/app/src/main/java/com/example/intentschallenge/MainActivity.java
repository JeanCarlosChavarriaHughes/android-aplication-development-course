package com.example.intentschallenge;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declare Activity Attributes
    ImageView imgFeeling;
    ImageView imgPhoneCall;
    ImageView imgWebPage;
    ImageView imgLocation;
    Button btnSubmit;
    TextView tvTitle;

    // Constants
    final int CREATECONTACTACTIVITY = 2;

    // private class variables
    private String contactName;
    private String contactNumber;
    private String contactWebPage;
    private String contactLocation;
    private String contactFeeling;

    // public strings
    public String feelingHappy = String.valueOf(R.string.feelingHappy);
    public String feelingNeutral = String.valueOf(R.string.feelingNeutral);
    public String feelingSad = String.valueOf(R.string.feelingSad);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Define Activity Attributes
        imgFeeling = findViewById(R.id.imgFeeling);
        imgPhoneCall = findViewById(R.id.imgPhoneCall);
        imgWebPage = findViewById(R.id.imgWebPage);
        imgLocation = findViewById(R.id.imgLocation);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvTitle = findViewById(R.id.tvTitle);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Open the Create Contact Activity with Intent to retrieve data
                Intent intent = new Intent(MainActivity.this,
                        com.example.intentschallenge.CreateContactActivity.class);
                startActivityForResult(intent, CREATECONTACTACTIVITY);

            }
        });

        imgPhoneCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create implicit intent with specific number
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contactNumber));
                startActivity(intent);
            }
        });

        imgWebPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // A Web is viewed
                Uri webpage = Uri.parse(contactWebPage);
                if (!contactWebPage.startsWith("http://") && !contactWebPage.startsWith("https://")) {
                    webpage = Uri.parse("http://" + contactWebPage);
                }

                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });

        imgLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Map View
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + contactLocation));
                startActivity(intent);
            }
        });


    }

    // Update MainActivity Images when Intent is finished from CREATECONTACTACTIVITY
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast missingInfo = Toast.makeText(MainActivity.this,
                "Contact was not created. Result Canceled!",
                Toast.LENGTH_SHORT);

        Toast unknownResultCode = Toast.makeText(MainActivity.this,
                "Unknown resultCode: " + String.valueOf(resultCode),
                Toast.LENGTH_SHORT);

        if (requestCode == CREATECONTACTACTIVITY){
            switch (resultCode){
                case RESULT_OK:
                    // Read data from intent
                    contactName = data.getStringExtra("contactName");
                    if (contactName != null){
                        tvTitle.setText("The contact: " + contactName + " was created!");
                    }

                    contactNumber = data.getStringExtra("contactNumber");
                    if (contactNumber != null){
                        imgPhoneCall.setVisibility(View.VISIBLE);
                    }

                    contactWebPage = data.getStringExtra("contactWebPage");
                    if (contactWebPage != null){
                        imgWebPage.setVisibility(View.VISIBLE);
                    }

                    contactLocation = data.getStringExtra("contactLocation");
                    if (contactLocation != null){
                        imgLocation.setVisibility(View.VISIBLE);
                    }
                    contactFeeling = data.getStringExtra("feeling");
                    setFeelingImg(imgFeeling, contactFeeling);

                    break
                    ;

                case RESULT_CANCELED:
                    missingInfo.show();
                    break
                    ;

                default:
                    unknownResultCode.show();
                    break
                    ;
            }
        }
    }

    void setFeelingImg(ImageView imageView, String feeling) {

        if (String.valueOf(feeling).equals(String.valueOf(R.string.feelingHappy))){
            imageView.setImageResource(R.drawable.ic_tag_faces_black_24dp);
            imageView.setVisibility(View.VISIBLE);
        } else if (String.valueOf(feeling).equals(String.valueOf(R.string.feelingNeutral))){
            imageView.setImageResource(R.drawable.ic_sentiment_neutral_black_24dp);
            imageView.setVisibility(View.VISIBLE);
        } else if (String.valueOf(feeling).equals(String.valueOf(R.string.feelingSad))){
            imageView.setImageResource(R.drawable.ic_sentiment_dissatisfied_black_24dp);
            imageView.setVisibility(View.VISIBLE);
        } else {
            Toast feelingNotRecognized = Toast.makeText(MainActivity.this,
                    "Unknown feeling: " + feeling,
                    Toast.LENGTH_SHORT);

            feelingNotRecognized.show();
        }
    }
}
