package com.example.lamauvaiseruelle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bList = findViewById(R.id.buttonList);
        Button bAdd = findViewById(R.id.buttonAdd);
        Button TESTER = findViewById(R.id.buttonMain);
        bList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lancementAdListViewActivity = new Intent(MainActivity.this, AdListViewActivity.class);
                startActivity(lancementAdListViewActivity);
            }
        });
        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lancementAdAddActivity = new Intent(MainActivity.this, AdAddActivity.class);
                startActivity(lancementAdAddActivity);
            }
        });

        TESTER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdManager adManager = new AdManager();
                adManager.test(getApplicationContext());
            }
        });
    }
}