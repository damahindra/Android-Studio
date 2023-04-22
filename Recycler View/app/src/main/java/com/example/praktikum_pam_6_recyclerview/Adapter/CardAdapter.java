package com.example.praktikum_pam_6_recyclerview.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.praktikum_pam_6_recyclerview.Model.Card;
import com.example.praktikum_pam_6_recyclerview.ProfilePage;
import com.example.praktikum_pam_6_recyclerview.R;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
    ArrayList<Card> cards;
    Context context;
    public static class CardViewHolder extends RecyclerView.ViewHolder {

        TextView cardTitle, text;
        View icon_bg;
        ImageView cardImage, cardDelButton;
        CardAdapter vh_adapter;
        CardView card;
        String name, phoneNumber;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            cardTitle = itemView.findViewById(R.id.card_title);
            cardDelButton = itemView.findViewById(R.id.card_delBtn);
            cardImage = itemView.findViewById(R.id.card_image);
            text = itemView.findViewById(R.id.text);
            icon_bg = itemView.findViewById(R.id.icon_bg);
            card = itemView.findViewById(R.id.card);

            card.setOnClickListener(view -> {
                Intent profile = new Intent(view.getContext(), ProfilePage.class);
                profile.putExtra("username", name);
                profile.putExtra("phoneNumber", phoneNumber);
                view.getContext().startActivity(profile);
            });
            cardDelButton.setOnClickListener(view -> {
                vh_adapter.cards.remove(getAdapterPosition());
                vh_adapter.notifyItemRemoved(getAdapterPosition());
            });
        }
        public CardViewHolder linkAdapter(CardAdapter adapter) {
            this.vh_adapter = adapter;
            return this;
        }
        public TextView getCardTitle() {
            return cardTitle;
        }
        public ImageView getCardImage() {
            return cardImage;
        }
    }


    public CardAdapter(ArrayList<Card> cards, Context context) {
        this.cards = cards;
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cards, parent, false);
        return new CardViewHolder(v).linkAdapter(this);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.getCardTitle().setText(cards.get(position).getName());
        Glide.with(context).load(cards.get(position).getImage()).into(holder.getCardImage());
        holder.name = cards.get(position).getName();
        holder.phoneNumber = cards.get(position).getPhoneNumber();
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
}



