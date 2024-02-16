package com.example.lamauvaiseruelle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AdViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_view);

        TextView title_decription = findViewById(R.id.title_description_page);
        ImageView image_description = findViewById(R.id.image_description_page);
        TextView description_page = findViewById(R.id.Description_page);
        Button button_description_page = findViewById(R.id.button_description_page);

        String titre_test = "Test_titre";
        String descr_test = "descr_titre";



    }
}