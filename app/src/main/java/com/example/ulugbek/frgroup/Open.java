package com.example.ulugbek.frgroup;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.support.design.widget.NavigationView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;

import static android.R.id.message;

public class Open extends AppCompatActivity {

    MediaPlayer enterSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);


        enterSong = MediaPlayer.create(Open.this,R.raw.water);
        enterSong.start();
        Thread timer = new Thread() {
            public void run(){
                try{
                    sleep(4000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }finally{
                    SharedPreferences sPref = getPreferences(MODE_PRIVATE);
                    String username = sPref.getString("username","");

                    if(username.equals("fr")){

                        Intent openStartingPoint = new Intent(".MainActivity");
                        startActivity(openStartingPoint);
                    }
                    else{

                        Intent openStartingPoint = new Intent("com.ulugbek.frgroup.LOGIN");
                        startActivity(openStartingPoint);
                    }

                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        enterSong.release();
        finish();
    }


}
