/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import client.LyricsClient;
import daos.ArtistDao;
import hulyricsmodel.Artist;
import hulyricsmodel.Song;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Khafaga
 */
@ManagedBean
@RequestScoped
public class SongController {
    @ManagedProperty(value = "#{param.artistName}")
    private String artistName;
    
    @ManagedProperty(value = "#{param.albumId}")
    private Long albumId;
    
    private List<Song> songs;
    
    public void init(){
        LyricsClient lyricsClient = new LyricsClient();
     if(artistName!=null)
        setSongs(lyricsClient.listSongsByArtist(artistName).getSongs());
     else
        setSongs( lyricsClient.listSongsByAlbum(""+albumId).getSongs());
    
  lyricsClient.close();
    }

    /**
     * @return the artistName
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * @param artistName the artistName to set
     */
    public void setArtistName(String artistName) {
        this.artistName = artistName;
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

    /**
     * @return the albumId
     */
    public Long getAlbumId() {
        return albumId;
    }

    /**
     * @param albumId the albumId to set
     */
    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

   

 
    
}
