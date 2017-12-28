package com.gi3.server.service;

import com.gi3.server.domain.Avis;
import com.gi3.server.domain.Filiere;
import com.gi3.server.domain.Groupe;
import com.gi3.server.domain.Niveau;
import com.gi3.server.dto.AvisDTO;

import java.util.List;
import java.util.Set;

public interface EnseignantService {

    Set<Avis> listAvix(Long id_enseignant);

    Avis add(AvisDTO avisDTO, Long id_enseignant);

    void delete(Long id_Avix);

    List<Filiere> listFiliere();

    Set<Niveau> listNiveau(String nom_Filiere);

    Set<Groupe> listGroupe(String nom_Niveau);
}
