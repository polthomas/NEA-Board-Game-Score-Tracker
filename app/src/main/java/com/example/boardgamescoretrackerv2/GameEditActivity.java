package com.example.boardgamescoretrackerv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class GameEditActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.gamelistsql.REPLY";

    private EditText mEditGameView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_edit);
        mEditGameView = findViewById(R.id.edit_game);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditGameView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String word = mEditGameView.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, word);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}