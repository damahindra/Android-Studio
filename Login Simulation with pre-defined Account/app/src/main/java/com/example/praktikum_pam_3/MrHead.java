package com.example.praktikum_pam_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MrHead extends AppCompatActivity implements View.OnClickListener {

    CheckBox checkbox_hair, checkbox_eyebrows, checkbox_mustache, checkbox_beard;
    ImageView hair, eyebrows, mustache, beard;
    Button contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mr_head);
        checkbox_hair = (CheckBox) findViewById(R.id.checkBox_hair);
        checkbox_hair.setOnClickListener(this);

        checkbox_eyebrows = (CheckBox) findViewById(R.id.checkBox_eyebrows);
        checkbox_eyebrows.setOnClickListener(this);

        checkbox_mustache = (CheckBox) findViewById(R.id.checkBox_mustache);
        checkbox_mustache.setOnClickListener(this);

        checkbox_beard = (CheckBox) findViewById(R.id.checkBox_beard);
        checkbox_beard.setOnClickListener(this);

        hair = (ImageView) findViewById(R.id.hair);
        eyebrows = (ImageView) findViewById(R.id.eyebrows);
        mustache = (ImageView) findViewById(R.id.mustache);
        beard = (ImageView) findViewById(R.id.beard);

//        contact us
        contact = findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent contact = new Intent(MrHead.this, ContactUs.class);
                startActivity(contact);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.checkBox_hair:
                if (checkbox_hair.isChecked()) {
                    hair.setVisibility(View.VISIBLE);
                } else {
                    hair.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.checkBox_eyebrows:
                if (checkbox_eyebrows.isChecked()) {
                    eyebrows.setVisibility(View.VISIBLE);
                } else {
                    eyebrows.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.checkBox_mustache:
                if (checkbox_mustache.isChecked()) {
                    mustache.setVisibility(View.VISIBLE);
                } else {
                    mustache.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.checkBox_beard:
                if (checkbox_beard.isChecked()) {
                    beard.setVisibility(View.VISIBLE);
                } else {
                    beard.setVisibility(View.INVISIBLE);
                }
                break;
        }
    }
}