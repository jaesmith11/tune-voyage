package com.example.android.tunevoyage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by James on 3/21/18.
 */

public class NowPlayingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        //Find the appropriate TextViews in the now_playing.xml file
        TextView playAlbum = findViewById(R.id.current_album_view);
        TextView playArtist = findViewById(R.id.current_artist_view);
        TextView playSong = findViewById(R.id.current_song_view);

        //Find the ImageView in the now_playing.xml file to control navigation
        ImageView backButton = findViewById(R.id.back_from_nowplaying);

        //Implement an OnClickListener to navigate back to the SongActivity.class
        //This click will open the user's playlist
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NowPlayingActivity.this, SongActivity.class);
                startActivity(intent);
            }
        });

        //Find the extra information on Album, Artist, and Song that was sent from the SongActivity.java intent
        //These Strings will populate the above TextViews to display information on the current song
        Bundle extras = getIntent().getExtras();

        if(extras!=null){
            String album = (String) extras.get("Album");
            playAlbum.setText(album);

            String artist = (String) extras.get("Artist");
            playArtist.setText(artist);

            String song = (String) extras.get("Song");
            playSong.setText(song);
        }

    }
}
