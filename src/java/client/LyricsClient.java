/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import hulyricsmodel.Lyric;
import hulyricsmodel.Song;
import mappers.ArtistsMapper;
import mappers.LyricsMapper;
import mappers.SongsMapper;
import mappers.WildResult;

/**
 * Jersey REST client generated for REST resource:Service [service]<br>
 * USAGE:
 * <pre>
 *        LyricsClient client = new LyricsClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Khafaga
 */
public class LyricsClient {

    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/LyricsService/webresources";

    public LyricsClient() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("service");
    }

    public SongsMapper listSongsByArtist(String artist) throws UniformInterfaceException {
        WebResource resource = webResource;
        if (artist != null) {
            resource = resource.queryParam("artist", artist);
        }
        resource = resource.path("listSongsByArtist");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_XML).get(SongsMapper.class);
    }

    public ArtistsMapper listArtistsByInitial(String initial) throws UniformInterfaceException {
        WebResource resource = webResource;
        if (initial != null) {
            resource = resource.queryParam("initial", initial);
        }
        resource = resource.path("listArtistsByInitial");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_XML).get(ArtistsMapper.class);
    }

    public Lyric getLyricForASong(String songId) throws UniformInterfaceException {
        WebResource resource = webResource;
        if (songId != null) {
            resource = resource.queryParam("songId", songId);
        }
        resource = resource.path("getLyricForSong");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_XML).get(Lyric.class);
    }

    public LyricsMapper getTopHundred() throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path("getTopHundred");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_XML).get(LyricsMapper.class);
    }

    public WildResult search(String q) throws UniformInterfaceException {
        WebResource resource = webResource;
        if (q != null) {
            resource = resource.queryParam("q", q);
        }
        resource = resource.path("search");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_XML).get(WildResult.class);
    }

    public void updateSong(Song song) throws UniformInterfaceException {
        webResource.path("updateSong").type(javax.ws.rs.core.MediaType.APPLICATION_XML).post(song);
    }

    public String updateViews(String id, String views) throws UniformInterfaceException {
        WebResource resource = webResource;
        if (id != null) {
            resource = resource.queryParam("id", id);
        }
        if (views != null) {
            resource = resource.queryParam("views", views);
        }
        resource = resource.path("updateViews");
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public Lyric getLyricOfTheDay() throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path("getLyricOfTheDay");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_XML).get(Lyric.class);
    }
        public String getLyricsCount() throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path("getLyricsCount");
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }
        
        
          public SongsMapper  listSongsByAlbum( String albumId) throws UniformInterfaceException {
        WebResource resource = webResource;
        if (albumId != null) {
            resource = resource.queryParam("albumId", albumId);
        }
        resource = resource.path("listSongsByAlbum");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_XML).get(SongsMapper.class);
    }
          
            public Lyric getLyricBySongCriteria( String title, String artistName) throws UniformInterfaceException {
        WebResource resource = webResource;
        if (title != null) {
            resource = resource.queryParam("title", title);
        }
        if (artistName != null) {
            resource = resource.queryParam("artistName", artistName);
        }
        resource = resource.path("getLyricBySongCriteria");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_XML).get(Lyric.class);
    }

    public void close() {
        client.destroy();
    }
}
