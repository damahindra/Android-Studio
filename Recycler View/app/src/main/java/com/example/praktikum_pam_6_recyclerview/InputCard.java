package com.example.praktikum_pam_6_recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputCard extends AppCompatActivity {

    EditText inputName, phoneNumber;
    Button saveBtn;
    TextView greetTxt, greetTxt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_card);
        greetTxt = findViewById(R.id.greetTxt);
        greetTxt2 = findViewById(R.id.greetTxt2);
        inputName = findViewById(R.id.inputName);
        phoneNumber = findViewById(R.id.phoneNumber);
        saveBtn = findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(view -> {
            Intent result = new Intent();
            result.putExtra("name", inputName.getText().toString());
            result.putExtra("phoneNumber", phoneNumber.getText().toString());
            setResult(RESULT_OK, result);
            finish();
        });
    }
}