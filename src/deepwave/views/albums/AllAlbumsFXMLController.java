/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepwave.views.albums;

import deepwave.controller.MainController;
import deepwave.models.Album;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 * @author atphan
 */
public class AllAlbumsFXMLController {

    public static final int COLUMNS = 3;
    private static final String FXML_FILE = "AllAlbumsFXML.fxml";

    private MainController mainController;
    private ObservableList<AlbumVBox> albumVBoxes = FXCollections.emptyObservableList();

    @FXML
    private VBox allAlbumsRoot;
    @FXML
    private GridPane albumsGridPane;

    public AllAlbumsFXMLController(MainController mainController) {
        this.mainController = mainController;

        FXMLLoader loader = new FXMLLoader();
        loader.setClassLoader(getClass().getClassLoader()); // set the plugin's class loader
        loader.setLocation(AllAlbumsFXMLController.class.getResource(FXML_FILE));
        loader.setController(this);
        try {
            allAlbumsRoot = loader.load();

            allAlbumsRoot.heightProperty().addListener(listener -> {
                albumsGridPane.setPrefHeight(allAlbumsRoot.getHeight());
            });
        } catch (IOException ex) {
            Logger.getLogger(AllAlbumsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

//        albumsGridPane.widthProperty().addListener(listener -> {
//            albumVBoxes.forEach(a -> {
//                double newWidth = (albumsGridPane.getWidth() / 3) - (10 * COLUMNS);
//                double gap = Math.abs(a.getWidth() - newWidth);
//
//                a.setPrefWidth(newWidth);
//                a.setMaxWidth(newWidth);
//                a.setMinWidth(newWidth);
//
//                double newHeight = a.getHeight() + gap;
//                a.setPrefHeight(newHeight);
//                a.setMaxHeight(newHeight);
//                a.setMinHeight(newHeight);
//            });
//        });
    }

    public VBox getRoot() {
        return allAlbumsRoot;
    }

    public void updateView(Set<Album> albums) {
        int rowIndex = 0;
        int columnIndex = 0;

        List<AlbumVBox> list = new ArrayList<>();
        for (Album a : albums) {
            AlbumVBox albumVBox = new AlbumVBox(a);
            albumsGridPane.add(albumVBox, columnIndex, rowIndex);

            // calculate next position
            if (columnIndex < COLUMNS - 1) {
                columnIndex++;
            } else {
                columnIndex = 0;
                rowIndex++;
            }
            list.add(albumVBox);
        }
        albumVBoxes = FXCollections.observableArrayList(list);
        System.out.println(albums.size() + " artist(s) created");
    }
}
