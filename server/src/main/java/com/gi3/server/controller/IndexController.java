package com.gi3.server.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * @author kadarH
 */

@RestController
@RequestMapping("")
public class IndexController {

    private FiliereRepo filiereRepo;
    private NiveauRepo niveauRepo;
    private GroupeRepo groupeRepo;
    private EtudiantRepo etudiantRepo;
    private EnseignantRepo enseignantRepo;
    private AdminRepo adminRepo;

    public IndexController(FiliereRepo filiereRepo, NiveauRepo niveauRepo,
                           GroupeRepo groupeRepo, EtudiantRepo etudiantRepo,
                           EnseignantRepo enseignantRepo, AdminRepo adminRepo) {
        this.filiereRepo = filiereRepo;
        this.niveauRepo = niveauRepo;
        this.groupeRepo = groupeRepo;
        this.etudiantRepo = etudiantRepo;
        this.enseignantRepo = enseignantRepo;
        this.adminRepo = adminRepo;
    }

    @GetMapping("/filieres")
    public List<Filiere> filiereList() {
        return filiereRepo.findAll();
    }

    @GetMapping("/filieres/{id}")
    public Set<Niveau> filiereNiveauList(@PathVariable Long id) {
        return filiereRepo.findOne(id).getNiveauSet();
    }

    @GetMapping("/Niveaux/{id}")
    public Set<Groupe> NiveauGroupeList(@PathVariable Long id) {
        return niveauRepo.findOne(id).getGroupeSet();
    }

    @GetMapping("/Groupe/{id}")
    public Set<Etudiant> GroupeUsersList(@PathVariable Long id) {
        return groupeRepo.findOne(id).getEtudiantSet();
    }

    @GetMapping("/etu")
    public List<Etudiant> etudiantList() {
        return etudiantRepo.findAll();
    }

    @GetMapping("/ens")
    public List<Enseignant> enseignantList() {
        return enseignantRepo.findAll();
    }

    @GetMapping("/admin")
    public List<Admin> adminList() {
        return adminRepo.findAll();
    }

    @GetMapping("/niveaux")
    public List<Niveau> niveauList() {
        return niveauRepo.findAll();
    }

    @GetMapping("/groupes")
    public List<Groupe> groupeList() {
        return groupeRepo.findAll();
    }

}
