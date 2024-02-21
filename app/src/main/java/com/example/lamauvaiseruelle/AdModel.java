package com.example.lamauvaiseruelle;

import android.content.Context;
import android.util.Log;

public class AdModel {
    Context context;
    private String title;
    private String address;
    private String marque;
    private int prix;
    private int id_obj;
    private String description;
    private String dimension;
    private String categorie;
    private String nom_image;
    private int image;
    private int id_vendeur;
    // Constructor
    public AdModel(String title, String address, String marque, int prix, int id_obj, String description, String dimension, String categorie, String nom_image, int image, int id_vendeur) {
        this.title = title;
        this.address = address;
        this.marque = marque;
        this.prix = prix;
        this.id_obj = id_obj;
        this.description = description;
        this.dimension = dimension;
        this.categorie = categorie;
        this.nom_image = nom_image;
        this.image = image;
        this.id_vendeur = id_vendeur;
    }

    // Getter and Setter
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMarque() {
        return this.marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getPrix() {
        return this.prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getIdObj() {
        return this.id_obj;
    }

    public void setIdObj(int id_obj) {
        this.id_obj = id_obj;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimension() {
        return this.dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getCategorie() {
        return this.categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getNom_image() {
        return this.nom_image;
    }

    public void setNom_image(String nom_image) {
        this.nom_image = nom_image;
    }

    public int getImage() {
        return this.image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getIdVendeur() {
        return this.id_vendeur;
    }

    public void setIdVendeur(int id_vendeur) {
        this.id_vendeur = id_vendeur;
    }
}
