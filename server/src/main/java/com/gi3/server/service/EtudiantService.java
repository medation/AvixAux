package com.gi3.server.service;

import com.gi3.server.domain.Avis;
import com.gi3.server.dto.AvisDTO;

import java.util.Set;

public interface EtudiantService {

    Set<AvisDTO> listAvix(Long id_etudiant);

}
