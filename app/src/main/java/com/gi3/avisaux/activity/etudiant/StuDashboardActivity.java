package com.gi3.avisaux.activity.etudiant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gi3.avisaux.R;
import com.gi3.avisaux.activity.enseignant.ProfilUserActivity;
import com.gi3.avisaux.domain.Utilisateur;

public class StuDashboardActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_dashboard);
    }

    public void avisClick(View view) {
        intent = new Intent(this, AvisListEtudiantActivity.class);
        intent.putExtra("user", (Utilisateur) getIntent().getExtras().get("user"));
        startActivity(intent);
    }

    public void profilClick(View view) {
        intent = new Intent(this, ProfilUserActivity.class);
        intent.putExtras(getIntent());
        startActivity(intent);
    }

    public void back(View view) {
        finish();
    }
}
