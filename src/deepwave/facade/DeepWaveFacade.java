/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepwave.facade;

import deepwave.models.Album;
import deepwave.models.Artist;
import deepwave.models.Song;
import deepwave.tools.DataGenerator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author atphan
 */
public class DeepWaveFacade {

    public static String ARTISTS_FILE_PATH = "res/json/artists.json";
    public static String SONGS_FILE_PATH = "res/json/songs.json";
    public static String ALBUMS_FILE_PATH = "res/json/albums.json";

    private Set<Album> albums = new HashSet<>();
    private Set<Artist> artists = new HashSet<>();
    private Set<Song> songs = new HashSet<>();

    public DeepWaveFacade() {
        loadData();
    }

    private void loadData() {
        this.albums = DataGenerator.generateData();
        this.songs = albums.stream()
                .flatMap(a -> a.getSongs().stream())
                .collect(Collectors.toSet());
        this.artists = songs.stream()
                .map(s -> s.getSinger())
                .collect(Collectors.toSet());
    }

    public void setData(Set<Album> albums) {
        this.albums = albums;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public Album getAlbum(int id) {
        return albums.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public Artist getArtist(int id) {
        return artists.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public Song getSong(int id) {
        return songs.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    public Set<Album> dummyData() {
        return albums;
    }
}
