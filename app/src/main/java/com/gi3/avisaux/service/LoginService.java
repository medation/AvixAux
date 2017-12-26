package com.gi3.avisaux.service;

import com.gi3.avisaux.domain.Utilisateur;

/**
 * Created by Med on 24/12/17.
 */

public class LoginService {

    public Utilisateur login(String username, String password){
        Utilisateur utilisateur = new Utilisateur(1,"med","Elhachimi","imadmin","monpass","admin");
        return utilisateur;
    }

}
