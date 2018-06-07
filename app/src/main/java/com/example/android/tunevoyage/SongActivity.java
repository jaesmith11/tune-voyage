package com.example.android.tunevoyage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by James on 3/20/18.
 */

public class SongActivity extends AppCompatActivity {
    private SongAdapter adapter;
    private String decade;
    private String continent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_listview);

        // Create the complete list of songs
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song(getString(com.example.android.tunevoyage.R.string.b_Maal), getString(com.example.android.tunevoyage.R.string.boiro), getString(com.example.android.tunevoyage.R.string.fast), getString(com.example.android.tunevoyage.R.string.africa), getString(com.example.android.tunevoyage.R.string.toro), getString(com.example.android.tunevoyage.R.string.year_1992)));
        songs.add(new Song(getString(com.example.android.tunevoyage.R.string.e_Yeboah), getString(com.example.android.tunevoyage.R.string.ase), getString(com.example.android.tunevoyage.R.string.fast), getString(com.example.android.tunevoyage.R.string.africa), getString(com.example.android.tunevoyage.R.string.ase), getString(com.example.android.tunevoyage.R.string.year_1982)));
        songs.add(new Song(getString(com.example.android.tunevoyage.R.string.f_TP), getString(com.example.android.tunevoyage.R.string.serieux), getString(com.example.android.tunevoyage.R.string.weird), getString(com.example.android.tunevoyage.R.string.africa), getString(com.example.android.tunevoyage.R.string.nganda_macampagne), getString(com.example.android.tunevoyage.R.string.year_1973)));
        songs.add(new Song(getString(com.example.android.tunevoyage.R.string.l_Xianglan), getString(com.example.android.tunevoyage.R.string.samurai), getString(com.example.android.tunevoyage.R.string.slow), getString(com.example.android.tunevoyage.R.string.asia), getString(com.example.android.tunevoyage.R.string.unknown_album), getString(com.example.android.tunevoyage.R.string.year_1954)));
        songs.add(new Song(getString(com.example.android.tunevoyage.R.string.h_Bruhl), getString(com.example.android.tunevoyage.R.string.berlin), getString(com.example.android.tunevoyage.R.string.fast), getString(com.example.android.tunevoyage.R.string.europe), getString(com.example.android.tunevoyage.R.string.drifter), getString(com.example.android.tunevoyage.R.string.year_1969)));
        songs.add(new Song(getString(com.example.android.tunevoyage.R.string.l_Jordan), getString(com.example.android.tunevoyage.R.string.woman),getString(com.example.android.tunevoyage.R.string.fast), getString(com.example.android.tunevoyage.R.string.north_america), getString(com.example.android.tunevoyage.R.string.unknown_album), getString(com.example.android.tunevoyage.R.string.year_1940)));
        songs.add(new Song(getString(com.example.android.tunevoyage.R.string.s_Caldas), getString(com.example.android.tunevoyage.R.string.jurou), getString(com.example.android.tunevoyage.R.string.fast), getString(com.example.android.tunevoyage.R.string.south_america), getString(com.example.android.tunevoyage.R.string.unknown_album), getString(com.example.android.tunevoyage.R.string.year_1932)));
        songs.add(new Song(getString(com.example.android.tunevoyage.R.string.t_Turpin), getString(com.example.android.tunevoyage.R.string.rag), getString(com.example.android.tunevoyage.R.string.fast), getString(com.example.android.tunevoyage.R.string.north_america), getString(com.example.android.tunevoyage.R.string.ragtime), getString(com.example.android.tunevoyage.R.string.year_1903)));
        songs.add(new Song(getString(com.example.android.tunevoyage.R.string.dalbret), getString(com.example.android.tunevoyage.R.string.legionnaire), getString(com.example.android.tunevoyage.R.string.fast), getString(com.example.android.tunevoyage.R.string.europe), getString(com.example.android.tunevoyage.R.string.unknown_album), getString(com.example.android.tunevoyage.R.string.year_1911)));
        songs.add(new Song(getString(com.example.android.tunevoyage.R.string.e_Rivero), getString(com.example.android.tunevoyage.R.string.audacia), getString(com.example.android.tunevoyage.R.string.slow),  getString(com.example.android.tunevoyage.R.string.south_america), getString(com.example.android.tunevoyage.R.string.unknown_album), getString(com.example.android.tunevoyage.R.string.year_1926)));
        songs.add(new Song(getString(com.example.android.tunevoyage.R.string.w_Carter), getString(com.example.android.tunevoyage.R.string.yodel), getString(com.example.android.tunevoyage.R.string.weird), getString(com.example.android.tunevoyage.R.string.australia), getString(com.example.android.tunevoyage.R.string.lullaby_yodel), getString(com.example.android.tunevoyage.R.string.year_1934)));
        songs.add(new Song(getString(com.example.android.tunevoyage.R.string.t_Haidouks), getString(com.example.android.tunevoyage.R.string.sorrow), getString(com.example.android.tunevoyage.R.string.slow), getString(com.example.android.tunevoyage.R.string.europe), getString(com.example.android.tunevoyage.R.string.gypsies), getString(com.example.android.tunevoyage.R.string.year_2001)));
        songs.add(new Song(getString(com.example.android.tunevoyage.R.string.d_Antwoord), getString(com.example.android.tunevoyage.R.string.fire), getString(com.example.android.tunevoyage.R.string.weird), getString(com.example.android.tunevoyage.R.string.africa), getString(com.example.android.tunevoyage.R.string.tension), getString(com.example.android.tunevoyage.R.string.year_2012)));

        //Extract user input for decade and continent spinners from SearchActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            continent = (String) extras.get("Continent");
            decade = (String) extras.get("Decade");
        }

        //Create an arraylist of Songs to be filtered by user input
        ArrayList<Song> songsFiltered = new ArrayList<Song>();
        //Loop thru each song in the complete list to determine if it fits user input criteria
        for (Song track : songs) {
            String songContinent = track.getContinent();
            String songDecade = track.getReleaseDate();

            if (decade.equals("Any"))
                songDecade = "Any";
            else {
                int decadeNumber = Integer.parseInt(songDecade);
                if (decadeNumber >= 2010) {
                    songDecade = "NOW";
                } else if (decadeNumber >= 2000) {
                    songDecade = "2000s";
                } else if (decadeNumber >= 1990) {
                    songDecade = "1990s";
                } else if (decadeNumber >= 1980) {
                    songDecade = "1980s";
                } else if (decadeNumber >= 1970) {
                    songDecade = "1970s";
                } else if (decadeNumber >= 1960) {
                    songDecade = "1960s";
                } else if (decadeNumber >= 1950) {
                    songDecade = "1950s";
                } else if (decadeNumber >= 1940) {
                    songDecade = "1940s";
                } else if (decadeNumber >= 1930) {
                    songDecade = "1930s";
                } else if (decadeNumber >= 1920) {
                    songDecade = "1920s";
                } else if (decadeNumber >= 1910) {
                    songDecade = "1910s";
                } else
                    songDecade = "1900s";
            }

            //Add song to filtered list if decade and continent criteria are met
            if (((songDecade.equals("Any")) || (songDecade.contains(decade)))
                    && ((continent.equals("Any")) || (songContinent.contains(continent)))) {
                    songsFiltered.add(track);
            }
        }

        // Create a SongAdapter thru the above ArrayList of songs
        // SongAdapter knows how to create list items for each item in list
        adapter = new SongAdapter(this, songsFiltered);

        // Find the ListView object in the view hierarchy of the activity
        // list_view is the view ID of the ListView declared in the song_listview.xml file
        ListView listView = (ListView) findViewById(R.id.list_view);

        // Make the ListView use the SongAdapter to display list items for each Song in the list.
        listView.setAdapter(adapter);

        //Create an empty view to display "no results" message
        listView.setEmptyView(findViewById(android.R.id.empty));

        //Back button returns to SearchActivity screen with decade & continent spinners
        ImageView backButton = findViewById(R.id.back_from_list);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SongActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        //Set listener on each element in the list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Song currentSong = adapter.getItem(position);
                if (currentSong != null) {
                    String albumInfo = currentSong.getAlbumTitle();
                    String songTitleInfo = currentSong.getSongTitle();
                    String artistInfo = currentSong.getArtist();

                    Intent playIntent = new Intent(SongActivity.this, NowPlayingActivity.class);
                    playIntent.putExtra("Album", albumInfo);
                    playIntent.putExtra("Song", songTitleInfo);
                    playIntent.putExtra("Artist", artistInfo);
                    //Also include search criteria to preserve listview's data
                    playIntent.putExtra("Decade", decade);
                    playIntent.putExtra("Continent", continent);
                    startActivity(playIntent);
                }

            }
        });
    }
}
