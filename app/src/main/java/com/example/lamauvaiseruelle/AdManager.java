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
                String marque = adObject.get("marque").getAsString();
                int prix = adObject.get("prix");
                int id_obj = adObject.get("id_obj");
                String description = adObject.get("description").getAsString();
                String dimension = adObject.get("dimension").getAsString();
                String categorie = adObject.get("categorie").getAsString();
                String nom_image = adObject.get("image").getAsString();
                int id_vendeur = adObject.get("id_vendeur");

                int image = context.getResources().getIdentifier(nom_image, "drawable", context.getPackageName());
                
                if (image == 0) { 
                    // Si l'image n'est pas trouvée, utiliser une image générique
                    image = context.getResources().getIdentifier("none", "drawable", context.getPackageName());
                    Log.w("AdManager", "Image pas trouvée");
                    if (image == 0) { 
                        // Si l'image générique n'est pas trouvée, il y a un problème grave
                        Log.e("AdManager", "Aucun lien avec les images");
                    }    
                }
                
                // Ajouter l'objet AdModel à la liste
                adModels.add(new AdModel(title, address, marque, prix, id_obj, description, dimension, categorie, image, id_vendeur));
            }
        } catch (IOException e) {
            Log.e("AdManager", "Error reading JSON file", e);
        }

        return adModels;
    }
}
