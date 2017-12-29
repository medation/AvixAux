package com.gi3.avisaux.activity.enseignant;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.gi3.avisaux.R;
import com.gi3.avisaux.service.EnseignantService;

import java.util.ArrayList;
import java.util.List;

public class AddAvisActivity extends AppCompatActivity {

    private EnseignantService enseignantService = new EnseignantService();
    private String filiere;
    private String niveau;
    private String groupe;
    private Spinner filiereSpinner;
    private Spinner niveauSpinner;
    private Spinner groupeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_avis);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        filiereSpinner = (Spinner) findViewById(R.id.filiere);
        niveauSpinner = (Spinner) findViewById(R.id.niveau);
        groupeSpinner = (Spinner) findViewById(R.id.groupe);
        loadFiliere();
    }

    @Override
    protected void onStart() {
        super.onStart();

        filiereSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                filiere = (String) parent.getItemAtPosition(position);
                loadNiveau();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        niveauSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                niveau = (String) parent.getItemAtPosition(position);
                loadGroupe();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void loadGroupe() {
        List<String> groupes = new ArrayList<>();
        groupes.add("");
        groupes.addAll(enseignantService.getGroupe(niveau));
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, groupes);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        groupeSpinner.setAdapter(dataAdapter);
    }

    private void loadNiveau() {
        List<String> niveaux = new ArrayList<>();
        niveaux.add("");
        niveaux.addAll(enseignantService.getNiveau(filiere));
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, niveaux);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        niveauSpinner.setAdapter(dataAdapter);
    }

    private void loadFiliere() {
        List<String> filieres = enseignantService.getFiliere();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, filieres);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filiereSpinner.setAdapter(dataAdapter);
    }

    public void back(View view) {
        finish();
    }
}
