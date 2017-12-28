package com.gi3.avisaux.activity.administrateur;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import com.gi3.avisaux.R;
import com.gi3.avisaux.domain.Utilisateur;
import com.gi3.avisaux.service.AdminService;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        loadRole();
        adminService.inst();
        groupeSpinner = (Spinner) findViewById(R.id.groupe);

        /*
        role = roleSprinner.getSelectedItem().toString();
        if(role.equals("etudiant")){
            groupeSpinner.setEnabled(true);
        }*/

        roleSprinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                role = (String) parent.getItemAtPosition(position);
                if(role.equals("etudiant")){
                    groupeSpinner.setEnabled(true);
                    loadGroupe();
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

        Utilisateur user = new Utilisateur(name,lastName,userName,password,role,null);

    }

    public void back(View view) {
        finish();
    }
}
