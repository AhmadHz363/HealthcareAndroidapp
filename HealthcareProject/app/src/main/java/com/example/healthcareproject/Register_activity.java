package com.example.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register_activity extends AppCompatActivity {
    EditText edtUsername, edtUserPass, edtEmail, edtConfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtUsername = findViewById(R.id.editTextRegLoginUsername);
        edtEmail = findViewById(R.id.editTextLoginEmail);
        edtUserPass = findViewById(R.id.editTextRegLoginPassword);
        edtConfirm = findViewById(R.id.editTextRegConLoginPassword2);
        btn = findViewById(R.id.btnRegister);
        tv = findViewById(R.id.textViewRegister);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register_activity.this, Login_Activity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                String email = edtEmail.getText().toString();
                String password = edtUserPass.getText().toString();
                String confirmPass = edtConfirm.getText().toString();
                Database db = new Database(getApplicationContext(), "healthCare", null, 1);

                if (username.length() == 0 || password.length() == 0 || email.length() == 0 || confirmPass.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.compareTo(confirmPass) == 0) {
                        if (isValid(password)) {
                            db.register(username, email, password);
                            Toast.makeText(getApplicationContext(), "Record inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register_activity.this, Login_Activity.class));

                        } else {
                            Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters having letter,digit,and a symbol", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password and confrim password didn't match", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });


    }

    public static boolean isValid(String password) {
        int f1 = 0, f2 = 0, f3 = 0;

        if (password.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < password.length(); p++) {
                if (Character.isLetter(password.charAt(p))) {
                    f1 = 1;
                }
            }

            for (int r = 0; r < password.length(); r++) {
                if (Character.isDigit(password.charAt(r))) {
                    f2 = 1;
                }
            }

            for (int s = 0; s < password.length(); s++) {{
                    char c = password.charAt(s);
                    if (c >= 33 && c <= 46 || c == 64) {
                        f3 = 1;
                    }
                }
            }
        }

        if (f1 == 1 && f2 == 1 && f3 == 1) {
            return true;
        }

        return false;
    }
}