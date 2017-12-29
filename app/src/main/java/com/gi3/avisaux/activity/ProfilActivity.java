package com.gi3.avisaux.activity;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gi3.avisaux.R;
import com.gi3.avisaux.domain.Utilisateur;
import com.gi3.avisaux.service.AdminService;
import com.gi3.avisaux.service.UtilisateurService;

public class ProfilActivity extends AppCompatActivity {

    private Utilisateur user;
    private UtilisateurService utilisateurService = new UtilisateurService();
    private EditText password;
    private EditText confirmPassword;
    private EditText lastName;
    private EditText name;
    private TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        password = (EditText) findViewById(R.id.password);
        confirmPassword = (EditText) findViewById(R.id.confirm_password);
        lastName = (EditText) findViewById(R.id.last_name);
        name = (EditText) findViewById(R.id.name);

        Bundle bundle = getIntent().getExtras();
        user = (Utilisateur) bundle.get("user");

        loadProfil();
    }

    public void loadProfil() {

        password.setText(user.getPassword());
        confirmPassword.setText(user.getPassword());
        lastName.setText(user.getNom());
        name.setText(user.getPrenom());

    }

    public void valideClick(View view){

        error = (TextView) findViewById(R.id.error);
        String pass = password.getText().toString();
        String confirmepass = confirmPassword.getText().toString();
        user.setPassword(pass);
        user.setNom(lastName.getText().toString());
        user.setPrenom(name.getText().toString());

        if(!pass.equals(confirmepass))
            error.setText("Le mot de passe n'est pas confirmé correctement !");
        else if(utilisateurService.modifierProfil(user) == 500)
            error.setText("Erreur lors de la modification ! ");
        else
            error.setText("Votre profil a été modifié avec succes !");
    }

    public void back(View view) {
        finish();
    }
}
