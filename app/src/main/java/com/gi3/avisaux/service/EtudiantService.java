package com.gi3.avisaux.service;

import com.gi3.avisaux.domain.Avis;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Med on 26/12/17.
 */

public class EtudiantService {

    private static String base_url = UtilisateurService.base_url;
    private RestTemplate restTemplate = new RestTemplate();

    public List<Avis> getAvisEtudiant(int id) {
        String url = base_url + "/etudiant/"+id+"/avis";
        return restTemplate.exchange(url, HttpMethod.GET,null, new ParameterizedTypeReference<List<Avis>>() {}).getBody();
    }
}
