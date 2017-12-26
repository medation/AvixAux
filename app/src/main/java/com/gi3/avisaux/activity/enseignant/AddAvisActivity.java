package com.gi3.avisaux.activity.enseignant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gi3.avisaux.R;

public class AddAvisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_avis);
    }

    public void back(View view) {
        finish();
    }
}
