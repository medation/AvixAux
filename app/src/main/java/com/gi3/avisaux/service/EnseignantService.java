package com.gi3.avisaux.service;

import com.gi3.avisaux.domain.Avis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Med on 26/12/17.
 */

public class EnseignantService {



    public List<Avis> getMyAvis() {
        List<Avis> avis = new ArrayList<>();
        Avis avis1 = new Avis(1, "Lsfzefzefum dolor , consefzefzfzefzefer id velit id, vestibulum auc sapien. Sed quis mauris eget sem imperdiet rhoncus.", "Professeur ZE", "Groupe sx", "Niveau aq", "Filiere x", "25/12/2017 23:20");
        Avis avis2 = new Avis(1, "Lorem zefzefzeflor ", "Professeur BV", "Groupe T", "Niveau A", "Filiere K", "28/12/2017 14:20");
        avis.add(avis1);
        avis.add(avis2);
        return avis;
    }

}
