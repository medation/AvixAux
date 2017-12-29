package com.gi3.avisaux.service;

import android.os.AsyncTask;
import android.util.Log;
import com.gi3.avisaux.domain.Avis;
import com.gi3.avisaux.domain.Utilisateur;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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

    private static String base_url = "http://192.168.1.5:8080";

    private RestTemplate restTemplate = new RestTemplate();

    public void addUser(Utilisateur user){

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Utilisateur> request = new HttpEntity<>(user);
        String url = base_url + "/admin/add";

        restTemplate.postForObject(url, request,Utilisateur.class);

    }
    public List<String> getGroupe(){

        String url = base_url + "/groupes";
        return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
        }).getBody();

        ///return Arrays.asList("G1","G2");
    }

    public List<Utilisateur> getUsers(){

        /*List<Utilisateur> users = new ArrayList<>();
        Utilisateur user1 = new Utilisateur(1,"Salah","Loukili","userSalah","pass","user",null);
        users.add(user1);
        Utilisateur user2 = new Utilisateur(1,"Hamza","Kadar","userH","pass","user",null);
        users.add(user2);
        return users;*/

        String url = base_url + "/admin/users";
        return restTemplate.exchange(url, HttpMethod.GET,null, new ParameterizedTypeReference<List<Utilisateur>>() {}).getBody();
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
