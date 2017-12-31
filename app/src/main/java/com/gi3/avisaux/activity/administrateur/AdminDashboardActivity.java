package com.gi3.avisaux.activity.administrateur;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.gi3.avisaux.R;
import com.gi3.avisaux.activity.ProfilActivity;
import com.gi3.avisaux.domain.Utilisateur;

public class AdminDashboardActivity extends AppCompatActivity {

    private Intent intent;
    private Utilisateur user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        Bundle bundle = getIntent().getExtras();
        user = (Utilisateur) bundle.get("user");
        Toast toast = Toast.makeText(getApplicationContext(),"Bonjour "+user.getNom()+" "+user.getPrenom(),Toast.LENGTH_SHORT);
        toast.show();
    }

    public void listerUserClick(View view){
        intent = new Intent(this,UserListActivity.class);
        intent.putExtras(getIntent());
        startActivity(intent);
    }

    public void listerNotifClick(View view){
        intent = new Intent(this,AvisListActivity.class);
        intent.putExtras(getIntent());
        startActivity(intent);
    }

    public void profilClick(View view){
        intent = new Intent(this,ProfilActivity.class);
        intent.putExtras(getIntent());
        startActivity(intent);
    }

    public void addUserClick(View view){
        intent = new Intent(this,AddUserActivity.class);
        intent.putExtras(getIntent());
        startActivity(intent);
    }

    public void back(View view) {
        finish();
    }
}
