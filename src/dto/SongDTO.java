/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import deepwave.models.Song;
import java.time.LocalDate;

/**
 *
 * @author thibaultphan
 */
public class SongDTO {

    private int id;
    private String name;
    private String artistName;
    private int artistId;
    private String albumName;
    private int albumId;
    private LocalDate publishDate;

    public SongDTO(Song song) {
        this.id = song.getId();
        this.name = song.getName();
        this.artistName = song.getSinger().getName();
        this.artistId = song.getSinger().getId();
        this.albumName = song.getAlbum().getName();
        this.albumId = song.getAlbum().getId();
        this.publishDate = song.getPuslishedDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

}
