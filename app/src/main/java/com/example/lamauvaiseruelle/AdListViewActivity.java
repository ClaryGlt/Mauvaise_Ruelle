package com.example.lamauvaiseruelle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //récupérer la liste d'Admodels
        //construise menu déroulant
        Log.e("feur","uwu");
        AdAdapter adAdapter = new AdAdapter(this);
        Log.e("feur","lesgo");
        setContentView(adAdapter.getView(0, findViewById(R.id.testtest), null));

        Button button_description_page = findViewById(R.id.button_description);

        button_description_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lancementAdViewActivity = new Intent(AdListViewActivity.this, AdViewActivity.class);
                startActivity(lancementAdViewActivity);
            }
        });




    }
}

