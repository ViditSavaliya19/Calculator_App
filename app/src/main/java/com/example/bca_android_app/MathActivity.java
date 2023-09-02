package com.example.bca_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        //ID Binding
        TextView txtAnswer = findViewById(R.id.txtAnswer);
        LinearLayout btnSeven = findViewById(R.id.btnSeven);
        LinearLayout btnEight = findViewById(R.id.btnEight);
        LinearLayout btnAC = findViewById(R.id.btnAC);
        LinearLayout btnPlus = findViewById(R.id.btnPlus);
        LinearLayout btnEqual = findViewById(R.id.btnEqual);
        LinearLayout btnMinus = findViewById(R.id.btnMinus);

        //CLICK
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = txtAnswer.getText().toString();
                txtAnswer.setText(data + "7");
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = txtAnswer.getText().toString();
                txtAnswer.setText(data + "8");
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtAnswer.setText("");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = txtAnswer.getText().toString();
                txtAnswer.setText(data + "+");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = txtAnswer.getText().toString();
                txtAnswer.setText(data + "-");

            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data = txtAnswer.getText().toString();
                // 7+8
                String first="",last="";
                int charIndex=0,i;

                for( i=0;i<data.length();i++)
                {
                    //77+8
                    if((data.charAt(i) >='0')  &&  (data.charAt(i) <='9'))
                    {
                        first= first+""+data.charAt(i);
                    }
                    else
                    {
                        charIndex=i;
                        break;
                    }
                }

                for(int j=i+1;j<data.length();j++)
                {
                    last=last+""+data.charAt(j);
                }

                if(data.charAt(charIndex)=='+')
                {
                    int sum = Integer.parseInt(first)+Integer.parseInt(last);
                    txtAnswer.setText(""+sum);
                }
                else  if(data.charAt(charIndex)=='-')
                {
                    int sum = Integer.parseInt(first)-Integer.parseInt(last);
                    txtAnswer.setText(""+sum);
                }

//                Toast.makeText(MathActivity.this, charIndex+"", Toast.LENGTH_SHORT).show();


                Log.e("TAG", "onClick: First ======== "+first);
                Log.e("TAG", "onClick: Last ======= "+last);
                Log.e("TAG", "onClick: Operation ======= "+data.charAt(charIndex));




            }
        });


    }
}



