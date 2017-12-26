package com.gi3.avisaux.service;

import com.gi3.avisaux.domain.Utilisateur;

import java.util.ArrayList;
import java.util.List;


public class LoginService {

    public Utilisateur login(String username, String password){

        Utilisateur ens = new Utilisateur(1, "med", "Elhachimi", "a", "z", "enseignant");
        Utilisateur admin = new Utilisateur(2, "mid", "Elhachimi", "q", "s", "admin");
        Utilisateur etudiant = new Utilisateur(3, "ez", "azaza", "w", "x", "etudiant");
        List<Utilisateur> users = new ArrayList<>();
        users.add(ens);
        users.add(admin);
        users.add(etudiant);


        for (Utilisateur user : users) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password))
                return user;
        }

        return null;
    }

}
