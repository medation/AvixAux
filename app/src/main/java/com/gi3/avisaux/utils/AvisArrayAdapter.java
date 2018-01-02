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
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import com.gi3.avisaux.R;
import com.gi3.avisaux.domain.Avis;
import com.gi3.avisaux.domain.Utilisateur;
import com.gi3.avisaux.service.AdminService;

import java.util.List;

/**
 * Created by Med on 25/12/17.
 */

public class AvisArrayAdapter extends ArrayAdapter<Avis> {

    private final Context context;
    private List<Avis> avis;
    private boolean isAdmin = false;
    private boolean isStudent = false;
    private AdminService adminService = new AdminService();
    private Intent intent;

    public AvisArrayAdapter(Context context, List<Avis> avis, boolean isAdmin, boolean isStudent, Intent intent) {
        super(context, R.layout.list_avis, avis);
        this.context = context;
        this.avis = avis;
        this.isAdmin = isAdmin;
        this.isStudent = isStudent;
        this.intent = intent;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_avis, parent, false);

        TextView name = rowView.findViewById(R.id.name);
        TextView message = rowView.findViewById(R.id.message);
        TextView date = rowView.findViewById(R.id.date);

        name.setText(avis.get(position).getEnseignant());
        message.setText(avis.get(position).getMessage());
        date.setText(avis.get(position).getDate());


        if(isAdmin){
            ImageButton btnDelete = (ImageButton) rowView.findViewById(R.id.delete);
            btnDelete.setImageResource(android.R.drawable.ic_delete);
            btnDelete.setClickable(true);
            btnDelete.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    alert(avis.get(position));
                }
            });
        }
        if (!isStudent){
            TextView groupe = rowView.findViewById(R.id.groupe);
            TextView niveau = rowView.findViewById(R.id.niveau);
            TextView filiere = rowView.findViewById(R.id.filiere);
            groupe.setText(avis.get(position).getGroupe());
            niveau.setText(avis.get(position).getNiveau());
            filiere.setText(avis.get(position).getFiliere());
        }
        return rowView;
    }

    public void alert(final Avis avis){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle("Suppression d'utilisateur")
                .setMessage("Êtes-vous sûr de vouloir supprimer : "+avis.getMessage()+" du "+avis.getDate()+" ? ")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        adminService.deleteAvis(avis.getId());
                        context.startActivity(intent);
                        Toast toast = Toast.makeText(context, "L'avis du " + avis.getDate() + " est supprimé avec succes", Toast.LENGTH_SHORT);
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
