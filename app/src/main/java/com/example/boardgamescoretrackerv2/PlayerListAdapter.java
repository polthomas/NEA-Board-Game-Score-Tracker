package com.example.boardgamescoretrackerv2;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class PlayerListAdapter extends ListAdapter<Player, PlayerViewHolder> {

    public PlayerListAdapter(@NonNull DiffUtil.ItemCallback<Game> diffCallback) {
        super(diffCallback);
    }

    @Override
    public PlayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return PlayerViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(PlayerViewHolder holder, int position) {
        Player current = getItem(position);
        holder.bind(current.getPlayerName());
    }

    static class PlayerDiff extends DiffUtil.ItemCallback<Player> {

        @Override
        public boolean areItemsTheSame(@NonNull Player oldItem, @NonNull Player newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Player oldItem, @NonNull Player newItem) {
            return oldItem.getPlayerName().equals(newItem.getPlayerName());
        }
    }
}