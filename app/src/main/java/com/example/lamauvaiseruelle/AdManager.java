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
        Log.e("claclowm", "debut");


        // Ouvre le fichier JSON
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.data);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            Log.e("claclowm", "avant while");
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            inputStream.close();
            String json = stringBuilder.toString();
            Log.e("claclowm", "apreeswhile");

            Log.e("JORSE", "0000");

            Log.e("JORSE vistaprint", "JsonObject.class");
            Log.e("JORSE vistaprint", (JsonObject.class).toString());
            Log.e("JORSE vistaprint", "jose");
            Log.e("JORSE vistaprint", (json).toString());

            JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);



            Log.e("JORSE", "1111");
            JsonArray jsonArray = jsonObject.getAsJsonArray("data");

            Log.e("claclowm", "avantfor");
            for (JsonElement element : jsonArray) {
                JsonObject adObject = element.getAsJsonObject();
                String title = adObject.get("titre").getAsString();
                String address = adObject.get("adresse").getAsString();
                String nom_image = adObject.get("image").getAsString();
                int image = context.getResources().getIdentifier(nom_image, "drawable", context.getPackageName());
                if (image == 0){ //trouve pas l'image associée -> image générique
                    image = context.getResources().getIdentifier("none", "drawable", context.getPackageName());
                    Log.w("AdManager", "Image pas trouvée");
                    if (image == 0){ //image none pas trouvée -> ya un gros pb
                        Log.e("AdManager", "Aucun lien avec les images");
                    }    
                }
                Log.e("claclowm", "la MAXXXX");
                adModels.add(new AdModel(title, address, image));
            }
            Log.e("claclowm", "apresfor");
        } catch (IOException e) {
            Log.e("AdManager", "Error reading JSON file", e);
        }
        Log.e("claclowm", "fin");
        return adModels;
    }
}