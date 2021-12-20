package com.example.boardgamescoretrackerv2;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

//Copied from RoomWordSample

public class AppViewModel extends AndroidViewModel {

    private AppRepository appRepository;

    private final LiveData<List<Game>> mAllGames;
    private final LiveData<List<Player>> mAllPlayers;

    public AppViewModel(Application application) {
        super(application);
        appRepository = new AppRepository(application);
        mAllGames = appRepository.getAllGames();
        mAllPlayers = appRepository.getAllPlayers();
    }

    LiveData<List<Game>> getAllGames() { return mAllGames; }
    LiveData<List<Player>> getAllPlayers() { return mAllPlayers; }

    public void insert(Game game) { appRepository.insert(game); }
    public void insert(Player player) { appRepository.insert(player); }
}