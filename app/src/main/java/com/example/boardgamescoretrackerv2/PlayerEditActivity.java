package com.example.boardgamescoretrackerv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class PlayerEditActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.gamelistsql.REPLY";

    private EditText mEditPlayerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_edit);
        mEditPlayerView = findViewById(R.id.edit_player);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditPlayerView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String word = mEditPlayerView.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, word);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}