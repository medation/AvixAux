package com.gi3.server.repo.Datafaker;

import com.gi3.server.domain.Filiere;
import com.gi3.server.domain.Groupe;
import com.gi3.server.domain.Niveau;
import com.gi3.server.domain.users.Admin;
import com.gi3.server.domain.users.Enseignant;
import com.gi3.server.domain.users.Etudiant;
import com.gi3.server.repo.FiliereRepo;
import com.gi3.server.repo.GroupeRepo;
import com.gi3.server.repo.NiveauRepo;
import com.gi3.server.repo.users.AdminRepo;
import com.gi3.server.repo.users.EnseignantRepo;
import com.gi3.server.repo.users.EtudiantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author kadarH
 */

@Component
@Transactional
public class DataFaker implements CommandLineRunner {

    @Autowired
    private FiliereRepo filiereRepo;

    @Autowired
    private NiveauRepo niveauRepo;

    @Autowired
    private GroupeRepo groupeRepo;

    @Autowired
    private EtudiantRepo etudiantRepo;

    @Autowired
    private EnseignantRepo enseignantRepo;

    @Autowired
    private AdminRepo adminRepo;

    @Override
    public void run(String... args) throws Exception {
        loadFiliere(3);
        loadNiveau(9);
        loadGroupe(18);
        loadEtudiants(180);
        loadEnseignant(10);
        loadAdmin(2);
    }

    private void loadFiliere(int n) {
        Filiere filiere;
        for (int i = 0; i < n; i++) {
            filiere = new Filiere();
            filiere.setNom("Filiere" + (i + 1));
            filiereRepo.save(filiere);
        }
    }

    private void loadNiveau(int n) {
        Niveau niveau;
        for (int i = 0; i < n; i++) {
            niveau = new Niveau();
            niveau.setNom("Niveau" + (i + 1));
            niveau.setFiliere(filiereRepo.findOne((i / 3) + 1L));
            niveauRepo.save(niveau);
        }
    }

    private void loadGroupe(int n) {
        Groupe groupe;
        for (int i = 0; i < n; i++) {
            groupe = new Groupe();
            groupe.setNom("Groupe" + (i + 1));
            groupe.setNiveau(niveauRepo.findOne((i / 2) + 1L));
            groupeRepo.save(groupe);
        }
    }

    private void loadEtudiants(int n) {
        Etudiant etudiant;
        for (int j = 0; j < n; j++) {
            etudiant = new Etudiant();
            etudiant.setNom("Etudiant" + (j + 1));
            etudiant.setPrenom("Name" + (j + 1));
            etudiant.setUserName("U" + (j + 1));
            etudiant.setRole("etudiant");
            etudiant.setPassword("P" + (j + 1));
            etudiant.setGroupe(groupeRepo.findOne((j / 10) + 1L));
            etudiantRepo.save(etudiant);
        }
    }

    private void loadEnseignant(int n) {
        Enseignant enseignant;
        for (int j = 0; j < n; j++) {
            enseignant = new Enseignant();
            enseignant.setNom("Enseignant" + (j + 1));
            enseignant.setPrenom("Name" + (j + 1));
            enseignant.setUserName("Ens" + (j + 1));
            enseignant.setRole("enseignant");
            enseignant.setPassword("Ens" + (j + 1));
            enseignantRepo.save(enseignant);
        }
    }

    private void loadAdmin(int n) {
        Admin admin;
        for (int j = 0; j < n; j++) {
            admin = new Admin();
            admin.setNom("Admin" + (j + 1));
            admin.setPrenom("Name" + (j + 1));
            admin.setUserName("A" + (j + 1));
            admin.setRole("admin");
            admin.setPassword("A" + (j + 1));
            adminRepo.save(admin);
        }
    }


}
