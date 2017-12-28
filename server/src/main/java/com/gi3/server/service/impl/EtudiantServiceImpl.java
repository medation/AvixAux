package com.gi3.server.service.impl;

import com.gi3.server.domain.Avis;
import com.gi3.server.repo.users.EtudiantRepo;
import com.gi3.server.service.EtudiantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Set<Avis> listAvix(Long id_etudiant) {
        return etudiantRepo.findOne(id_etudiant).getAvisSet();
    }
}
