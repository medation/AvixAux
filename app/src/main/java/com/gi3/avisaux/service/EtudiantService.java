package com.gi3.avisaux.service;

import com.gi3.avisaux.domain.Avis;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Med on 26/12/17.
 */

public class EtudiantService {

    public List<Avis> getAvisEtudiant(int idEtudiant) {
        return Arrays.asList(
                new Avis(3, "jzenfkzenjfznefzjenlfzef", "lzelmfkme", "kklz,ekl,z", "klkdjelzjdlze", "kjzlekfjzlef", "kdljdzlejd"),
                new Avis(4, "jzedddddddddddddddddddddddd", "zzzzzzzzzzzzzzzzzzzzzzz", "kklz,ekl,z", "klkdjelzjdlze", "kjzlekfjzlef", "kdljdzlejd")
        );
    }
}
