package com.example.boardgamescoretrackerv2;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.boardgamescoretrackerv2.Game;

import java.util.List;

//Copied from RoomWordSample

public class GameViewModel extends AndroidViewModel {

    private GameRepository gameRepository;

    private final LiveData<List<Game>> mAllGames;

    public GameViewModel (Application application) {
        super(application);
        gameRepository = new GameRepository(application);
        mAllGames = gameRepository.getAllGames();
    }

    LiveData<List<Game>> getAllGames() { return mAllGames; }

    public void insert(Game game) { gameRepository.insert(game); }
}