/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import client.LyricsClient;
import hulyricsmodel.Lyric;
import hulyricsmodel.Song;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.component.commandlink.CommandLink;

/**
 *
 * @author Khafaga
 */
@ManagedBean
@RequestScoped
public class IndexController {
    private String lyricsCount;
    private Lyric lyricOfTheDay;
   

    public IndexController() {
    }

    /**
     * Creates a new instance of IndexController
     */
public void init(){
    LyricsClient lyricsClient = new LyricsClient();
        setLyricsCount(lyricsClient.getLyricsCount());
         setLyricOfTheDay(lyricsClient.getLyricOfTheDay());
         lyricsClient.close();
//        System.out.println("song name : "+songOfTheDay.getTitle());
//         System.out.println(songOfTheDay.getLyrics());
//        System.out.println(new ArrayList<Lyric>(songOfTheDay.getLyrics()).get(0).getWords());
//   songOFTheDay =  
//            lyricsClient.getSongOfTheDay().getLyrics().toArray(new Lyric[1])[0].getWords();
    
}

    /**
     * @return the lyricsCount
     */
    public String getLyricsCount() {
        return lyricsCount;
    }

    /**
     * @param lyricsCount the lyricsCount to set
     */
    public void setLyricsCount(String lyricsCount) {
        this.lyricsCount = lyricsCount;
    }

   
    /**
     * @return the lyricOfTheDay
     */
    public Lyric getLyricOfTheDay() {
        return lyricOfTheDay;
    }

    /**
     * @param lyricOfTheDay the lyricOfTheDay to set
     */
    public void setLyricOfTheDay(Lyric lyricOfTheDay) {
        this.lyricOfTheDay = lyricOfTheDay;
    }

  
}
