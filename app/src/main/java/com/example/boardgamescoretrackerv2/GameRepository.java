package com.example.boardgamescoretrackerv2;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Database;

import java.util.List;

// Copied from RoomWordSample

class GameRepository {

    private GameDao mGameDao;
    private LiveData<List<Game>> mAllGames;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    GameRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mGameDao = db.gameDao();
        mAllGames = mGameDao.getAlphabetizedGames();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Game>> getAllGames() {
        return mAllGames;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Game game) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mGameDao.insert(game);
        });
    }
}
