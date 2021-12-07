package com.example.boardgamescoretrackerv2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

// This DAO provides ways to access the Game table in the database
// without having to write the full query every time.
@Dao
public interface GameDao {

    // This may not work. Trying to work out how to insert game to database 03-06/12/21
    @Insert(entity = Game.class)
    public void insertGame(Game game);

}