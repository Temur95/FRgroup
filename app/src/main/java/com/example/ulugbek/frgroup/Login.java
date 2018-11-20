package com.example.ulugbek.frgroup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText usernameField, passwordField;
    Button log;
    String pass, login;
    TextView reg;
    private ProgressDialog mProgressDialog;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mProgressDialog = new ProgressDialog(this);


        login = "fr";
        pass = "fr";

        mAuth = FirebaseAuth.getInstance();

        usernameField = (EditText) findViewById(R.id.logText);
        passwordField = (EditText) findViewById(R.id.passText);
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


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startSignIn();

            }
        });


        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() != null){

                    startActivity(new Intent(Login.this,MainActivity.class));
                    finish();
                }
            }
        };












        //        log.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                if(username.getText().toString().equals(login) && password.getText().toString().equals(pass)) {
//                    SharedPreferences sPref = getSharedPreferences("login",MODE_PRIVATE);
//                    SharedPreferences.Editor ed = sPref.edit();
//                    ed.putString("username", username.getText().toString());
//                    ed.putString("password", password.getText().toString());
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
//
//        reg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                   Intent move = new Intent("com.ulugbek.frgroup.REGISTER");
//                startActivity(move);
//            }
//        });
//        log.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                if(Login.this.username.getText().toString().equals(login) && password.getText().toString().equals(pass)) {
//                    SharedPreferences sPref = getPreferences(MODE_PRIVATE);
//                    SharedPreferences.Editor ed = sPref.edit();
//                    ed.putString("username", Login.this.username.getText().toString());
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


    }

    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthStateListener);
    }

    private void startSignIn(){

        String email = usernameField.getText().toString();
        String pass = passwordField.getText().toString();



        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)){

            Toast.makeText(Login.this,"Fields are empty",Toast.LENGTH_SHORT).show();

        }else {

            mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    mProgressDialog.setMessage("Loading...");
                    mProgressDialog.show();

                    if(!task.isSuccessful()){
                        Toast.makeText(Login.this,"Sign in Problem",Toast.LENGTH_SHORT).show();

                        mProgressDialog.dismiss();
                    }



                }
            });

            mProgressDialog.dismiss();
        }



    }


}
