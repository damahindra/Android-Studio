package com.example.praktikum_pam_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ContactUs extends AppCompatActivity implements View.OnClickListener {

    Button phone, email, website;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.e_mail);
        website = findViewById(R.id.web);

        phone.setOnClickListener(this);
        email.setOnClickListener(this);
        website.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == phone.getId()) {
            Uri phone_number = Uri.parse("tel:081234567890");
            Intent call = new Intent(Intent.ACTION_DIAL, phone_number);
            startActivity(call);
        }
        else if (view.getId() == email.getId()) {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"mrhead@gmail.com"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contact us through email!");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Share anything with us!");
            startActivity(emailIntent);

        }
        else if (view.getId() == website.getId()) {
            Uri url = Uri.parse("http://www.mrhead.com");
            Intent search = new Intent(Intent.ACTION_VIEW, url);
            startActivity(search);
        }
    }
}