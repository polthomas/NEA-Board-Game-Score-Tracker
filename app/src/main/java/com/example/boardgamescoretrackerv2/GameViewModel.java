package com.example.boardgamescoretrackerv2;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class GameViewModel extends AndroidViewModel {

    private AppRepository appRepository;

    private final LiveData<List<Game>> mAllGames;

    public GameViewModel(Application application) {
        super(application);
        appRepository = new AppRepository(application);
        mAllGames = appRepository.getAllGames();
    }

    LiveData<List<Game>> getAllGames() { return mAllGames; }

    public void insert(Game game) { appRepository.insert(game); }
}
