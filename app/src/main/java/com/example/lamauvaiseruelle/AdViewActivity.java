package com.example.lamauvaiseruelle;

import android.os.Bundle;
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

        // Supposons que vous souhaitez afficher la première annonce de la liste
        if (!adModels.isEmpty()) {
            AdModel firstAd = adModels.get(0);

            // Références aux vues dans le layout
            TextView title_description = findViewById(R.id.title_description_page);
            ImageView image_description = findViewById(R.id.image_description_page);
            TextView description_page = findViewById(R.id.Description_page);
            Button button_description_page = findViewById(R.id.button_description_page);

            // Mettez à jour les vues avec les données de l'annonce
            title_description.setText(firstAd.getTitle());
            image_description.setImageResource(firstAd.getImage());
            description_page.setText(firstAd.getAddress());
        }
    }
}
