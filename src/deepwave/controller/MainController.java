/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepwave.controller;

import deepwave.facade.DeepWaveFacade;
import deepwave.models.Album;
import deepwave.models.Artist;
import deepwave.models.Song;
import deepwave.views.DeepWaveFXMLController;
import deepwave.views.DeepWaveFXMLController.LeftMenuButton;
import deepwave.views.albums.AllAlbumsFXMLController;
import deepwave.views.artists.AllArtistsFXMLController;
import deepwave.views.player.MusicPlayerFXMLController;
import deepwave.views.songs.AllSongsFXMLController;
import dto.SongDTO;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javafx.stage.Stage;

/**
 *
 * @author thibaultphan
 */
public class MainController {

    private final DeepWaveFacade facade;
    // views
    private final DeepWaveFXMLController mainView;
    private final AllAlbumsFXMLController allAlbumsView;
    private final AllArtistsFXMLController allArtistsView;
    private final AllSongsFXMLController allSongsView;
    private final MusicPlayerFXMLController playerView;

    public MainController() {
        this.facade = new DeepWaveFacade();
        this.mainView = new DeepWaveFXMLController(this);
        this.allAlbumsView = new AllAlbumsFXMLController(this);
        this.allArtistsView = new AllArtistsFXMLController(this);
        this.allSongsView = new AllSongsFXMLController(this);
        this.playerView = new MusicPlayerFXMLController(this);
    }

    public void showMainView(Stage stage) {
        mainView.show(stage);

        showAllSongsView();

        showPlayerView();
        playerView.updateView(facade.getSong(0));
    }

    public void showAllAlbumsView() {
        System.out.println("Show all albums view...");
        this.allAlbumsView.updateView(facade.getAlbums());
        this.mainView.loadMainContainerView(allAlbumsView.getRoot());
        this.mainView.setClickedButtonStyleClass(LeftMenuButton.ALBUMS);
    }

    public void showAllArtistsView() {
        System.out.println("Show all artists view...");
        this.allArtistsView.updateView(facade.getArtists());
        this.mainView.loadMainContainerView(allArtistsView.getRoot());
        this.mainView.setClickedButtonStyleClass(LeftMenuButton.ARTISTS);
    }

    public void showAllSongsView() {
        System.out.println("Show all songs view...");
        Set<Song> songs = facade.getSongs();
        List<SongDTO> songDTOs = songs.stream().map(s -> new SongDTO(s)).collect(Collectors.toList());
        this.allSongsView.updateView(songDTOs);
        this.mainView.loadMainContainerView(allSongsView.getRoot());
        this.mainView.setClickedButtonStyleClass(LeftMenuButton.SONGS);
    }

    public void showAlbumView(int albumId) {
        System.out.println("Show a specific album view...");
        Album selectedAlbum = facade.getAlbum(albumId);
    }

    public void showArtistView(int artistId) {
        System.out.println("Show a specific artist view...");
        // TODO show a specific Artist view
        Artist selectedArtist = facade.getArtist(artistId);
    }

    public void showSongView(int songId) {
        System.out.println("Show a specific song view...");
        // TODO show a specific Song view
        Song selectedSong = facade.getSong(songId);
    }

    public void showPlayerView() {
        System.out.println("Show all artists view...");
        this.mainView.loadPlayerView(playerView.getRoot());
    }

    public void play(int songId) {
        Song selectedSong = facade.getSong(songId);
        playerView.updateView(selectedSong);
    }
}
