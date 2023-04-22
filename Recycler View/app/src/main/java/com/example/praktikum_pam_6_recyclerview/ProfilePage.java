package com.example.praktikum_pam_6_recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ProfilePage extends AppCompatActivity {
    TextView profile_name;
    Button callBtn;
    Intent data;
    String name, phoneNumber;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        profile_name = findViewById(R.id.profile_name);
        callBtn = findViewById(R.id.callBtn);
        data = getIntent();
        name = data.getStringExtra("username");
        phoneNumber = data.getStringExtra("phoneNumber");
        profile_name.setText(name + "!");
        callBtn.setText(phoneNumber);

        callBtn.setOnClickListener(view -> {
            Uri phone = Uri.parse("tel:" + callBtn.getText().toString());
            Intent call = new Intent(Intent.ACTION_DIAL, phone);
            startActivity(call);
        });

    }
}