package com.example.bca_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Id Binding
        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtPassword = findViewById(R.id.edtPassword);
        Button btnLogin =findViewById(R.id.btnLogin);
        RadioGroup rdGroup = findViewById(R.id.rdGroup);
        CheckBox chkSwim =findViewById(R.id.chkSwim);
        CheckBox chkGame =findViewById(R.id.chkGame);
        CheckBox chkRead =findViewById(R.id.chkRead);

        //Click
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String swim="";
                if(chkSwim.isChecked()) {
                    swim="Swimming";
                }
                else {
                    swim="";
                }
                String game="";
                if(chkGame.isChecked()) {
                    game ="Gaming";
                }
                else {
                    game="";
                }
                String read="";
                if(chkRead.isChecked()) {
                    read="Reading";
                }
                else {
                    read="";
                }

                int id = rdGroup.getCheckedRadioButtonId();
                String selected="";
                if(id == R.id.rdFlutter) {
                    selected="Flutter";
                }
                else if(id== R.id.rdAndroid) {
                    selected="Android";
                }
                else {
                    selected="Web";
                }

                String email =edtEmail.getText().toString();
                String password =edtPassword.getText().toString();

                if(email.isEmpty()  && password.isEmpty()) {
                    edtEmail.setError("Email");
                    edtPassword.setError("Password");
                    Toast.makeText(MainActivity.this,"Entre the Email & Password",Toast.LENGTH_LONG).show();
                }
                else if(email.isEmpty()) {
                    edtEmail.setError("Email");
                    Toast.makeText(MainActivity.this, "Enter the Email", Toast.LENGTH_SHORT).show();
                }
                else if(password.isEmpty()) {
                    edtPassword.setError("Password");
                    Toast.makeText(MainActivity.this, "Enter the Password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, email+"\n"+password+"\n"+selected+"\n"+read+""+game+""+swim, Toast.LENGTH_SHORT).show();



                }

            }
        });

    }
}