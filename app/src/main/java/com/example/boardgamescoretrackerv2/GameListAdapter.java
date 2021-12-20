package com.example.boardgamescoretrackerv2;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class GameListAdapter extends ListAdapter<Game, GameViewHolder> {

    public GameListAdapter(@NonNull DiffUtil.ItemCallback<Game> diffCallback) {
        super(diffCallback);
    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return GameViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(GameViewHolder holder, int position) {
        Game current = getItem(position);
        holder.bind(current.getGameName());
    }

    static class GameDiff extends DiffUtil.ItemCallback<Game> {

        @Override
        public boolean areItemsTheSame(@NonNull Game oldItem, @NonNull Game newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Game oldItem, @NonNull Game newItem) {
            return oldItem.getGameName().equals(newItem.getGameName());
        }
    }
}
