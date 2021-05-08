package com.example.task81youtubeplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText videoURLEditText;
    Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up views
        videoURLEditText = findViewById(R.id.youtubeLinkEditText);
        playButton = findViewById(R.id.playButton);

    }

    public void playVideo(View view) {
        // Get URL from edit text
        String url = videoURLEditText.getText().toString();

        // Start Watch Video Activity
        Intent intent = new Intent(this, WatchVideoActivity.class);
        intent.putExtra(YouTubeConfig.URL_KEY, url);
        startActivity(intent);
    }
}