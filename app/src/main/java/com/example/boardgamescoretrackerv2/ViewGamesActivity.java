package com.example.boardgamescoretrackerv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ViewGamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_games);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final GameListAdapter adapter = new GameListAdapter(new GameListAdapter.GameDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mGameViewModel = new ViewModelProvider(this).get(GameViewModel.class);

        mGameViewModel.getAllGames().observe(this, games -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(games);
        });

        FloatingActionButton fab = findViewById(R.id.addGameFab);
        fab.setOnClickListener( view -> {
            Intent intent = new Intent(ViewGamesActivity.this, GameEditActivity.class);
            startActivityForResult(intent, NEW_GAME_ACTIVITY_REQUEST_CODE);
        });
    }

    private GameViewModel mGameViewModel;

    public static final int NEW_GAME_ACTIVITY_REQUEST_CODE = 1;

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_GAME_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Game game = new Game(data.getStringExtra(GameEditActivity.EXTRA_REPLY));
            mGameViewModel.insert(game);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}