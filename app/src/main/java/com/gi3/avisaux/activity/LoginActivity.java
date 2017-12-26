package com.gi3.avisaux.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gi3.avisaux.R;
import com.gi3.avisaux.activity.administrateur.AdminDashboardActivity;
import com.gi3.avisaux.activity.enseignant.EnsDashboardActivity;
import com.gi3.avisaux.activity.etudiant.StuDashboardActivity;
import com.gi3.avisaux.domain.Utilisateur;
import com.gi3.avisaux.service.LoginService;

public class LoginActivity extends AppCompatActivity {

    public LoginService loginService = new LoginService();
    public Utilisateur user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClick(View view){

        String username = ((EditText) findViewById(R.id.userName)).getText().toString();
        String password = ((EditText) findViewById(R.id.password)).getText().toString();
        user = loginService.login(username,password);

        if(user == null){
            ((TextView) findViewById(R.id.error)).setText("Nom d'utilisateur ou mot de passe incorrect");
        }
        else{
            Intent intent ;
            switch (user.getRole()) {
                case "admin":
                    intent = new Intent(this, AdminDashboardActivity.class);
                    break;
                case "etudiant":
                    intent = new Intent(this, StuDashboardActivity.class);
                    break;
                case "enseignant":
                    intent = new Intent(this, EnsDashboardActivity.class);
                    break;
                default:
                    ((TextView) findViewById(R.id.error)).setText("Pas de role");
                    return;
            }
            intent.putExtra("user",user);
            startActivity(intent);
        }
    }

    public void back(View view) {
        finish();
    }
}
