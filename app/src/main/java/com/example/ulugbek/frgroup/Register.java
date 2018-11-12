package com.example.ulugbek.frgroup;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if(edit_repassword.getText().toString().equals(edit_password.getText().toString())) {
                    role = "";
                    username = edit_username.getText().toString();
                    email = edit_email.getText().toString();
                    password = edit_password.getText().toString();
                }
                else{
                    edit_repassword.setTextColor(R.color.Red);
                    edit_password.setTextColor(R.color.Red);
                }
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
}
