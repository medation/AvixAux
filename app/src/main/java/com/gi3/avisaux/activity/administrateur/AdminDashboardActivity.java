package com.gi3.avisaux.activity.administrateur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gi3.avisaux.R;
import com.gi3.avisaux.service.AdminService;

public class AdminDashboardActivity extends AppCompatActivity {

    private AdminService adminService = new AdminService();
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
    }

    public void listerUserClick(View view){
        intent = new Intent(this,UserListActivity.class);
        startActivity(intent);
    }

    public void listerNotifClick(View view){

    }

    public void profilClick(View view){

    }

    public void addUserClick(View view){

    }
}
