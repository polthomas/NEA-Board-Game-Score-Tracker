package com.example.boardgamescoretrackerv2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

// This DAO provides ways to access the Game table in the database
// without having to write the full query every time.
@Dao
public interface GameDao {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Game game);

    @Query("DELETE FROM game_table")
    void deleteAll();

    @Query("SELECT * FROM game_table ORDER BY game ASC")
    LiveData<List<Game>> getAlphabetizedGames();

}