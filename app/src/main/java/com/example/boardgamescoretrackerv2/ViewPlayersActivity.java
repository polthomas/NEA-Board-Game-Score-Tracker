package com.example.boardgamescoretrackerv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ViewPlayersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_players);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final PlayerListAdapter adapter = new PlayerListAdapter(new PlayerListAdapter.PlayerDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAppViewModel = new ViewModelProvider(this).get(AppViewModel.class);

        mAppViewModel.getAllPlayers().observe(this, players -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(players);
        });

        FloatingActionButton fab = findViewById(R.id.addGameFab);
        fab.setOnClickListener( view -> {
            Intent intent = new Intent(ViewPlayersActivity.this, PlayerEditActivity.class);
            startActivityForResult(intent, NEW_PLAYER_ACTIVITY_REQUEST_CODE);
        });
    }

    private AppViewModel mAppViewModel;

    public static final int NEW_PLAYER_ACTIVITY_REQUEST_CODE = 1;

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_PLAYER_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Player player = new Player(data.getStringExtra(PlayerEditActivity.EXTRA_REPLY));
            mAppViewModel.insert(player);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}