package com.example.boardgamescoretrackerv2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

// This DAO provides ways to access the Player table in the database
// without having to write the full query every time.
@Dao
public interface PlayerDao {
    @Query("SELECT * FROM player")
    List<Game> getAll();
}
