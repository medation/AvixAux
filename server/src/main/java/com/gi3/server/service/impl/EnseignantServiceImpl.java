package com.gi3.server.service.impl;

import com.gi3.server.domain.Avis;
import com.gi3.server.domain.Filiere;
import com.gi3.server.domain.Groupe;
import com.gi3.server.domain.Niveau;
import com.gi3.server.domain.users.Enseignant;
import com.gi3.server.domain.users.Etudiant;
import com.gi3.server.dto.AvisDTO;
import com.gi3.server.repo.AvisRepo;
import com.gi3.server.repo.FiliereRepo;
import com.gi3.server.repo.GroupeRepo;
import com.gi3.server.repo.NiveauRepo;
import com.gi3.server.repo.users.EnseignantRepo;
import com.gi3.server.service.EnseignantService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author kadarH
 */
@Service
@Transactional
@Slf4j
public class EnseignantServiceImpl implements EnseignantService {

    private final AvisRepo avisRepo;
    private final FiliereRepo filiereRepo;
    private final NiveauRepo niveauRepo;
    private final GroupeRepo groupeRepo;
    private final EnseignantRepo enseignantRepo;

    public EnseignantServiceImpl(AvisRepo avisRepo, FiliereRepo filiereRepo, NiveauRepo niveauRepo, GroupeRepo groupeRepo, EnseignantRepo enseignantRepo) {
        this.avisRepo = avisRepo;
        this.filiereRepo = filiereRepo;
        this.niveauRepo = niveauRepo;
        this.groupeRepo = groupeRepo;
        this.enseignantRepo = enseignantRepo;
    }

    @Override
    public Set<AvisDTO> listAvix(Long id_enseignant) {

        Set<AvisDTO> avisDTOs = new HashSet<>();
        AvisDTO avisDTO = new AvisDTO();
        Enseignant enseignant = enseignantRepo.getOne(id_enseignant);
        Set<Avis> avisSet = enseignant.getAvisSet();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        for (Avis avis: avisSet){
            avisDTO = new AvisDTO();
            avisDTO.setId(avis.getId());
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
    public Avis add(AvisDTO avisDTO, Long id_enseignant) {
        String nom_filiere = avisDTO.getFiliere();
        String nom_niveau = avisDTO.getNiveau();
        String nom_groupe = avisDTO.getGroupe();
        Avis avis = new Avis();
        avis.setGroupe(nom_groupe);
        avis.setNiveau(nom_niveau);
        avis.setFiliere(nom_filiere);
        avis.setEnseignant(enseignantRepo.getOne(id_enseignant));
        avis.setDate(LocalDateTime.now());
        avis.setMessage(avisDTO.getMessage());
        if (!nom_groupe.equals("") && nom_groupe != null) {
            groupeRepo.findByNom(nom_groupe).getEtudiantSet().stream().forEach(etudiant -> avis.addToSet(etudiant));
        } else if (nom_niveau != "" && nom_niveau != null) {
            Set<Etudiant> etudiantSet = new HashSet<>();
            niveauRepo.findByNom(nom_niveau).getGroupeSet().stream().forEach(groupe -> groupe.getEtudiantSet().stream().forEach(etudiant -> etudiantSet.add(etudiant)));
            etudiantSet.stream().forEach(etudiant -> avis.addToSet(etudiant));
        } else if (nom_filiere != "" && nom_filiere != null) {
            Set<Etudiant> etudiantSet = new HashSet<>();
            filiereRepo.findByNom(nom_filiere).getNiveauSet().stream().forEach(niveau -> niveau.getGroupeSet().stream().forEach(groupe -> groupe.getEtudiantSet().stream().forEach(etudiant -> etudiantSet.add(etudiant))));
            etudiantSet.stream().forEach(etudiant -> avis.addToSet(etudiant));
        } else {
            return null;
        }
        return avisRepo.save(avis);
    }

    @Override
    public void delete(Long id_Avix) {
        avisRepo.delete(id_Avix);
    }

    @Override
    public List<Filiere> listFiliere() {
        return filiereRepo.findAll();
    }

    @Override
    public Set<Niveau> listNiveau(String nom_Filiere) {
        return filiereRepo.findByNom(nom_Filiere).getNiveauSet();
    }

    @Override
    public Set<Groupe> listGroupe(String nom_Niveau) {
        return niveauRepo.findByNom(nom_Niveau).getGroupeSet();
    }
}
