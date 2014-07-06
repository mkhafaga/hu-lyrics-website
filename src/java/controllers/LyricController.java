/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import client.LyricsClient;
import hulyricsmodel.Lyric;
import hulyricsmodel.Song;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Khafaga
 */
@ManagedBean
@RequestScoped
public class LyricController {
    private Lyric lyric;
   // private Long songId;
      @ManagedProperty(value = "#{param.song}")
    private String song;
        @ManagedProperty(value = "#{param.artist}")
    private String artist;
    public void init(){
        LyricsClient client = new LyricsClient();
        try{
          //     lyric =   client.getLyricForASong(songId.toString());
            lyric =  client.getLyricBySongCriteria(getSong(), getArtist());
                   
   client.updateViews(""+lyric.getId(),""+(lyric.getViews()+1));

        }catch(Exception e){
        lyric = new Lyric();
        lyric.setWords("There is no Lyrics for this song , yet!");
        }
      //  Song currentSong = lyric.getSong();
   client.close();
    
    }

//    /**
//     * @return the songId
//     */
//    public Long getSongId() {
//        return songId;
//    }
//
//    /**
//     * @param songId the songId to set
//     */
//    public void setSongId(Long songId) {
//        this.songId = songId;
//    }

    /**
     * @return the lyric
     */
    public Lyric getLyric() {
        return lyric;
    }

    /**
     * @param lyric the lyric to set
     */
    public void setLyric(Lyric lyric) {
        this.lyric = lyric;
    }

    /**
     * @return the song
     */
    public String getSong() {
        return song;
    }

    /**
     * @param song the song to set
     */
    public void setSong(String song) {
        this.song = song;
    }

    /**
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @param artist the artist to set
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }
}
