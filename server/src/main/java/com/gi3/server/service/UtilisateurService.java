package com.gi3.server.service;

import com.gi3.server.domain.users.Utilisateur;

public interface UtilisateurService {

    Utilisateur updateProfile(Utilisateur utilisateur, Long id);

}
