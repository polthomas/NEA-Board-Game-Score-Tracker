package com.example.boardgamescoretrackerv2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Here we are defining the database the app uses.
@Database(entities = {Game.class, Player.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract GameDao gameDao();
    public abstract PlayerDao playerDao();

    // Singleton is defined to stop multiple instances of the database existing at once.
    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    // Returns singleton and creates database when it's accessed for the first time
    static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "app_database")
                            .addCallback(sAppDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static AppDatabase.Callback sAppDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // Comment out this block to keep data through app restarts:
            databaseWriteExecutor.execute(() -> {
                // Populates the database in the background:
                GameDao gdao = INSTANCE.gameDao();
                gdao.deleteAll();
                PlayerDao pdao = INSTANCE.playerDao();
                pdao.deleteAll();

                Game game = new Game("Example game");
                gdao.insert(game);
                Player player = new Player("Example player");
                pdao.insert(player);
            });
        }
    };

}