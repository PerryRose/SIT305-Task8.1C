package com.example.task81youtubeplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class WatchVideoActivity extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_video);

        // Set up player
        youTubePlayerView = findViewById(R.id.youtubePlayer);

        String url = "";

        // Get URL
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            url = extras.getString(YouTubeConfig.URL_KEY);
        }

        // Extract video ID from different kinds of URLs
        String[] substrings = url.split("/");
        substrings = substrings[substrings.length - 1].split("v=");
        substrings = substrings[substrings.length - 1].split("&t=");

        // Final URL
        final String finalUrl = substrings[0];

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                // Load Video
                youTubePlayer.loadVideo(finalUrl);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };

        // Initialise player
        youTubePlayerView.initialize(YouTubeConfig.getApiKey(), onInitializedListener);

    }
}