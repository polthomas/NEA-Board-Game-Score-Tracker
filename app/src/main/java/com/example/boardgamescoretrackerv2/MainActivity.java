package com.example.boardgamescoretrackerv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Making it notice when the log play button is clicked:
        Button logPlayButton = findViewById(R.id.logPlayButton);
        logPlayButton.setOnClickListener(new View.OnClickListener() {

            // Printing "Button Clicked" to Logcat when the button is pressed
            public void onClick(View v) {
                System.out.println("Button Clicked");

                // Making the log play button launch the play edit activity
                Intent playEditActIntent = new Intent(getApplicationContext(), PlayEditActivity.class);
                startActivity(playEditActIntent);
            }

        });

        // Making the 'add game' button launch the 'game edit' screen
        Button addGameButton = findViewById(R.id.addGameButton);
        addGameButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                // Launching the game edit activity
                Intent gameEditActIntent = new Intent(getApplicationContext(), GameEditActivity.class);
                startActivity(gameEditActIntent);
            }
        });
    }
}
