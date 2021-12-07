package com.example.boardgamescoretrackerv2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// The 'Play' table (entity) of the app's database is defined here.
@Entity
public class Play {
    @PrimaryKey
    public int playId;

    // This table needs to have gameId as a foreign key from the 'Game' table.
    // The game which is being added to the play needs to be already in the Game table
    // so that its gameId can be attached to the play.
    // So it would be easier to implement the button to add a game to the database first,
    // before implementing the button to record a new play.

 //   @ColumnInfo(name = "game_id")
 //   public String gameID;


}
