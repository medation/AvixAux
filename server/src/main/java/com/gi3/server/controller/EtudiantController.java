package com.gi3.server.controller;

import com.gi3.server.domain.Avis;
import com.gi3.server.dto.AvisDTO;
import com.gi3.server.service.EtudiantService;

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
@RequestMapping("/etudiant/{id}")
public class EtudiantController {

    private EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    /**
     * @return list of all Avis
     */
    @GetMapping("/avis")
    public Set<AvisDTO> avisList(@PathVariable Long id) {
        return etudiantService.listAvix(id);
    }

}
