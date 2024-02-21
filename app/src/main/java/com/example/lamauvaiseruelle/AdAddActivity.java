package com.example.lamauvaiseruelle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Random;

public class AdAddActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_add);
        //problème avec le contexte
        Context context = this;

        TextInputEditText titre = findViewById(R.id.title_input);
        TextInputEditText adresse = findViewById(R.id.adresse_input);
        TextInputEditText marque = findViewById(R.id.marque_input);
        TextInputEditText prix = findViewById(R.id.prix_input);
        TextInputEditText description = findViewById(R.id.desc_input);
        TextInputEditText dimensions = findViewById(R.id.dim_input);
        TextInputEditText categorie = findViewById(R.id.cate_input);
        Button button_save = findViewById(R.id.button_add_page);

        AdManager adManager = new AdManager();
        ArrayList<AdModel> adModels = adManager.loadAdsFromJson(context);
        AdModel admodel = adModels.get(adModels.size()-1);
        int id = admodel.getIdObj() +1;

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idVendeur = new Random().nextInt(4);
                AdModel nouvelObjet = new AdModel(titre.getHint().toString(), adresse.getHint().toString(), marque.getHint().toString(), Integer.parseInt(prix.getHint().toString()), id, description.getHint().toString(), dimensions.getHint().toString(), categorie.getHint().toString(), "none", idVendeur);
                adModels.add(nouvelObjet);
                adManager.saveAdsToJson(adModels, context);
            }
        });
    }

}