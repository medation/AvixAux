package com.gi3.server.service.impl;

import com.gi3.server.domain.Avis;
import com.gi3.server.domain.users.Admin;
import com.gi3.server.domain.users.Enseignant;
import com.gi3.server.domain.users.Etudiant;
import com.gi3.server.domain.users.Utilisateur;
import com.gi3.server.dto.AvisDTO;
import com.gi3.server.dto.UtilisateurDTO;
import com.gi3.server.repo.AvisRepo;
import com.gi3.server.repo.GroupeRepo;
import com.gi3.server.repo.users.AdminRepo;
import com.gi3.server.repo.users.EnseignantRepo;
import com.gi3.server.repo.users.EtudiantRepo;
import com.gi3.server.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author kadarH
 */

@Service
@Transactional
@Slf4j
public class AdminServiceImpl implements AdminService {

    private AvisRepo avisRepo;
    private EnseignantRepo enseignantRepo;
    private EtudiantRepo etudiantRepo;
    private AdminRepo adminRepo;
    private GroupeRepo groupeRepo;

    public AdminServiceImpl(AvisRepo avisRepo, EnseignantRepo enseignantRepo, EtudiantRepo etudiantRepo, AdminRepo adminRepo, GroupeRepo groupeRepo) {
        this.avisRepo = avisRepo;
        this.enseignantRepo = enseignantRepo;
        this.etudiantRepo = etudiantRepo;
        this.adminRepo = adminRepo;
        this.groupeRepo = groupeRepo;
    }

    @Override
    public UtilisateurDTO add(UtilisateurDTO utilisateurDTO) {
        if (utilisateurDTO.getRole().equals("enseignant")) {
            Enseignant enseignant = new Enseignant();
            enseignant.setNom(utilisateurDTO.getNom());
            enseignant.setPrenom(utilisateurDTO.getPrenom());
            enseignant.setPassword(utilisateurDTO.getPassword());
            enseignant.setRole("enseignant");
            enseignant.setUserName(utilisateurDTO.getUserName());
            enseignantRepo.save(enseignant);
            log.debug("--- Service --- AdminService called : enseignant saved");
        }
        if (utilisateurDTO.getRole().equals("etudiant")) {
            Etudiant etudiant = new Etudiant();
            etudiant.setNom(utilisateurDTO.getNom());
            etudiant.setPrenom(utilisateurDTO.getPrenom());
            etudiant.setPassword(utilisateurDTO.getPassword());
            etudiant.setRole("etudiant");
            etudiant.setUserName(utilisateurDTO.getUserName());
            etudiant.setGroupe(groupeRepo.findByNom(utilisateurDTO.getGroupe()));
            etudiantRepo.save(etudiant);
            log.debug("--- Service --- AdminService called : etudiant saved");
        }
        if (utilisateurDTO.getRole().equals("admin")) {
            Admin admin = new Admin();
            admin.setNom(utilisateurDTO.getNom());
            admin.setPrenom(utilisateurDTO.getPrenom());
            admin.setPassword(utilisateurDTO.getPassword());
            admin.setRole("admin");
            admin.setUserName(utilisateurDTO.getUserName());
            adminRepo.save(admin);
            log.debug("--- Service --- AdminService called : admin saved");
        }
        return utilisateurDTO;
    }

    @Override
    public List<Utilisateur> listUsers() {
        List<Utilisateur> list = new ArrayList<>();
        adminRepo.findAll().forEach(admin -> list.add(admin));
        enseignantRepo.findAll().forEach(enseignant -> list.add(enseignant));
        etudiantRepo.findAll().forEach(etudiant -> list.add(etudiant));
        return list;
    }

    @Override
    public Set<AvisDTO> listAvix() {

        Set<AvisDTO> avisDTOs = new HashSet<>();
        AvisDTO avisDTO = new AvisDTO();
        List<Avis> avisList = avisRepo.findAll();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        for (Avis avis: avisList){
            avisDTO = new AvisDTO();
            avisDTO.setId(avis.getId());
            avisDTO.setEnseignant(avis.getEnseignant().getNom()+" "+avis.getEnseignant().getPrenom());
            avisDTO.setDate(avis.getDate().format(dateTimeFormatter));
            avisDTO.setMessage(avis.getMessage());
            avisDTO.setGroupe(avis.getGroupe());
            avisDTO.setNiveau(avis.getNiveau());
            avisDTO.setFiliere(avis.getFiliere());
            avisDTOs.add(avisDTO);
        }
        return avisDTOs;
    }


    @Override
    public void deleteUser(Long id, String role) {
        if (role.equals("admin"))
            adminRepo.delete(id);
        if (role.equals("etudiant"))
            etudiantRepo.delete(id);
        if (role.equals("enseignant"))
            enseignantRepo.delete(id);
    }

    @Override
    public void deleteAvix(Long id) {
        avisRepo.delete(id);
    }
}
