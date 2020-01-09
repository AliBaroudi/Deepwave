/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepwave.models;

import java.time.LocalDate;

/**
 *
 * @author atphan
 */
public class Song extends AbstractMusicElement {

    private static int ID_COUNTER = 0;

    private Artist singer;
    private Artist composer;
    private String path;
    private Album album;
    private LocalDate puslishedDate = LocalDate.now();

    public Song() {
        this.id = ID_COUNTER;
        ID_COUNTER++;
    }

    /**
     * Constructor with singer is different from composer
     *
     * @param name
     * @param singer
     * @param composer
     * @param description
     */
    public Song(String name, Artist singer, Artist composer, String description) {
        this.id = ID_COUNTER;
        this.name = name;
        this.singer = singer;
        this.composer = composer;
        this.description = description;
        ID_COUNTER++;
    }

    /**
     * Constructor with singer is also composer
     *
     * @param name
     * @param artist
     * @param description
     */
    public Song(String name, Artist artist, String description) {
        this.id = ID_COUNTER;
        this.name = name;
        this.singer = artist;
        this.composer = artist;
        this.description = description;
        ID_COUNTER++;
    }

    public Artist getSinger() {
        return singer;
    }

    public void setSinger(Artist singer) {
        this.singer = singer;
    }

    public Artist getComposer() {
        return composer;
    }

    public void setComposer(Artist composer) {
        this.composer = composer;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDate getPuslishedDate() {
        return puslishedDate;
    }

    public void setPuslishedDate(LocalDate puslishedDate) {
        this.puslishedDate = puslishedDate;
    }

}
