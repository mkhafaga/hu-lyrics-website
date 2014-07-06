/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import client.LyricsClient;
import hulyricsmodel.Album;
import hulyricsmodel.Artist;
import hulyricsmodel.Song;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import mappers.WildResult;

/**
 *
 * @author Khafaga
 */
@ManagedBean
@RequestScoped
public class SearchController {
 
    private List<Artist> artists;
    private List<Song> songs;
    private List<Album> albums;
       @ManagedProperty(value = "#{param.q}")
private String q;
    /**
     * Creates a new instance of SearchController
     */
   // ArrayList<>
    public SearchController() {
    }

    /**
     * @return the q
     */
    public String getQ() {
        return q;
    }

    /**
     * @param q the q to set
     */
    public void setQ(String q) {
        this.q = q;
    }
    
    public void init(){
        LyricsClient client = new LyricsClient();
        WildResult wildResult =  client.search(q);
        setArtists(wildResult.getArtistsMapper().getArtists());
        setAlbums(wildResult.getAlbumsMapper().getAlbums());
        setSongs(wildResult.getSongsMapper().getSongs());
        client.close();
    }

    /**
     * @return the artists
     */
    public List<Artist> getArtists() {
        return artists;
    }

    /**
     * @param artists the artists to set
     */
    public void setArtists(List<Artist> artists) {
        this.artists = artists;
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
     * @return the albums
     */
    public List<Album> getAlbums() {
        return albums;
    }

    /**
     * @param albums the albums to set
     */
    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
