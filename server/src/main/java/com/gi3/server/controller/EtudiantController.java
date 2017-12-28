package com.gi3.server.controller;

import com.gi3.server.domain.Avis;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kadarH
 */

@RestController
@RequestMapping("/etudiant/{id}")
public class EtudiantController {

    /**
     * @return list of all Avis
     */
    @GetMapping("/avis")
    public List<Avis> avisList() {
        return null;
    }

}
