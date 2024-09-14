package com.example.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {
    EditText edtUsername, edtUserPass;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername= findViewById(R.id.editTextLoginEmail);
        edtUserPass= findViewById(R.id.editTextRegLoginPassword);
        btn= findViewById(R.id.btnRegister);
        tv= findViewById(R.id.textViewRegister);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username= edtUsername.getText().toString();
                String password= edtUserPass.getText().toString();
                Database db= new Database(getApplicationContext(),"healthCare",null,1);


                if(username.length() ==0 || password.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Please fill all details",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(db.login(username,password)==1)
                    {
                        Toast.makeText(getApplicationContext(),"Login Successfuly",Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences= getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.putString("username",username);
                        //to save our data with key and value
                        editor.apply();
                        startActivity(new Intent(Login_Activity.this,Home_activity.class));
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Invalid username or password",Toast.LENGTH_SHORT).show();
                    }

                }
           }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Activity.this,Register_activity.class));
            }
        });

    }
}