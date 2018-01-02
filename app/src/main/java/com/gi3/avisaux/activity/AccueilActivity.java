package com.gi3.avisaux.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gi3.avisaux.R;
import com.gi3.avisaux.utils.NotificationUtils;

public class AccueilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = (TextView) findViewById(R.id.textAccueil);
        text.setText(R.string.app_description);
    }

    public void goLoginClick(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void sendNotification(View view){

        NotificationUtils mNotificationUtils = new NotificationUtils(this);
        Notification.Builder nb = mNotificationUtils.
                getAndroidChannelNotification("Oups","C'est une notification");

        mNotificationUtils.getManager().notify(1, nb.build());
        mNotificationUtils.getManager().notify(2, nb.build());
    }
}
