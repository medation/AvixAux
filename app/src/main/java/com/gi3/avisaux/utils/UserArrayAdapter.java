package com.gi3.avisaux.utils;



import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gi3.avisaux.R;
import com.gi3.avisaux.domain.Utilisateur;
import com.gi3.avisaux.service.AdminService;

import java.util.List;

/**
 * Created by Med on 25/12/17.
 */

public class UserArrayAdapter extends ArrayAdapter<Utilisateur> {

    private final Context context;
    private final List<Utilisateur> users;
    private Intent intent;
    private AdminService adminService = new AdminService();
    private boolean refresh = false;
    private TextView name;
    private TextView lastName;
    private TextView role;
    private ImageButton btnDelete;
    private boolean delete =false;

    public UserArrayAdapter(Context context, List<Utilisateur> users, Intent intent) {
        super(context, R.layout.list_users, users);
        this.context = context;
        this.users = users;
        this.intent = intent;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View rowView = inflater.inflate(R.layout.list_users, parent, false);

        name = (TextView) rowView.findViewById(R.id.name);
        lastName = (TextView) rowView.findViewById(R.id.last_name);
        role = (TextView) rowView.findViewById(R.id.role);

        name.setText(users.get(position).getPrenom());
        lastName.setText(users.get(position).getNom());
        role.setText(users.get(position).getRole());

        btnDelete = (ImageButton) rowView.findViewById(R.id.button_delete);

        btnDelete.setImageResource(android.R.drawable.ic_delete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {
                                                alert(users.get(position));
                                            }
                                        });
        return rowView;
    }

    public void alert(final Utilisateur user){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle("Suppression d'utilisateur")
                .setMessage("Êtes-vous sûr de vouloir supprimer : "+user.getUserName()+" ? ")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        adminService.deleteUser(user.getRole(), user.getId());
                        context.startActivity(intent);
                        Toast toast = Toast.makeText(context, "L'utilisateur " + user.getUserName() + " est supprimé avec succes", Toast.LENGTH_SHORT);
                        toast.show();
                        ((Activity) context).finish();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
