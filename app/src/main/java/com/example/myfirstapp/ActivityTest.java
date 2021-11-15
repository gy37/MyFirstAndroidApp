package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_layout);
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(v -> Toast.makeText(ActivityTest.this, "You clicked Button 2", Toast.LENGTH_SHORT).show());
    }
}