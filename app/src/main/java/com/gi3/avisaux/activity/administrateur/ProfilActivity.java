package com.gi3.avisaux.activity.administrateur;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import com.gi3.avisaux.R;
import com.gi3.avisaux.domain.Utilisateur;
import com.gi3.avisaux.service.AdminService;

public class ProfilActivity extends AppCompatActivity {

    private AdminService adminService = new AdminService();
    private Utilisateur admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        loadProfil();
    }

    public void loadProfil(){
        Bundle bundle = getIntent().getExtras();
        admin = (Utilisateur) bundle.get("user");

        EditText userName = (EditText) findViewById(R.id.user_name);
        EditText password = (EditText) findViewById(R.id.password);
        EditText lastName = (EditText) findViewById(R.id.last_name);
        EditText name = (EditText) findViewById(R.id.name);

        userName.setText(admin.getUserName());
        password.setText(admin.getPassword());
        lastName.setText(admin.getNom());
        name.setText(admin.getPrenom());
    }

    public void modifieClick(){

    }
}
