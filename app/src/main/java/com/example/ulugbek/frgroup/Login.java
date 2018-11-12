package com.example.ulugbek.frgroup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username, password;
    Button log;
    String pass, login;
    TextView reg;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = "fr";
        pass = "fr";

        username = (EditText) findViewById(R.id.logText);
        password = (EditText) findViewById(R.id.passText);
        log = (Button) findViewById(R.id.btn);
        reg = (TextView) findViewById(R.id.regTxt);

        username = (EditText) findViewById(R.id.logText);
        password = (EditText) findViewById(R.id.passText);
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
                if(username.getText().toString().equals(login) && password.getText().toString().equals(pass)) {
                    SharedPreferences sPref = getSharedPreferences("login",MODE_PRIVATE);
                    SharedPreferences.Editor ed = sPref.edit();
                    ed.putString("username", username.getText().toString());
                    ed.putString("password", password.getText().toString());
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



    }



}
