package com.example.praktikum_pam_6_recyclerview;


import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.praktikum_pam_6_recyclerview.Adapter.CardAdapter;
import com.example.praktikum_pam_6_recyclerview.Model.Card;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    CardAdapter adapter;
    Button addBtn;
    ArrayList<Card> cards = new ArrayList<>();
    int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5};

//    result launcher
    Intent resData;
    ActivityResultLauncher<Intent> resultLauncher;
    String tempName, tempPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                resData = result.getData();
                if (resData != null) {
                    tempName = resData.getStringExtra("name");
                    tempPhone = resData.getStringExtra("phoneNumber");
                    addData();
                    adapter.notifyItemInserted(cards.size()-1);
                }
            }
        });
        recyclerView = findViewById(R.id.recyclerView);
        addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(this);
        loadData();
        initRecyclerView();
    }
    private void initRecyclerView() {
        adapter = new CardAdapter(cards, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void addData() {
        Random random = new Random();
        int idx_img = random.nextInt(5);
        cards.add(new Card(tempName, images[idx_img], tempPhone));
    }
    private void loadData() {
        cards = new ArrayList<>();
        cards.add(new Card("Tristan", images[0], "+628123456789"));
        cards.add(new Card("Chris", images[1], "+628123456788"));
        cards.add(new Card("Jessica", images[2], "+628123456787"));
        cards.add(new Card("Tom", images[3], "+628123456786"));
        cards.add(new Card("Robert", images[4], "+628123456785"));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == addBtn.getId()) {
            Intent input = new Intent(this, InputCard.class);
            resultLauncher.launch(input);
        }
    }
}