package com.example.mrhead;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText name, username, password;
    Button clear, save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        initialize
        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        clear = findViewById(R.id.clear);
        save = findViewById(R.id.save);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText("");
                username.setText("");
                password.setText("");
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAndContinue();
            }
        });
    }
    public void saveAndContinue() {
        Intent result = new Intent();
        result.putExtra("name", name.getText().toString());
        result.putExtra("username", username.getText().toString());
        result.putExtra("password", password.getText().toString());
        setResult(RESULT_OK, result);
        finish();
    }
}