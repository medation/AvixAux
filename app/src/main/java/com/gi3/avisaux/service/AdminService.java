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

    private static String base_url = "http://192.168.1.15:8080";
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

    public List<Avis> getAllAvis(){
        List<Avis> avis = new ArrayList<>();
        Avis avis1 = new Avis(1,"Lorem ipsum dolor , consectetur adipiscing elit. Nunc purus ligula, ullamcorper id velit id, vestibulum auc sapien. Sed quis mauris eget sem imperdiet rhoncus.","Professeur X","Groupe Y","Niveau Z","Filiere K","25/12/2017 23:20");
        Avis avis2 = new Avis(1,"Lorem ipsum dolor ","Professeur X","Groupe T","Niveau A","Filiere K","28/12/2017 14:20");
        avis.add(avis1);
        avis.add(avis2);
        return avis;
    }

}
