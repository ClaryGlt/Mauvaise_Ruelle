package com.example.lamauvaiseruelle;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// ArrayList<AdModel> adModels = new AdManager().loadAdsFromJson(getContext());

public class AdManager {

    public ArrayList<AdModel> loadAdsFromJson(Context context) {
        ArrayList<AdModel> adModels = new ArrayList<>();

        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.data);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            inputStream.close();
            String json = stringBuilder.toString();

            // Convertir le JSON en un tableau d'objets JSON
            JsonArray jsonArray = new Gson().fromJson(json, JsonArray.class);

            // Parcourir chaque élément du tableau JSON
            for (JsonElement element : jsonArray) {
                JsonObject adObject = element.getAsJsonObject();

                String title = adObject.get("title").getAsString();
                String address = adObject.get("address").getAsString();
                String nom_image = adObject.get("image").getAsString();
                int image = context.getResources().getIdentifier(nom_image, "drawable", context.getPackageName());
                
                if (image == 0) { 
                    // Si l'image n'est pas trouvée, utiliser une image générique
                    image = context.getResources().getIdentifier("none", "drawable", context.getPackageName());
                    Log.w("AdManager", "Image pas trouvée");
                    Log.w("AdManager", nom_image);
                    if (image == 0) {
                        // Si l'image générique n'est pas trouvée, il y a un problème grave
                        Log.e("AdManager", "Aucun lien avec les images");
                    }    
                }
                
                // Ajouter l'objet AdModel à la liste
                adModels.add(new AdModel(title, address, image));
            }
        } catch (IOException e) {
            Log.e("AdManager", "Error reading JSON file", e);
        }

        return adModels;
    }
}
