package com.gi3.avisaux.service;

import com.gi3.avisaux.domain.Avis;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Med on 26/12/17.
 */

public class EnseignantService {

    private static String base_url = "http://192.168.49.1:8080";

    private RestTemplate restTemplate = new RestTemplate();


    public List<Avis> getMyAvis() {
        List<Avis> avis = new ArrayList<>();
        Avis avis1 = new Avis(1, "Lsfzefzefum dolor , consefzefzfzefzefer id velit id, vestibulum auc sapien. Sed quis mauris eget sem imperdiet rhoncus.", "Professeur ZE", "Groupe sx", "Niveau aq", "Filiere x", "25/12/2017 23:20");
        Avis avis2 = new Avis(1, "Lorem zefzefzeflor ", "Professeur BV", "Groupe T", "Niveau A", "Filiere K", "28/12/2017 14:20");
        avis.add(avis1);
        avis.add(avis2);
        return avis;
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
