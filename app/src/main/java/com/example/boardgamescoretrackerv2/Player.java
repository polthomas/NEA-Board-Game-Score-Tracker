package com.example.boardgamescoretrackerv2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// The 'Player' table (entity) of the app's database is defined here.
@Entity
public class Player {
    @PrimaryKey
    public int playerId;

    @ColumnInfo(name = "player_name")
    public String playerName;
}
