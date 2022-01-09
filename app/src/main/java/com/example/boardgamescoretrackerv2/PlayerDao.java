package com.example.boardgamescoretrackerv2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

// This DAO provides ways to access the Player table in the database
// without having to write the full query every time.
@Dao
public interface PlayerDao {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Player player);

    @Query("DELETE FROM player_table")
    void deleteAll();

    @Query("SELECT * FROM player_table ORDER BY playerName ASC")
    LiveData<List<Player>> getAlphabetizedPlayers();

}
