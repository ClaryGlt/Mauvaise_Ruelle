package com.example.lamauvaiseruelle;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// List<AdModel> adModels = new AdManager().loadAdsFromJson(getContext());

public class AdManager {

    public List<AdModel> loadAdsFromJson(Context context) {
        List<AdModel> adModels = new ArrayList<>();

        // Ouvre le fichier JSON
        try {
            InputStream inputStream = context.getResources().openRawResource(R.list_data.data);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            inputStream.close();
            String json = stringBuilder.toString();

            // Convertit le JSON en tableau d'AdModel
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            JsonArray jsonArray = jsonObject.getAsJsonArray("data");

            // Parcourt chaque élément du tableau JSON
            for (JsonElement element : jsonArray) {
                JsonObject adObject = element.getAsJsonObject();
                String title = adObject.get("titre").getAsString();
                String address = adObject.get("adresse").getAsString();
                int image = adObject.get("image").getAsInt();
                
                // Ajout de l'AdModel à la liste
                adModels.add(new AdModel(title, address, image));
            }

        } catch (IOException e) {
            Log.e("AdManager", "Error reading JSON file", e);
        }

        return adModels;
    }
}



public class AdModel {
    private String title;
    private String address;
    private int image;
    // Constructor
    public AdModel(String title, String address, int image) {
        this.title = title;
        this.address = address;
        this.image = image;
    }

    // Getter and Setter
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
