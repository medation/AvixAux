package com.gi3.avisaux.utils;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Space;
import android.widget.TextView;

import com.gi3.avisaux.R;
import com.gi3.avisaux.domain.Avis;

import java.util.List;

/**
 * Created by Med on 25/12/17.
 */

public class AvisArrayAdapter extends ArrayAdapter<Avis> {

    private final Context context;
    private final List<Avis> avis;
    private boolean isAdmin = false;
    private boolean isStudent = false;

    public AvisArrayAdapter(Context context, List<Avis> avis, boolean isAdmin, boolean isStudent) {
        super(context, R.layout.list_avis, avis);
        this.context = context;
        this.avis = avis;
        this.isAdmin = isAdmin;
        this.isStudent = isStudent;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_avis, parent, false);

        TextView name = rowView.findViewById(R.id.name);
        TextView message = rowView.findViewById(R.id.message);
        TextView date = rowView.findViewById(R.id.date);

        name.setText(avis.get(position).getEnseignant());
        message.setText(avis.get(position).getMessage());
        date.setText(avis.get(position).getDate());

        ImageButton btnDoc = (ImageButton) rowView.findViewById(R.id.doc);
        btnDoc.setImageResource(R.drawable.doc48);

        if(isAdmin){
            ImageButton btnDelete = (ImageButton) rowView.findViewById(R.id.delete);
            btnDelete.setImageResource(android.R.drawable.ic_delete);
            btnDelete.setClickable(true);
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
}
