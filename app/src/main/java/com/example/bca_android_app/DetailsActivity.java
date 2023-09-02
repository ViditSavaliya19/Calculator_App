package com.example.bca_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //ID Binding
        Button btnSubmit = findViewById(R.id.btnSubmit);
        EditText edtName = findViewById(R.id.edtName);
        EditText edtSurname = findViewById(R.id.edtSurname);
        RadioGroup rgGender = findViewById(R.id.rgGender);
        CheckBox chkRead = findViewById(R.id.chkREAD1);
        CheckBox chkSwim = findViewById(R.id.chkSWIM1);
        CheckBox chkGame = findViewById(R.id.chkGAME1);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hobby = "";
                if (chkRead.isChecked()) {
                    hobby = hobby + "Read";
                }

                if (chkGame.isChecked()) {
                    hobby = hobby + "Game";
                }

                if (chkSwim.isChecked()) {
                    hobby = hobby + "Swim";
                }

                String name = edtName.getText().toString();
                String surname = edtSurname.getText().toString();

                int selectedId = rgGender.getCheckedRadioButtonId();
                String gender;
                if (selectedId == R.id.rdMale) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }

                if (name.isEmpty() && surname.isEmpty()) {
                    edtName.setError("Name");
                    edtSurname.setError("Surname");
                } else if (name.isEmpty()) {
                    edtName.setError("Name");
                } else if (surname.isEmpty()) {
                    edtSurname.setError("Surname");
                } else {
                    Toast.makeText(DetailsActivity.this, name + "\n" + surname + "\n" + gender + "\n" + hobby, Toast.LENGTH_SHORT).show();

                    Intent intent= new Intent(DetailsActivity.this,ProfileActivity.class);
                    startActivity(intent);

                }

            }
        });


    }
}