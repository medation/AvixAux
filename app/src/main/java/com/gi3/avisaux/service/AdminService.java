package com.gi3.avisaux.service;

import android.os.AsyncTask;
import android.util.Log;
import com.gi3.avisaux.domain.Avis;
import com.gi3.avisaux.domain.Utilisateur;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Med on 24/12/17.
 */

public class AdminService {

    private static String base_url = "http://192.168.49.1:8080";
    private List<String> groupes = new ArrayList<>();
    public void addUser(Utilisateur user){

    }

    public void inst() {
        new HttpRequestTask().execute();
    }
    public List<String> getGroupe(){
        return groupes;
    }

    public List<Utilisateur> getUsers(){
        List<Utilisateur> users = new ArrayList<>();
        Utilisateur user1 = new Utilisateur(1,"Salah","Loukili","userSalah","pass","user",null);
        users.add(user1);
        Utilisateur user2 = new Utilisateur(1,"Hamza","Kadar","userH","pass","user",null);
        users.add(user2);
        return users;
    }

    public List<Avis> getAllAvis(){
        List<Avis> avis = new ArrayList<>();
        Avis avis1 = new Avis(1,"Lorem ipsum dolor , consectetur adipiscing elit. Nunc purus ligula, ullamcorper id velit id, vestibulum auc sapien. Sed quis mauris eget sem imperdiet rhoncus.","Professeur X","Groupe Y","Niveau Z","Filiere K","25/12/2017 23:20");
        Avis avis2 = new Avis(1,"Lorem ipsum dolor ","Professeur X","Groupe T","Niveau A","Filiere K","28/12/2017 14:20");
        avis.add(avis1);
        avis.add(avis2);
        return avis;
    }

    class HttpRequestTask extends AsyncTask<Void, Void, List<String>> {

        @Override
        protected List<String> doInBackground(Void... params) {
            try {
                final String url = AdminService.base_url + "/groupes";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                groupes = restTemplate.getForObject(url, List.class);
                return groupes;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<String> list) {
            super.onPostExecute(list);
        }
    }
}
