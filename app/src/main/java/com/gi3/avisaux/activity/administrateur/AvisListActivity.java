package com.gi3.avisaux.activity.administrateur;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageView;

import com.gi3.avisaux.R;
import com.gi3.avisaux.service.AdminService;
import com.gi3.avisaux.utils.AvisArrayAdapter;

public class AvisListActivity extends ListActivity {

    private AdminService adminService = new AdminService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avis_list);
        ImageView notif = findViewById(R.id.notif);
        notif.setImageResource(R.drawable.avis64);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        loadList();
    }

    public void loadList(){
        setListAdapter(new AvisArrayAdapter(this,adminService.getAllAvis(),true,false));
    }

    public void back(View view) {
        finish();
    }
}
