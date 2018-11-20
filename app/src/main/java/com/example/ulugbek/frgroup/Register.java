package com.example.ulugbek.frgroup;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private String role;
    private String username;
    private String email;
    private String password;

    private EditText edit_username;
    private EditText edit_email;
    private EditText edit_password;
    private EditText edit_repassword;
    private RadioGroup radio_role;
    private RadioButton radio_seller;
    private RadioButton radio_customer;
    private Button registerBtn;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mDatabaseRef;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mDialog = new ProgressDialog(this);
        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("Users");

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {



            }
        };


        init();
        registerBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                    role = "";
                    username = edit_username.getText().toString();
                    email = edit_email.getText().toString();
                    password = edit_password.getText().toString();

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent go = new Intent(Register.this, Login.class);
        startActivity(go);
    }

    public void init(){
        edit_username = findViewById(R.id.name);
        edit_email = findViewById(R.id.email);
        edit_password = findViewById(R.id.pass);
        edit_repassword = findViewById(R.id.repass);
        radio_role = findViewById(R.id.radioGroup);
        radio_customer = findViewById(R.id.customer_radio);
        radio_seller = findViewById(R.id.seller__radio);
        registerBtn = findViewById(R.id.register_button);

    }

    private void startRegister(){

        final String username = edit_username.getText().toString().trim();
        String email = edit_email.getText().toString().trim();
        String password = edit_password.getText().toString().trim();
        String rePassword = edit_repassword.getText().toString().trim();

        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(rePassword)){

            mDialog.setMessage("Signing Up....");
            mDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){




                            String user_id = mAuth.getCurrentUser().getUid();
                            DatabaseReference current_user_db = mDatabaseRef.child(user_id);
                            current_user_db.child("name").setValue(username);

                            mDialog.dismiss();

                            Intent intent = new Intent(Register.this,Login.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);

                        }


                }
            });
        }
    }
}
