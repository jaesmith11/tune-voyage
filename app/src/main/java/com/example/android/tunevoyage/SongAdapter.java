package com.example.android.tunevoyage;

import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 3/20/18.
 */

public class SongAdapter extends ArrayAdapter<Song>{
    public SongAdapter(@NonNull Context context, @NonNull ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the Song object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView with the ID song_title
        TextView songTitle = (TextView)listItemView.findViewById(R.id.song_title_tview);
        // Populate TextView with appropriate item (@param mSongTitle) in songs array
        songTitle.setText(currentSong.getSongTitle());

        TextView artistName = (TextView)listItemView.findViewById(R.id.artist_name_tview);
        artistName.setText(currentSong.getArtist());

        TextView releaseDate = (TextView)listItemView.findViewById(R.id.release_date_tview);
        releaseDate.setText(currentSong.getReleaseDate());

        //TODO create method formatDecade and call it from here

        // Display elements from the songs array in a ListView
        return listItemView;
    }
}