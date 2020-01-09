/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepwave.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author atphan
 */
public class Album extends AbstractMusicElement {

    private static int ID_COUNTER = 0;

    private String imageURL;
    private LocalDate datePublished = LocalDate.now();
    private Set<Song> songs = new HashSet<>();

    public Album() {
        this.id = ID_COUNTER;
        ID_COUNTER++;
    }

    public Album(String name, LocalDate datePublished) {
        this.id = ID_COUNTER;
        this.name = name;
        this.datePublished = datePublished;
        ID_COUNTER++;
    }

    public Album(String name, String imagePath, LocalDate datePublished, String description, Set<Song> songs) {
        this.id = ID_COUNTER;
        this.imageURL = imagePath;
        this.name = name;
        this.datePublished = datePublished;
        this.description = description;
        this.setSongs(songs);
        ID_COUNTER++;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        this.datePublished = datePublished;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
        this.songs.forEach(s -> s.setAlbum(this));
    }

}
