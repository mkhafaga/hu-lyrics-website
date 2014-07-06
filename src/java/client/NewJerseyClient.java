/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

/**
 * Jersey REST client generated for REST resource:Service [service]<br>
 * USAGE:
 * <pre>
 *        NewJerseyClient client = new NewJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Khafaga
 */
public class NewJerseyClient {
    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/LyricsService/webresources";

    public NewJerseyClient() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("service");
    }

    public <T> T getLyricForASong(Class<T> responseType, String songId) throws UniformInterfaceException {
        WebResource resource = webResource;
        if (songId != null) {
            resource = resource.queryParam("songId", songId);
        }
        resource = resource.path("getLyricForSong");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    public <T> T getTopHundred(Class<T> responseType) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path("getTopHundred");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    public <T> T search(Class<T> responseType, String q) throws UniformInterfaceException {
        WebResource resource = webResource;
        if (q != null) {
            resource = resource.queryParam("q", q);
        }
        resource = resource.path("search");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    public <T> T listSongsByArtist(Class<T> responseType, String artist) throws UniformInterfaceException {
        WebResource resource = webResource;
        if (artist != null) {
            resource = resource.queryParam("artist", artist);
        }
        resource = resource.path("listSongsByArtist");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    public <T> T listArtistsByInitial(Class<T> responseType, String initial) throws UniformInterfaceException {
        WebResource resource = webResource;
        if (initial != null) {
            resource = resource.queryParam("initial", initial);
        }
        resource = resource.path("listArtistsByInitial");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    public <T> T getLyricOfTheDay(Class<T> responseType) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path("getLyricOfTheDay");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    public <T> T updateViews(Class<T> responseType, String id, String views) throws UniformInterfaceException {
        WebResource resource = webResource;
        if (id != null) {
            resource = resource.queryParam("id", id);
        }
        if (views != null) {
            resource = resource.queryParam("views", views);
        }
        resource = resource.path("updateViews");
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getLyricBySongCriteria(Class<T> responseType, String title, String artistName) throws UniformInterfaceException {
        WebResource resource = webResource;
        if (title != null) {
            resource = resource.queryParam("title", title);
        }
        if (artistName != null) {
            resource = resource.queryParam("artistName", artistName);
        }
        resource = resource.path("getLyricBySongCriteria");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    public <T> T listSongsByAlbum(Class<T> responseType, String albumId) throws UniformInterfaceException {
        WebResource resource = webResource;
        if (albumId != null) {
            resource = resource.queryParam("albumId", albumId);
        }
        resource = resource.path("listSongsByAlbum");
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_XML).get(responseType);
    }

    public <T> T getLyricsCount(Class<T> responseType) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path("getLyricsCount");
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.destroy();
    }
    
}
