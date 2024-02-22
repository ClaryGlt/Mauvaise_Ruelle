package com.example.lamauvaiseruelle;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Random;

public class AdAddActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_add);
        //problème avec le contexte
        Context context = getApplicationContext();

        TextInputEditText titre = findViewById(R.id.title_input);
        TextInputEditText adresse = findViewById(R.id.adresse_input);
        TextInputEditText marque = findViewById(R.id.marque_input);
        TextInputEditText prix = findViewById(R.id.prix_input);
        TextInputEditText description = findViewById(R.id.desc_input);
        TextInputEditText dimensions = findViewById(R.id.dim_input);
        TextInputEditText categorie = findViewById(R.id.cate_input);
        Button button_save = findViewById(R.id.button_add_page);
        ImageView imageView = findViewById(R.id.image_add_page);
        Button button_foto = findViewById(R.id.button_foto);

        button_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lancementCameraAdAddActivity = new Intent(AdAddActivity.this, CameraAdAddActivity.class);
                startActivity(lancementCameraAdAddActivity);
            }
        });

        int image = context.getResources().getIdentifier("none", "drawable", context.getPackageName());
        if (image == -1) {
            // Si l'image n'est pas trouvée, utiliser une image générique
            image = context.getResources().getIdentifier("none", "drawable", context.getPackageName());
            Log.w("AdManager", "Image pas trouvée");
            Log.w("AdManager", "none");
            if (image == 0) {
                // Si l'image générique n'est pas trouvée, il y a un problème grave
                Log.e("AdManager", "Aucun lien avec les images");
            }
        }

        imageView.setImageResource(image);
        final int temp = image;

        AdManager adManager = new AdManager();
        ArrayList<AdModel> adModels = adManager.loadAdsFromJson(context);
        AdModel admodel = adModels.get(adModels.size()-1);
        int id = admodel.getIdObj() +1;

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int idVendeur = new Random().nextInt(4);
                AdModel nouvelObjet = new AdModel(titre.getHint().toString(), adresse.getHint().toString(), marque.getHint().toString(), Integer.parseInt(prix.getHint().toString()), id, description.getHint().toString(), dimensions.getHint().toString(), categorie.getHint().toString(), "none", temp, idVendeur);
                adModels.add(nouvelObjet);
                adManager.saveAdsToJson(adModels, context);
            }
        });
    }

}