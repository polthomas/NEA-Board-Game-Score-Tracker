package com.example.boardgamescoretrackerv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GameEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_edit);
    }

    public void saveGameName(View view) {

        // Taking the value from the edit text field for the game name
        EditText gameNameInput=findViewById(R.id.gameNameInput);
        String gameName=gameNameInput.getText().toString();

        // This game now needs to be added to the database when the button is pressed

        // This code is triggered when the button is pressed
        Button addGameToDBButton=findViewById(R.id.addGameToDBButton);
        addGameToDBButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                // Add game to database


            }

        });

    }

}