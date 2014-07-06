/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import client.LyricsClient;
import hulyricsmodel.Artist;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Khafaga
 */
@ManagedBean
@RequestScoped
public class ArtistController {
    @ManagedProperty(value ="#{param.initial}")
    private String initial;
    private List<Artist> artists;

    public ArtistController() throws JAXBException  {
   
    }
    
    public void init() throws JAXBException {
       LyricsClient lyricsClient = new LyricsClient();
       artists =  lyricsClient.listArtistsByInitial(initial.toLowerCase()).getArtists();
       lyricsClient.close();
    }
    
//    public List<Artist> getArtists(String initial) throws JAXBException{
//       LyricsClient lyricsClient = new LyricsClient();
//        artists =  lyricsClient.listArtistsByInitial(initial);
//        return artists;
//    }

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
     * @return the initial
     */
    public String getInitial() {
        return initial;
    }

    /**
     * @param initial the initial to set
     */
    public void setInitial(String initial) {
        this.initial = initial;
    }
    
    

}
