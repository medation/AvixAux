package com.gi3.avisaux.service;

import com.gi3.avisaux.domain.Utilisateur;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LoginService {

    private static String base_url = UtilisateurService.base_url;
    private RestTemplate restTemplate = new RestTemplate();

    public Utilisateur login(final String usernameparam, final String passparam){
        String url = base_url + "/login";
        class Login{
            String username = usernameparam;
            String password = passparam;
        }
        HttpEntity<Login> request = new HttpEntity<>(new Login());
        ResponseEntity<Utilisateur> responseUser = restTemplate.exchange(url, HttpMethod.POST, request, Utilisateur.class);
        Utilisateur currentUser = responseUser.getBody();
        return currentUser;
    }

}
