package com.example.ulugbek.frgroup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.Socket;

public class Login extends AppCompatActivity {
    EditText t1, t2;
    Button log;
    String pass, login;
    TextView reg;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        login = "fr";
//        pass = "fr";
//
//        t1 = (EditText) findViewById(R.id.logText);
//        t2 = (EditText) findViewById(R.id.passText);
//        log = (Button) findViewById(R.id.btn);
//        reg = (TextView) findViewById(R.id.regTxt);

<<<<<<< HEAD
        t1 = (EditText) findViewById(R.id.logText);
        t2 = (EditText) findViewById(R.id.passText);
        log = (Button) findViewById(R.id.btn);
        reg = (TextView) findViewById(R.id.regTxt);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent move = new Intent("com.ulugbek.frgroup.REGISTER");
                startActivity(move);
                finish();
            }
        });
        log.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(t1.getText().toString().equals(login) && t2.getText().toString().equals(pass)) {
                    SharedPreferences sPref = getSharedPreferences("login",MODE_PRIVATE);
                    SharedPreferences.Editor ed = sPref.edit();
                    ed.putString("username", t1.getText().toString());
                    ed.putString("password", t2.getText().toString());
                    ed.commit();
                    Intent move = new Intent("com.ulugbek.frgroup.MAINACTIVITY");
                    startActivity(move);
                    finish();

                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Error", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
=======
//        SharedPreferences sPref = getPreferences(MODE_PRIVATE);
//        String username = sPref.getString("username","");
//        if(username.equals("fr")){
//            Intent move = new Intent("com.ulugbek.frgroup.MAINACTIVITY");
//            startActivity(move);
//            finish();
//        }
//        reg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent move = new Intent("com.ulugbek.frgroup.REGISTER");
//                startActivity(move);
//            }
//        });
//        log.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                if(t1.getText().toString().equals(login) && t2.getText().toString().equals(pass)) {
//                    SharedPreferences sPref = getPreferences(MODE_PRIVATE);
//                    SharedPreferences.Editor ed = sPref.edit();
//                    ed.putString("username", t1.getText().toString());
//                    ed.commit();
//                    Intent move = new Intent("com.ulugbek.frgroup.MAINACTIVITY");
//                    startActivity(move);
//                    finish();
//
//                }
//                else
//                {
//                    Toast toast = Toast.makeText(getApplicationContext(),
//                            "Error", Toast.LENGTH_SHORT);
//                    toast.show();
//                }
//            }
//        });
>>>>>>> Spiders/master


    }



}
