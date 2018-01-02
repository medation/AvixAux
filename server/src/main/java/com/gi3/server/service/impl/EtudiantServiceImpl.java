package com.gi3.server.service.impl;

import com.gi3.server.domain.Avis;
import com.gi3.server.dto.AvisDTO;
import com.gi3.server.repo.users.EtudiantRepo;
import com.gi3.server.service.EtudiantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class EtudiantServiceImpl implements EtudiantService {

    private final EtudiantRepo etudiantRepo;

    public EtudiantServiceImpl(EtudiantRepo etudiantRepo) {
        this.etudiantRepo = etudiantRepo;
    }

    @Override
    public Set<AvisDTO> listAvix(Long id_etudiant) {

        Set<AvisDTO> avisDTOs = new HashSet<>();
        AvisDTO avisDTO = new AvisDTO();
        Set<Avis> avisList = etudiantRepo.findOne(id_etudiant).getAvisSet();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        for (Avis avis: avisList){
            avisDTO = new AvisDTO();
            avisDTO.setId(avis.getId());
            avisDTO.setEnseignant(avis.getEnseignant().getNom()+" "+avis.getEnseignant().getPrenom());
            avisDTO.setDate(avis.getDate().format(dateTimeFormatter));
            avisDTO.setMessage(avis.getMessage());
            avisDTOs.add(avisDTO);
        }
        return avisDTOs;
    }
}
