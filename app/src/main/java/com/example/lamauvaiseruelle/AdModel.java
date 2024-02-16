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

public class AdManager {

    public List<AdModel> loadAdsFromJson(Context context) {
        List<AdModel> adModels = new ArrayList<>();

        try {
            InputStream inputStream = context.getResources().openRawResource(R.list_data.data);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            inputStream.close();

            Gson gson = new Gson();
            AdModel[] adArray = gson.fromJson(stringBuilder.toString(), AdModel[].class);

            for (AdModel ad : adArray) {
                adModels.add(ad);
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
