package com.gi3.avisaux.domain;

import java.io.Serializable;

/**
 * Created by Med on 24/12/17.
 */

public class Utilisateur implements Serializable{

    private int id;
    private String prenom;
    private String nom;
    private String userName;
    private String password;
    private String role;
    private String groupe;

    public Utilisateur() {
    }

    public Utilisateur(int id, String prenom, String nom, String userName, String password, String role, String groupe) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.groupe = groupe;
    }

    public Utilisateur(String prenom, String nom, String userName, String password, String role, String groupe) {

        this.prenom = prenom;
        this.nom = nom;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.groupe = groupe;
    }

    public Utilisateur(int id, String prenom, String nom, String userName, String password, String role) {

        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }
}
