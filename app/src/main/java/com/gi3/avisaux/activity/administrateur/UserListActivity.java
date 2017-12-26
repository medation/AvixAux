package com.gi3.avisaux.activity.administrateur;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.gi3.avisaux.R;
import com.gi3.avisaux.domain.Utilisateur;
import com.gi3.avisaux.service.AdminService;
import com.gi3.avisaux.utils.UserArrayAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends ListActivity {

    private AdminService adminService = new AdminService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        ImageView logo = (ImageView) findViewById(R.id.logo_users);
        logo.setImageResource(R.drawable.listuser128);
        loadList();
    }

    public void loadList(){
        setListAdapter(new UserArrayAdapter(this, adminService.getUsers()));
    }

}
