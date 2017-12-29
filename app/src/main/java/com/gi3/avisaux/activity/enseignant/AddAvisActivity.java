package com.gi3.avisaux.activity.enseignant;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import com.gi3.avisaux.R;
import com.gi3.avisaux.service.EnseignantService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AddAvisActivity extends AppCompatActivity {

    private static final int FILE_SELECT_CODE = 0;
    private EnseignantService enseignantService = new EnseignantService();
    private String filiere;
    private String niveau;
    private String groupe;
    private Spinner filiereSpinner;
    private Spinner niveauSpinner;
    private Spinner groupeSpinner;
    private TextView path;
    private String pathTo;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_avis);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        filiereSpinner = (Spinner) findViewById(R.id.filiere);
        niveauSpinner = (Spinner) findViewById(R.id.niveau);
        groupeSpinner = (Spinner) findViewById(R.id.groupe);
        path = (TextView) findViewById(R.id.path);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case FILE_SELECT_CODE:
                if (resultCode == RESULT_OK) {
                    // Get the Uri of the selected file
                    Uri uri = data.getData();

                    // Get the path
                    if ("content".equalsIgnoreCase(uri.getScheme())) {
                        String[] projection = {"_data"};
                        Cursor cursor = null;

                        try {
                            cursor = this.getContentResolver().query(uri, projection, null, null, null);
                            int column_index = cursor.getColumnIndexOrThrow("_data");
                            if (cursor.moveToFirst()) {
                                pathTo = cursor.getString(column_index);
                            }
                        } catch (Exception e) {
                            // Eat it
                        }
                    } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                        pathTo = uri.getPath();
                    }

                    // the file instance
                    file = new File(pathTo);
                    path.setText(pathTo);
                    // Initiate the upload
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
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

    public void showChooser(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        try {
            startActivityForResult(
                    Intent.createChooser(intent, "Select a File to Upload"),
                    FILE_SELECT_CODE);
        } catch (android.content.ActivityNotFoundException ex) {
            // Potentially direct the user to the Market with a Dialog
            Toast.makeText(this, "Please install a File Manager.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
