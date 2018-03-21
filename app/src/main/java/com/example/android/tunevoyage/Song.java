package com.example.android.tunevoyage;

/**
 * Created by James on 3/20/18.
 */

public class Song {
    private String mArtist;
    private String mSongTitle;
    private String mMood;
    private String mContinent;
    private String mAlbumTitle;
    private String mReleaseDate;
   // private int mImageResID;

    public Song(String vArtist, String vSongTitle, String vMood, String vContinent, String vAlbumTitle, String vReleaseDate){
        mArtist = vArtist;
        mSongTitle = vSongTitle;
        mMood = vMood;
        mContinent = vContinent;
        mAlbumTitle = vAlbumTitle;
        mReleaseDate = vReleaseDate;
      //  mImageResID = vImageResID;
    }

    public String getArtist(){
        return mArtist;
    }
    public String getSongTitle(){
        return mSongTitle;
    }

    public String getMood() {
        return mMood;
    }

    public String getContinent() {
        return mContinent;
    }

    public String getAlbumTitle() {
        return mAlbumTitle;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }
}
