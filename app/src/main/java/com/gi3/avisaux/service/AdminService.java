package com.gi3.avisaux.service;

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
}
