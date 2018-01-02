package com.gi3.avisaux.domain;

/**
 * Created by Med on 24/12/17.
 */

public class Avis {

    private int id;
    private String message;
    private String enseignant;
    private String groupe;
    private String niveau;
    private String filiere;
    private String date;

    public Avis() {
    }

    public Avis(int id, String message, String enseignant, String groupe, String niveau, String filiere, String date) {
        this.id = id;
        this.message = message;
        this.enseignant = enseignant;
        this.groupe = groupe;
        this.niveau = niveau;
        this.filiere = filiere;
        this.date = date;
    }

    public Avis(String message, String enseignant, String groupe, String niveau, String filiere, String date) {
        this.message = message;
        this.enseignant = enseignant;
        this.groupe = groupe;
        this.niveau = niveau;
        this.filiere = filiere;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(String enseignant) {
        this.enseignant = enseignant;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
