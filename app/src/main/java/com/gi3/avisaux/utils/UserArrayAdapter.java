package com.gi3.avisaux.utils;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.gi3.avisaux.R;
import com.gi3.avisaux.domain.Utilisateur;

import java.util.List;

/**
 * Created by Med on 25/12/17.
 */

public class UserArrayAdapter extends ArrayAdapter<Utilisateur> {

    private final Context context;
    private final List<Utilisateur> users;

    public UserArrayAdapter(Context context, List<Utilisateur> users) {
        super(context, R.layout.list_users, users);
        this.context = context;
        this.users = users;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_users, parent, false);

        TextView name = (TextView) rowView.findViewById(R.id.name);
        TextView lastName = (TextView) rowView.findViewById(R.id.last_name);

        name.setText(users.get(position).getPrenom());
        lastName.setText(users.get(position).getNom());

        ImageButton btnDelete = (ImageButton) rowView.findViewById(R.id.button_delete);

        btnDelete.setImageResource(android.R.drawable.ic_delete);
        return rowView;
    }
}
