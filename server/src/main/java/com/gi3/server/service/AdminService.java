package com.gi3.server.service;

import com.gi3.server.domain.Avis;
import com.gi3.server.domain.users.Utilisateur;
import com.gi3.server.dto.UtilisateurDTO;

import java.util.List;

public interface AdminService {

    UtilisateurDTO add(UtilisateurDTO utilisateurDTO);

    List<Utilisateur> listUsers();

    List<Avis> listAvix();

    void deleteUser(Long id, String role);

    void deleteAvix(Long id);

}
