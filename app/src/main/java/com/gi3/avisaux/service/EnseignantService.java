package com.gi3.avisaux.service;

import com.gi3.avisaux.domain.Avis;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Med on 26/12/17.
 */

public class EnseignantService {

    private static String base_url = UtilisateurService.base_url;

    private RestTemplate restTemplate = new RestTemplate();


    public String addAvis(Avis avis,int id){

        String url = base_url + "/enseignant/"+id+"/add";
        HttpEntity<Avis> request = new HttpEntity<>(avis);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        String status = responseEntity.getBody();
        return status;
    }


    public List<Avis> getMyAvis(int id) {
        String url = base_url + "/enseignant/"+id+"/avis";
        return restTemplate.exchange(url, HttpMethod.GET,null, new ParameterizedTypeReference<List<Avis>>() {}).getBody();
    }


    public List<String> getGroupe(String niveau) {
        String url = base_url + "/enseignant/niveaux/" + niveau;
        if (niveau.equals("")) return new ArrayList<>();
        return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
        }).getBody();
    }

    public List<String> getNiveau(String filiere) {
        String url = base_url + "/enseignant/filieres/" + filiere;
        if (filiere.equals("")) return new ArrayList<>();
        return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
        }).getBody();
    }

    public List<String> getFiliere() {
        String url = base_url + "/enseignant/filieres";
        return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
        }).getBody();
    }
}
