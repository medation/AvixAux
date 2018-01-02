package com.gi3.avisaux.activity.enseignant;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.gi3.avisaux.R;
import com.gi3.avisaux.domain.Utilisateur;
import com.gi3.avisaux.service.EnseignantService;
import com.gi3.avisaux.utils.AvisArrayAdapter;

public class AvisListActivity extends ListActivity {

    private EnseignantService enseignantService = new EnseignantService();
    private Utilisateur user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avis_list);
        ImageView notif = findViewById(R.id.notif);
        notif.setImageResource(R.drawable.avis64);
        user = (Utilisateur) getIntent().getExtras().get("user");
        loadList();
    }

    public void loadList() {
        setListAdapter(new AvisArrayAdapter(this, enseignantService.getMyAvis(user.getId()),true, false, getIntent()));
    }

    public void back(View view) {
        finish();
    }
}
