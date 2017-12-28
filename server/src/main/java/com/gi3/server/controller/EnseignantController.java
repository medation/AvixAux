package com.gi3.server.controller;

import com.gi3.server.domain.Avis;
import com.gi3.server.domain.Filiere;
import com.gi3.server.domain.Groupe;
import com.gi3.server.domain.Niveau;
import com.gi3.server.dto.AvisDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kadarH
 */

@RestController
@RequestMapping("/enseignant/{id}")
public class EnseignantController {


    /**
     * This methode will accept an object AvisDTO ,call the service to
     * convert the object to Avis.
     *
     * @param avisDTO
     * @param id
     * @return Avis
     */
    @PostMapping("/add")
    public Avis addAvis(@RequestBody AvisDTO avisDTO, @PathVariable Long id) {
        return null;
    }

    /**
     * @return list de tout les avis
     */

    @GetMapping("/avis")
    public List<Avis> avisList() {
        return null;
    }


    /**
     * @return list des filiere
     * you will use it when the teacher want to fill the form of Avis.
     */
    @GetMapping("/filieres")
    public List<Filiere> filieresList() {
        return null;
    }

    /**
     * @param id_Filiere You will use it when the teacher want to fill the form of Avis.
     * @return list des Niveau where Filiere.id = id_Filiere
     */
    @GetMapping("/filieres/{id_Filiere}")
    public List<Niveau> niveauList(@PathVariable Long id_Filiere) {
        return null;
    }

    /**
     * @param id_Niveau You will use it when the teacher want to fill the form of Avis.
     * @return list des Groupe where Niveau.id = id_Niveau
     */
    @GetMapping("/niveaux/{id_Niveau}")
    public List<Groupe> groupeList(@PathVariable Long id_Niveau) {
        return null;
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
