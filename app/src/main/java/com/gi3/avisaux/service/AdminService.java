package com.gi3.avisaux.service;

import com.gi3.avisaux.domain.Avis;
import com.gi3.avisaux.domain.Utilisateur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Med on 24/12/17.
 */

public class AdminService {

    public List<Utilisateur> getUsers(){
        List<Utilisateur> users = new ArrayList<>();
        Utilisateur user1 = new Utilisateur(1,"Salah","Loukili","userSalah","pass","user");
        users.add(user1);
        Utilisateur user2 = new Utilisateur(1,"Hamza","Kadar","userH","pass","user");
        users.add(user2);
        return users;
    }

    public List<Avis> getAllAvis(){
        List<Avis> avis = new ArrayList<>();
        Avis avis1 = new Avis(1,"Lorem ipsum dolor , consectetur adipiscing elit. Nunc purus ligula, ullamcorper id velit id, vestibulum auc sapien. Sed quis mauris eget sem imperdiet rhoncus.","Professeur X","Groupe Y","Niveau Z","Filiere K","25/12/2017 23:20");
        Avis avis2 = new Avis(1,"Lorem ipsum dolor ","Professeur X","Groupe T","Niveau A","Filiere K","28/12/2017 14:20");
        avis.add(avis1);
        avis.add(avis2);
        return avis;
    }

}
