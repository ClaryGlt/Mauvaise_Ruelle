package com.example.lamauvaiseruelle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AdViewActivity extends AppCompatActivity {

    private List<AdModel> adModels;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_view);

        // Chargement des annonces à partir du gestionnaire d'annonces
        AdManager adManager = new AdManager();
        adModels = adManager.loadAdsFromJson(this);


        if (!adModels.isEmpty()) {
            FectchAd(getIntent().getIntExtra("numerotruc", 0)); //Pour l'instant 0. Sinon, on met l'endroit ou l'on se trouve dans l'arrayList lorsque que l'utilisateur clique dessus
        }
    }


    protected void FectchAd(int i){
        AdModel firstAd = adModels.get(i);

        // Références aux vues dans le layout
        TextView title_description = findViewById(R.id.title_description_page);
        ImageView image_description = findViewById(R.id.image_description_page);
        TextView description_page = findViewById(R.id.Description_page);
        Button button_description_page = findViewById(R.id.button_description_page);

        button_description_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lancementAdListViewActivity = new Intent(AdViewActivity.this, AdListViewActivity.class);
                startActivity(lancementAdListViewActivity);
            }
        });

        // Mettez à jour les vues avec les données de l'annonce
        title_description.setText(firstAd.getTitle());
        image_description.setImageResource(firstAd.getImage());
        description_page.setText(firstAd.getAddress());
    }
}
