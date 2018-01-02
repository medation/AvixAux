package com.gi3.server.controller;

import com.gi3.server.domain.Avis;
import com.gi3.server.dto.AvisDTO;
import com.gi3.server.service.EnseignantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author kadarH
 */

@RestController
@RequestMapping("/enseignant")
public class EnseignantController {


    private EnseignantService enseignantService;

    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    /**
     * This methode will accept an object AvisDTO ,call the service to
     * convert the object to Avis.
     *
     *
     * @param id
     * @return Avis
     */
    @PostMapping("/{id}/add")
    @ResponseBody
    public ResponseEntity<String> addAvis(@RequestBody AvisDTO avisDTO, @PathVariable Long id) throws IOException {
        enseignantService.add(avisDTO, id);
        return new ResponseEntity<>("200", HttpStatus.OK);
    }

    /**
     * @return list de tout les avis
     */

    @GetMapping("/{id}/avis")
    public Set<AvisDTO> avisList(@PathVariable Long id) {
        return enseignantService.listAvix(id);
    }


    /**
     * @return list des filiere
     * you will use it when the teacher want to fill the form of Avis.
     */
    @GetMapping("/filieres")
    public List<String> filieresList() {
        List<String> list = new ArrayList<>();
        enseignantService.listFiliere().stream().forEach(filiere -> list.add(filiere.getNom()));
        return list;
    }

    /**
     * @param nom_filiere You will use it when the teacher want to fill the form of Avis.
     * @return list des Niveau where Filiere.id = id_Filiere
     */
    @GetMapping("/filieres/{nom_filiere}")
    public List<String> niveauList(@PathVariable String nom_filiere) {
        List<String> list = new ArrayList<>();
        enseignantService.listNiveau(nom_filiere).stream().forEach(niveau -> list.add(niveau.getNom()));
        return list;
    }

    /**
     * @param nom_niveau You will use it when the teacher want to fill the form of Avis.
     * @return list des Groupe where Niveau.id = id_Niveau
     */
    @GetMapping("/niveaux/{nom_niveau}")
    public List<String> groupeList(@PathVariable String nom_niveau) {
        List<String> list = new ArrayList<>();
        enseignantService.listGroupe(nom_niveau).stream().forEach(groupe -> list.add(groupe.getNom()));
        return list;
    }

    /**
     * @param id_Avis When the teacher want to delete his 'avis'
     * @return void
     */
    @DeleteMapping("/avis/{id_Avis}/delete")
    public void deleteAvis(@PathVariable Long id_Avis) {
        return;
    }

}
