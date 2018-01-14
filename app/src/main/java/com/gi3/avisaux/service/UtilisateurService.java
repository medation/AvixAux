package com.gi3.avisaux.service;

import com.gi3.avisaux.domain.Utilisateur;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Med on 29/12/17.
 */

public class UtilisateurService {

    public static String base_url = "http://45.77.113.146:8080";
    private RestTemplate restTemplate = new RestTemplate();

    public int modifierProfil(Utilisateur user){
        String url = base_url+"/user/"+user.getId()+"/put";
        HttpEntity<Utilisateur> request = new HttpEntity<>(user);
        ResponseEntity<Utilisateur> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, request, Utilisateur.class);
        int status = responseEntity.getStatusCode().value();
        return status;
    }
}
