package com.example.recyclerviewclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Person> peopleArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        //layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        //layoutManager = new GridLayoutManager(this, 6, GridLayoutManager.HORIZONTAL, false);


        recyclerView.setLayoutManager(layoutManager);

        peopleArray = new ArrayList<Person>();
        peopleArray.add(new Person("Jean", "Chavarria", "bus"));
        peopleArray.add(new Person("John", "Henrich", "plane"));
        peopleArray.add(new Person("Tom", "Cruise", "bus"));
        peopleArray.add(new Person("Jennifer", "Lopez", "plane"));
        peopleArray.add(new Person("Jean", "Chavarria", "bus"));
        peopleArray.add(new Person("John", "Henrich", "plane"));
        peopleArray.add(new Person("Tom", "Cruise", "bus"));
        peopleArray.add(new Person("Jennifer", "Lopez", "plane"));
        peopleArray.add(new Person("Jean", "Chavarria", "bus"));
        peopleArray.add(new Person("John", "Henrich", "plane"));
        peopleArray.add(new Person("Tom", "Cruise", "bus"));
        peopleArray.add(new Person("Jennifer", "Lopez", "plane"));
        peopleArray.add(new Person("Jean", "Chavarria", "bus"));
        peopleArray.add(new Person("John", "Henrich", "plane"));
        peopleArray.add(new Person("Tom", "Cruise", "bus"));
        peopleArray.add(new Person("Jennifer", "Lopez", "plane"));
        peopleArray.add(new Person("Jean", "Chavarria", "bus"));
        peopleArray.add(new Person("John", "Henrich", "plane"));
        peopleArray.add(new Person("Tom", "Cruise", "bus"));
        peopleArray.add(new Person("Jennifer", "Lopez", "plane"));
        peopleArray.add(new Person("Jean", "Chavarria", "bus"));
        peopleArray.add(new Person("John", "Henrich", "plane"));
        peopleArray.add(new Person("Tom", "Cruise", "bus"));
        peopleArray.add(new Person("Jennifer", "Lopez", "plane"));

        myAdapter = new PersonAdapter(this, peopleArray);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this, "Surname: " + peopleArray.get(index), Toast.LENGTH_SHORT).show();
    }
}