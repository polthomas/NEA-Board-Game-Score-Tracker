package com.example.boardgamescoretrackerv2;

import androidx.room.Database;
import androidx.room.RoomDatabase;

// Here we are defining the database the app uses.
@Database(entities = {Game.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract GameDao gameDao();

}