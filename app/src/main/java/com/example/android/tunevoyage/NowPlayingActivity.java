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

        TextView playAlbum = findViewById(R.id.current_album_view);
        TextView playArtist = findViewById(R.id.current_artist_view);
        TextView playSong = findViewById(R.id.current_song_view);
        ImageView backButton = findViewById(R.id.back_from_nowplaying);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NowPlayingActivity.this, SongActivity.class);
                startActivity(intent);
            }
        });

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
