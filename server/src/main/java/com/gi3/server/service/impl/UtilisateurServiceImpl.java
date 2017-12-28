package com.gi3.server.service.impl;

import com.gi3.server.domain.users.Utilisateur;
import com.gi3.server.repo.users.AdminRepo;
import com.gi3.server.repo.users.EnseignantRepo;
import com.gi3.server.repo.users.EtudiantRepo;
import com.gi3.server.service.UtilisateurService;

/**
 * @author kadarH
 */

public class UtilisateurServiceImpl implements UtilisateurService {

    private EnseignantRepo enseignantRepo;
    private EtudiantRepo etudiantRepo;
    private AdminRepo adminRepo;

    public UtilisateurServiceImpl(EnseignantRepo enseignantRepo, EtudiantRepo etudiantRepo, AdminRepo adminRepo) {
        this.enseignantRepo = enseignantRepo;
        this.etudiantRepo = etudiantRepo;
        this.adminRepo = adminRepo;
    }

    @Override
    public Utilisateur updateProfile(Utilisateur utilisateur) {
        return null;
    }
}
