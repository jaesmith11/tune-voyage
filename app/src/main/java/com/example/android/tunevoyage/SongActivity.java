package com.example.android.tunevoyage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by James on 3/20/18.
 */

public class SongActivity extends AppCompatActivity{
    private SongAdapter adapter;
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_listview);

        // Create a list of songs
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Baaba Maal", "Hamady Boiro", "Fast", "Africa", "Lam Toro", "1992"));
        songs.add(new Song("Elvis Yeboah & His Justice 7 Band", "Engu Manim Ase", "Fast", "Africa", "Engu Manim Ase", "1982"));
        songs.add(new Song("Franco & T.P. OK", "Où Est le Sérieux", "Weird", "Africa", "Nganda Macampagne", "1973"));
        songs.add(new Song("Li Xianglan", "Seven Samurai", "Slow", "Asia", "Unknown", "1954"));
        songs.add(new Song("Heidi Brühl", "Berlin", "Fast", "Europe", "The Drifter", "1969"));
        songs.add(new Song("Louis Jordan and His Tympany Five", "Ain't That Just Like A Woman", "Fast", "North America", "Unknown", "1940"));
        songs.add(new Song("Silvio Caldas", "E Ela Não Jurou", "Fast", "South America", "Unknown", "1932"));
        songs.add(new Song("Tom Turpin", "St Louis Rag", "Fast", "North America", "Piano-Roll Ragtime", "1903"));
        songs.add(new Song("Dalbret", "Le légionnaire", "Fast", "Europe", "Unknown", "1911"));
        songs.add(new Song("Edmundo Rivero", "Audacia", "Slow", "South America", "Unknown", "1926"));
        songs.add(new Song("Wilf Carter", "Lover's Lullaby Yodel", "Weird", "Australia", "Lover's Lullaby Yodel", "1934"));
        songs.add(new Song("Taraf de Haidouks", "Sorrow, Only My Sorrow", "Slow", "Europe", "Band of Gypsies", "2001"));
        songs.add(new Song("Die Antwoord", "Baby's On Fire", "Weird", "Africa", "Ten$ion", "2012"));

        // Create a SongAdapter thru the above ArrayList of songs
        // SongAdapter knows how to create list items for each item in list
        adapter = new SongAdapter(this, songs);

        // Find the ListView object in the view hierarchy of the activity
        // list_view is the view ID of the ListView declared in the song_listview.xml file
        ListView listView = (ListView)findViewById(R.id.list_view);

        // Make the ListView use the SongAdapter to display list items for each Song in the list.
        listView.setAdapter(adapter);

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
                    startActivity(playIntent);
                }


            }
        });
    }
}
