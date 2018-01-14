package com.gi3.avisaux.service;

import com.gi3.avisaux.domain.Utilisateur;
import com.gi3.avisaux.utils.Login;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class LoginService {

    private static String base_url = UtilisateurService.base_url;
    private RestTemplate restTemplate = new RestTemplate();

    public Utilisateur login(final String username, final String password){
        String url = base_url + "/login";
        Login login = new Login(username,password);
        HttpEntity<Login> request = new HttpEntity<>(login);
        ResponseEntity<Utilisateur> responseUser = restTemplate.exchange(url, HttpMethod.POST, request, Utilisateur.class);
        Utilisateur currentUser = responseUser.getBody();
        return currentUser;
    }

}
