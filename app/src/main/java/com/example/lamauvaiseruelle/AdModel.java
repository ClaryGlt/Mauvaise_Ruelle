package com.example.lamauvaiseruelle;

public class AdModel {
    private String title;
    private String address;
    private String marque;
    private int prix;
    private int id_obj;
    private String description;
    private String dimension;
    private String categorie;
    private int image;
    private int id_vendeur;
    // Constructor
    public AdModel(String title, String address, String marque, int prix, int id_obj, String description, String dimension, String categorie, int image, int id_vendeur) {
        this.title = title;
        this.address = address;
        this.marque = marque;
        this.prix = prix;
        this.id_obj = id_obj;
        this.description = description;
        this.dimension = dimension;
        this.categorie = categorie;
        this.image = image;
        this.id_vendeur = id_vendeur;
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

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getIdObj() {
        return id_obj;
    }

    public void setIdObj(int id_obj) {
        this.id_obj = id_obj;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getIdVendeur() {
        return id_vendeur;
    }

    public void setIdVendeur(int id_vendeur) {
        this.id_vendeur = id_vendeur;
    }
}
