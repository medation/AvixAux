package com.gi3.avisaux.activity.administrateur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gi3.avisaux.R;
import com.gi3.avisaux.domain.Utilisateur;
import com.gi3.avisaux.service.AdminService;

public class AdminDashboardActivity extends AppCompatActivity {

    private AdminService adminService = new AdminService();
    private Intent intent;
    private Utilisateur admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

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
}
