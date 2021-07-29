package com.example.fragments1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected {

    TextView tvDescriptions;
    ArrayList<String> descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescriptions = findViewById(R.id.textView1);

        descriptions = new ArrayList<String >();
        descriptions.add("Description for item 1");
        descriptions.add("Description for item 2");
        descriptions.add("Description for item 3");


    }

    @Override
    public void onItemSelected(int index) {
        tvDescriptions.setText(descriptions.get(index));
    }
}