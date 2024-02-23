package com.example.lamauvaiseruelle;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.FileSystem;
import java.util.ArrayList;
import java.util.List;

// ArrayList<AdModel> adModels = new AdManager().loadAdsFromJson(getContext());

public class AdManager {
    String areyouwinning;
    public ArrayList<AdModel> loadAdsFromJson(Context context) {
        //lire du fichier sur l'ordi, si fichier sur ordi existe pas, le créer a partir du json
        ArrayList<AdModel> adModels = new ArrayList<>();

        try {
            areyouwinning = context.getFilesDir().getAbsolutePath() + "database.json";
            Log.w("areyouwinning",context.getFilesDir().getAbsolutePath());
            File myFile = new File(areyouwinning);
            Log.d("pathPourLesBeaux", myFile.getAbsolutePath());

            if (myFile.createNewFile()) {
                Log.e("FEUR","File created: " + myFile.getName());
                try {
                    InputStream inputStream = context.getResources().openRawResource(R.raw.data);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder stringBuilder = new StringBuilder();

                    FileOutputStream fos = new FileOutputStream(myFile);
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

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
                        int prix = adObject.get("prix").getAsInt();
                        int id_obj = adObject.get("id_obj").getAsInt();
                        String description = adObject.get("description").getAsString();
                        String dimension = adObject.get("dimension").getAsString();
                        String categorie = adObject.get("categorie").getAsString();
                        String nom_image = adObject.get("image").getAsString();
                        int id_vendeur = adObject.get("id_vendeur").getAsInt();

                        // Ajouter l'objet AdModel à la liste
                        adModels.add(new AdModel(title, address, marque, prix, id_obj, description, dimension, categorie, nom_image, GetImageIdByName(context, nom_image), id_vendeur));
                    }

                    //AJOUTER DANS LE NOUVEAU FICHIER
                    writer.write("[\n");

                    for (AdModel adModel : adModels) {
                        writer.write("\t{\n");
                        writer.write("\t\t\"title\": \"" + adModel.getTitle() + "\",\n");
                        writer.write("\t\t\"address\": \"" + adModel.getAddress() + "\",\n");
                        writer.write("\t\t\"marque\": \"" + adModel.getMarque() + "\",\n");
                        writer.write("\t\t\"prix\": " + adModel.getPrix() + ",\n");
                        writer.write("\t\t\"id_obj\": " + adModel.getIdObj() + ",\n");
                        writer.write("\t\t\"description\": \"" + adModel.getDescription() + "\",\n");
                        writer.write("\t\t\"dimension\": \"" + adModel.getDimension() + "\",\n");
                        writer.write("\t\t\"categorie\": \"" + adModel.getCategorie() + "\",\n");
                        writer.write("\t\t\"nom_image\": \"" + adModel.getNom_image() + "\",\n");
                        writer.write("\t\t\"id_vendeur\": " + adModel.getIdVendeur() + "\n");
                        writer.write("\t},\n");
                    }

                    writer.write("]");
                    writer.close();
                    Log.e("AdManager", "fini : post creation -----------------------------------------");
                } catch (IOException e) {
                    Log.e("AdManager", "Error reading JSON file", e);
                }
            } else {
                Log.e("FEUR","File deja existe, still created: " + myFile.getName());
                String filePath = myFile.getAbsolutePath();
                String bigString="";
                try {
                    BufferedReader br = new BufferedReader(new FileReader(filePath));
                    String line;
                    while ((line = br.readLine()) != null) {
                        bigString += line;
                        bigString += "\n";
                    }
                    br.close();

                    Log.d("loaderbigstring", bigString);

                    // Convertir le JSON en un tableau d'objets JSON
                    JsonArray jsonArray = new Gson().fromJson(bigString, JsonArray.class);


                    // Parcourir chaque élément du tableau JSON
                    for (JsonElement element : jsonArray) {
                        JsonObject adObject = element.getAsJsonObject();

                        String title = adObject.get("title").getAsString();
                        String address = adObject.get("address").getAsString();
                        String marque = adObject.get("marque").getAsString();
                        int prix = adObject.get("prix").getAsInt();
                        int id_obj = adObject.get("id_obj").getAsInt();
                        String description = adObject.get("description").getAsString();
                        String dimension = adObject.get("dimension").getAsString();
                        String categorie = adObject.get("categorie").getAsString();
                        Log.d("qqqzq", "imcass");
                        String nom_image = adObject.get("image").getAsString(); ///////GROS PB AVEC L'IMAGE TODO: REPARER !!!!!
                        //                                                                                                    java.lang.RuntimeException: Unable to start activity ComponentInfo{com.example.lamauvaiseruelle/com.example.lamauvaiseruelle.AdAddActivity}: java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String com.google.gson.JsonElement.getAsString()' on a null object reference
                        int id_vendeur = adObject.get("id_vendeur").getAsInt();

                        // Ajouter l'objet AdModel à la liste
                        adModels.add(new AdModel(title, address, marque, prix, id_obj, description, dimension, categorie, nom_image, GetImageIdByName(context, nom_image), id_vendeur));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.e("AdManagerModelavantelse", "adModels.size():"+adModels.size());
            }
        } catch (IOException e) {
            Log.e("FEUR", "An error occurred." + e);
            e.printStackTrace();
        }
        Log.e("AdManagerModel", "adModels.size():"+adModels.size());

        return adModels;
    }

    public void saveAdsToJson(ArrayList<AdModel> adModels, Context context) {
        Log.e("AdManager", "Entre dans Save-----------------------------------------");

        Log.e("AdManagerModel", "adModels.size()"+adModels.size());

        try {
            areyouwinning = context.getFilesDir().getAbsolutePath() + "database.json";
            File myFile = new File(areyouwinning);

            Log.d("pathPourLesBeaux", myFile.getAbsolutePath());
            // FileOutputStream fos = context.openFileOutput("database.json", Context.MODE_PRIVATE);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(myFile)));

            Log.d("bufferwriterTests", writer.toString());
            writer.flush();

            String jsonString = "[\n";

            for (AdModel adModel : adModels) {
                jsonString += "\t{\n";
                jsonString += "\t\t\"title\": \"" + adModel.getTitle() + "\",\n";
                jsonString += "\t\t\"address\": \"" + adModel.getAddress() + "\",\n";
                jsonString += "\t\t\"marque\": \"" + adModel.getMarque() + "\",\n";
                jsonString += "\t\t\"prix\": " + adModel.getPrix() + ",\n";
                jsonString += "\t\t\"id_obj\": " + adModel.getIdObj() + ",\n";
                jsonString += "\t\t\"description\": \"" + adModel.getDescription() + "\",\n";
                jsonString += "\t\t\"dimension\": \"" + adModel.getDimension() + "\",\n";
                jsonString += "\t\t\"categorie\": \"" + adModel.getCategorie() + "\",\n";
                jsonString += "\t\t\"nom_image\": \"" + adModel.getNom_image() + "\",\n";
                jsonString += "\t\t\"id_vendeur\": " + adModel.getIdVendeur() + "\n";
                jsonString += "\t},\n";
            }

            jsonString += "]";

            Log.d("jsonString :D", jsonString);

            writer.write(jsonString);
            writer.close();



            Log.e("AdManager", "fini-----------------------------------------");

            // Vérifier le contenu du fichier
            String filePath = myFile.getAbsolutePath();
            try {
                BufferedReader br = new BufferedReader(new FileReader(filePath));
                String line;
                while ((line = br.readLine()) != null) {
                    Log.d("FileContent checker", line);
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            Log.e("AdManager", "PROBLE%E dans Save-----------------------------------------");

            Log.e("AdManager", "Error writing JSON file", e);
        }
    }

    public void test(Context context){
        //Ouvrir le fichier sur le telephone si possible
        try {
            File myObj = new File(context.getFilesDir() + "/filename.txt");
            if (myObj.createNewFile()) {
                Log.e("FEUR","File created: " + myObj.getName());
            } else {
                Log.e("FEUR","File already exists.");
            }
        } catch (IOException e) {
            Log.e("FEUR","An error occurred." + e);
            e.printStackTrace();
        }
        //si pas possible, créer le fichier
        //écrire "test" dans un fichier sur le téléphone
    }

    public static int GetImageIdByName(Context context, String nom_image){
        int image = context.getResources().getIdentifier(nom_image, "drawable", context.getPackageName());
        if (image == -1) {
            // Si l'image n'est pas trouvée, utiliser une image générique
            image = context.getResources().getIdentifier("none", "drawable", context.getPackageName());
            Log.w("AdManager", "Image pas trouvée");
            Log.w("AdManager", nom_image);
            if (image == 0) {
                // Si l'image générique n'est pas trouvée, il y a un problème grave
                Log.e("AdManager", "Aucun lien avec les images");
            }
        }
        return image;
    }
}
