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

// List<AdModel> adModels = new AdManager().loadAdsFromJson(getContext());

public class AdManager {

    public List<AdModel> loadAdsFromJson(Context context) {
        List<AdModel> adModels = new ArrayList<>();

        // Ouvre le fichier JSON
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

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            JsonArray jsonArray = jsonObject.getAsJsonArray("data");

            for (JsonElement element : jsonArray) {
                JsonObject adObject = element.getAsJsonObject();
                String title = adObject.get("titre").getAsString();
                String address = adObject.get("adresse").getAsString();
                int image = adObject.get("image").getAsInt();

                adModels.add(new AdModel(title, address, image));
            }

        } catch (IOException e) {
            Log.e("AdManager", "Error reading JSON file", e);
        }

        return adModels;
    }
}