package com.example.boardgamescoretrackerv2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

//Copied from RoomWordSample

class GameViewHolder extends RecyclerView.ViewHolder {
    private final TextView gameItemView;

    private GameViewHolder(View itemView) {
        super(itemView);
        gameItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text) {
        gameItemView.setText(text);
    }

    static GameViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new GameViewHolder(view);
    }
}