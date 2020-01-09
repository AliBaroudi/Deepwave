/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepwave.views.artists;

import deepwave.controller.MainController;
import deepwave.models.Artist;
import deepwave.views.DeepWaveFXMLController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.GridPane;

/**
 *
 * @author atphan
 */
public class AllArtistsFXMLController {

    public static final int COLUMNS = 3;
    private static final String FXML_FILE = "AllArtistsFXML.fxml";

    private MainController mainController;

    @FXML
    private VBox allArtistsRoot;
    @FXML
    private GridPane aristsGridPane;

    public AllArtistsFXMLController(MainController mainController) {
        this.mainController = mainController;

        FXMLLoader loader = new FXMLLoader();
        loader.setClassLoader(getClass().getClassLoader()); // set the plugin's class loader
        loader.setLocation(getClass().getResource(FXML_FILE));
        loader.setController(this);
        try {
            allArtistsRoot = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(DeepWaveFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public VBox getRoot() {
        return allArtistsRoot;
    }

    public void updateView(Set<Artist> artists) {
        int rowIndex = 0;
        int columnIndex = 0;

        for (Artist a : artists) {
            ArtistVBox artistVBox = new ArtistVBox(a);
            aristsGridPane.add(artistVBox, columnIndex, rowIndex);

            // calculate next position
            if (columnIndex < COLUMNS - 1) {
                columnIndex++;
            } else {
                columnIndex = 0;
                rowIndex++;
            }
        }

        System.out.println(artists.size() + " artist(s) created");
    }
}
