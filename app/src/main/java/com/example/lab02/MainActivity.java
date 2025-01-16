package com.example.lab02;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView cityList;
    Button addCity;
    Button confirm;
    Button deleteCity;
    EditText input;
    ArrayAdapter<String> cityAdaptor;
    ArrayList<String> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        cityList = findViewById(R.id.city_list);
        addCity = findViewById(R.id.Addlist);
        confirm = findViewById(R.id.confirm);
        deleteCity = findViewById(R.id.DeleteList);
        input = findViewById(R.id.editTextText);

        String[] cities = {"Edmonton" , "Vancouver" , "Moscow" , "Sydney" , "Berlin" , "Vienna" , "Tokyo" , "Beijing" , "Osaka" , "New Delhi"};
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));
        cityAdaptor = new ArrayAdapter<>(this,R.layout.content,dataList);
        cityList.setAdapter(cityAdaptor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirm.setVisibility(View.VISIBLE);
                input.setVisibility(View.VISIBLE);
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newCity = input.getText().toString();
                dataList.add(newCity);
                cityList.setAdapter(cityAdaptor);
                input.setVisibility(View.GONE);
                confirm.setVisibility(View.GONE);
            }
        });
        deleteCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirm.setVisibility(View.VISIBLE);
                input.setVisibility(View.VISIBLE);
            }
        });


    }




}