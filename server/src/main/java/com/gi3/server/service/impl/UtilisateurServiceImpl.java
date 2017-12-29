package com.gi3.server.service.impl;

import com.gi3.server.domain.users.Admin;
import com.gi3.server.domain.users.Enseignant;
import com.gi3.server.domain.users.Etudiant;
import com.gi3.server.domain.users.Utilisateur;
import com.gi3.server.repo.users.AdminRepo;
import com.gi3.server.repo.users.EnseignantRepo;
import com.gi3.server.repo.users.EtudiantRepo;
import com.gi3.server.service.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kadarH
 */

@Service
@Transactional
@Slf4j
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
    public Utilisateur updateProfile(Utilisateur utilisateur, Long id) {
        Utilisateur utilisateur1 = new Utilisateur();
        try {
            if (utilisateur.getRole().equals("admin")) {
                Admin old = adminRepo.findOne(id);
                if (utilisateur.getNom() != null)
                    old.setNom(utilisateur.getNom());
                if (utilisateur.getPrenom() != null)
                    old.setPrenom(utilisateur.getPrenom());
                if (utilisateur.getPassword() != null)
                    old.setPassword(utilisateur.getPassword());

                utilisateur1 = adminRepo.save(old);
            }
            if (utilisateur.getRole().equals("etudiant")) {
                Etudiant old = etudiantRepo.findOne(id);
                if (utilisateur.getNom() != null)
                    old.setNom(utilisateur.getNom());
                if (utilisateur.getPrenom() != null)
                    old.setPrenom(utilisateur.getPrenom());
                if (utilisateur.getPassword() != null)
                    old.setPassword(utilisateur.getPassword());
                utilisateur1 = etudiantRepo.save(old);
            }
            if (utilisateur.getRole().equals("enseignant")) {
                Enseignant old = enseignantRepo.findOne(id);
                if (utilisateur.getNom() != null)
                    old.setNom(utilisateur.getNom());
                if (utilisateur.getPrenom() != null)
                    old.setPrenom(utilisateur.getPrenom());
                if (utilisateur.getPassword() != null)
                    old.setPassword(utilisateur.getPassword());
                utilisateur1 = enseignantRepo.save(old);
            }
            return utilisateur1;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Utilisateur login(String username, String password) {
        Utilisateur admin, enseignant, etudiant;
        admin = adminRepo.findByUserNameAndPassword(username, password);
        if (admin != null) {
            return admin;
        }

        enseignant = enseignantRepo.findByUserNameAndPassword(username, password);
        if (enseignant != null) {
            return enseignant;
        }
        etudiant = etudiantRepo.findByUserNameAndPassword(username, password);
        if (etudiant != null) {
            return etudiant;
        }
        return null;
    }
}
