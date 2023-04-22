package com.example.praktikum_pam_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loginButton;
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_email = email.getText().toString();
                String user_pass = password.getText().toString();

                if (user_email.isEmpty() || user_pass.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Email or Password can't be empty!", Toast.LENGTH_SHORT).show();
                }
                else if (user_email.equals("ranggaandhito@gmail.com") && user_pass.equals("215150707111001")) {
                    Toast.makeText(MainActivity.this,"Login Success!", Toast.LENGTH_SHORT).show();
                    Intent main = new Intent(MainActivity.this, MrHead.class);
                    startActivity(main);
                }
                else {
                    Toast.makeText(MainActivity.this,"Sorry, can't find your account. Please try again :(", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}