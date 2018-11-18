package com.example.ulugbek.frgroup;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class FireBase extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
