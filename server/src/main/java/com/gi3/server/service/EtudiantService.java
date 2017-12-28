package com.gi3.server.service;

import com.gi3.server.domain.Avis;

import java.util.Set;

public interface EtudiantService {

    Set<Avis> listAvix(Long id_etudiant);

}
