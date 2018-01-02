package com.gi3.avisaux.activity.etudiant;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageView;

import com.gi3.avisaux.R;
import com.gi3.avisaux.domain.Utilisateur;
import com.gi3.avisaux.service.EtudiantService;
import com.gi3.avisaux.utils.AvisArrayAdapter;

public class AvisListEtudiantActivity extends ListActivity {

    private EtudiantService etudiantService = new EtudiantService();
    private Utilisateur etudiant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avis_list_etudiant);
        ImageView notif = findViewById(R.id.notif);
        notif.setImageResource(R.drawable.avis64);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        etudiant = (Utilisateur) getIntent().getExtras().get("user");

        loadList();
    }

    public void loadList() {
        setListAdapter(new AvisArrayAdapter(this, etudiantService.getAvisEtudiant(etudiant.getId()),false,true,getIntent()));
    }

    public void back(View view) {
        finish();
    }
}
