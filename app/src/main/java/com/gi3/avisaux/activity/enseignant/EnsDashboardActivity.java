package com.gi3.avisaux.activity.enseignant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gi3.avisaux.R;
import com.gi3.avisaux.activity.ProfilActivity;

public class EnsDashboardActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ens_dashboard);
    }


    public void listerAvisClick(View view) {
        intent = new Intent(this, AvisListActivity.class);
        intent.putExtras(getIntent());
        startActivity(intent);
    }

    public void addAvisClick(View view) {
        intent = new Intent(this, AddAvisActivity.class);
        intent.putExtras(getIntent());
        startActivity(intent);
    }

    public void profilClick(View view) {
        intent = new Intent(this, ProfilActivity.class);
        intent.putExtras(getIntent());
        startActivity(intent);
    }

    public void back(View view) {
        finish();
    }
}
