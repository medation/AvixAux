package com.gi3.avisaux.activity.administrateur;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.gi3.avisaux.R;
import com.gi3.avisaux.domain.Utilisateur;
import com.gi3.avisaux.service.AdminService;

import java.util.ArrayList;
import java.util.List;

public class AddUserActivity extends AppCompatActivity {

    private AdminService adminService = new AdminService();

    private String userName;
    private String password;
    private String name;
    private String lastName;
    private String role;
    private String groupe;
    private Spinner roleSprinner;
    private Spinner groupeSpinner;
    private Utilisateur user;
    private TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        loadRole();
        loadGroupe();
    }

    @Override
    protected void onStart() {
        super.onStart();

        roleSprinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                role = (String) parent.getItemAtPosition(position);
                if(role.equals("etudiant")){
                    groupeSpinner.setEnabled(true);
                }
                else  groupeSpinner.setEnabled(false);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void loadRole(){
        roleSprinner = ((Spinner) findViewById(R.id.role));
    }

    public void loadGroupe(){
        groupeSpinner = (Spinner) findViewById(R.id.groupe);
        List<String> groupes;
        groupes = adminService.getGroupe();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, groupes);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        groupeSpinner.setAdapter(dataAdapter);
    }

    public void addUserClick(View view){
        userName = ((EditText) findViewById(R.id.user_name)).getText().toString();
        password = ((EditText) findViewById(R.id.password)).getText().toString();
        name = ((EditText) findViewById(R.id.name)).getText().toString();
        lastName = ((EditText) findViewById(R.id.last_name)).getText().toString();
        groupe = groupeSpinner.getSelectedItem().toString();
        Utilisateur user = new Utilisateur(200,name,lastName,userName,password,role,groupe);

        error = (TextView) findViewById(R.id.error);
        if(adminService.addUser(user) == 500){
            error.setText("Erreur lors de l'ajout");
        }
        else error.setText("Utilisateur ajouté");
    }

    public void back(View view) {
        finish();
    }
}
