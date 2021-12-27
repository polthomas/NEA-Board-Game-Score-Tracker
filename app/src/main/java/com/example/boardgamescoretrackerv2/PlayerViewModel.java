package com.example.boardgamescoretrackerv2;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PlayerViewModel extends AndroidViewModel {

    private AppRepository appRepository;

    private final LiveData<List<Player>> mAllPlayers;

    public PlayerViewModel(Application application) {
        super(application);
        appRepository = new AppRepository(application);
        mAllPlayers = appRepository.getAllPlayers();
    }

    LiveData<List<Player>> getAllPlayers() { return mAllPlayers; }

    public void insert(Player player) { appRepository.insert(player); }
}
