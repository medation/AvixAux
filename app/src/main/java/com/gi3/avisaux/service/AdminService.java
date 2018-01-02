package com.gi3.avisaux.service;

import android.os.AsyncTask;
import android.util.Log;
import com.gi3.avisaux.domain.Avis;
import com.gi3.avisaux.domain.Utilisateur;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Med on 24/12/17.
 */

public class AdminService {

    private static String base_url = UtilisateurService.base_url;
    private RestTemplate restTemplate = new RestTemplate();

    public int addUser(Utilisateur user){
        String url = base_url + "/admin/add";
        HttpEntity<Utilisateur> request = new HttpEntity<>(user);
        ResponseEntity<Utilisateur> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, Utilisateur.class);
        int status = responseEntity.getStatusCode().value();
        return status;
    }
    public List<String> getGroupe(){
        String url = base_url + "/groupes";
        return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
        }).getBody();
    }

    public List<Utilisateur> getUsers(){
        String url = base_url + "/admin/users";
        return restTemplate.exchange(url, HttpMethod.GET,null, new ParameterizedTypeReference<List<Utilisateur>>() {}).getBody();
    }

    public void deleteUser(String role, int id){
        String url = base_url + "/admin/" + role + "/" + id + "/delete";
        restTemplate.delete(url);
    }

    public List<Avis> getAllAvis() {
        String url = base_url + "/admin/avis";
        return restTemplate.exchange(url, HttpMethod.GET,null, new ParameterizedTypeReference<List<Avis>>() {}).getBody();
    }

    public void deleteAvis(int id){
        String url = base_url + "/admin/avis/"+ id + "/delete";
        restTemplate.delete(url);
    }

}
