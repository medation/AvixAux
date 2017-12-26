package com.gi3.avisaux.activity.enseignant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.gi3.avisaux.R;
import com.gi3.avisaux.domain.Utilisateur;

public class ProfilUserActivity extends AppCompatActivity {


    private Utilisateur enseignant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_user);
        loadProfil();
    }

    public void loadProfil() {
        Bundle bundle = getIntent().getExtras();
        enseignant = (Utilisateur) bundle.get("user");


        EditText password = (EditText) findViewById(R.id.password);
        EditText confirmPassword = (EditText) findViewById(R.id.confirm_password);

        EditText lastName = (EditText) findViewById(R.id.last_name);
        EditText name = (EditText) findViewById(R.id.name);

        lastName.setText(enseignant.getNom());
        name.setText(enseignant.getPrenom());
    }

    public void back(View view) {
        finish();
    }
}
