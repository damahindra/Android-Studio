package com.example.mrhead;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button login, register;
    String tempUsername, tempPassword;
    Intent regData;
    ActivityResultLauncher<Intent> intentLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        initialize

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        intentLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            regData = result.getData();
                            if (regData != null) {
                                tempUsername = regData.getStringExtra("username");
                                tempPassword = regData.getStringExtra("password");
                            }
                    }
                }
    });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(Login.this, Register.class);
                intentLauncher.launch(register);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals(tempUsername) && password.getText().toString().equals(tempPassword)) {
                    username.setText("");
                    password.setText("");
                    Intent main = new Intent(Login.this, MainActivity.class);
                    startActivity(main);
                }
                else {
                    Toast.makeText(Login.this, "Account not Found, please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}