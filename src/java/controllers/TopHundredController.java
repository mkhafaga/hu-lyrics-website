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
import mappers.TopHundredItem;
import org.hibernate.Hibernate;

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
    private List<TopHundredItem> topHundredItems;

    public void init() {

        LyricsClient lyricsClient = new LyricsClient();
//        songs = new ArrayList<Song>();
        System.out.println(lyricsClient.getTopHundred().getTopHundredItems());
        System.out.println("it comes here , I guess");
        setTopHundredItems(lyricsClient.getTopHundred().getTopHundredItems());
//        for (TopHundredItem topHundredItem : topHundredItems) {
//            Song currentSong = lyric.getSong();
//          
//            System.out.println(currentSong.getArtist().getArtistName());
//            songs.add(currentSong);
//        }

        //  setSongs(.getSongs());

        lyricsClient.close();
    }

    public TopHundredController() {
    }

//    /**
//     * @return the songs
//     */
//    public List<Song> getSongs() {
//        return songs;
//    }
//
//    /**
//     * @param songs the songs to set
//     */
//    public void setSongs(List<Song> songs) {
//        this.songs = songs;
//    }

    /**
     * @return the topHundredItems
     */
    public List<TopHundredItem> getTopHundredItems() {
        return topHundredItems;
    }

    /**
     * @param topHundredItems the topHundredItems to set
     */
    public void setTopHundredItems(List<TopHundredItem> topHundredItems) {
        this.topHundredItems = topHundredItems;
    }
}
