/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import client.LyricsClient;
import hulyricsmodel.Lyric;
import hulyricsmodel.Song;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Khafaga
 */
@ManagedBean
@RequestScoped
public class TopHundredController {

    /**
     * Creates a new instance of TopHundredController
     */
       private List<Song> songs;
     public void init(){
        
        LyricsClient lyricsClient = new LyricsClient();
     songs = new ArrayList<Song>();
     List<Lyric> lyrics =  lyricsClient.getTopHundred().getLyrics();
     for(Lyric lyric : lyrics){
         Song currentSong = lyric.getSong();
    
     songs.add(currentSong);
     }
     
      //  setSongs(.getSongs());
       
    lyricsClient.close();
    }
    public TopHundredController() {
    }

    /**
     * @return the songs
     */
    public List<Song> getSongs() {
        return songs;
    }

    /**
     * @param songs the songs to set
     */
    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
