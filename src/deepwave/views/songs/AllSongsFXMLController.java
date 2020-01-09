/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepwave.views.songs;

import deepwave.DeepWaveConstants;
import deepwave.controller.MainController;
import deepwave.tools.FXMLTools;
import deepwave.views.DeepWaveFXMLController;
import dto.SongDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;

/**
 *
 * @author atphan
 */
public class AllSongsFXMLController {

    private static final String FXML_FILE = "AllSongsFXML.fxml";

    private MainController mainController;

    @FXML
    private VBox allSongsRoot;
    @FXML
    private Label labelSongs;
    @FXML
    private TableView<SongDTO> tableViewSongs;
    @FXML
    private TableColumn<SongDTO, Integer> colPlay;
    @FXML
    private TableColumn<SongDTO, String> colTitle;
    @FXML
    private TableColumn<SongDTO, String> colArtist;
    @FXML
    private TableColumn<SongDTO, String> colAlbum;
    @FXML
    private TableColumn<SongDTO, LocalDate> colDate;

    public AllSongsFXMLController(MainController mainController) {
        this.mainController = mainController;

        FXMLLoader loader = new FXMLLoader();
        loader.setClassLoader(getClass().getClassLoader()); // set the plugin's class loader
        loader.setLocation(getClass().getResource(FXML_FILE));
        loader.setController(this);
        try {
            allSongsRoot = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(DeepWaveFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        FXMLTools.addStyleClass(labelSongs, DeepWaveConstants.MAIN_CONTAINER_TITLE_CSS_CLASS);

        this.tableViewSongs.setEditable(false);
        bindColumnsWidth();
        setRowFactory();
    }

    private void bindColumnsWidth() {
        colPlay.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("name"));
        colArtist.setCellValueFactory(new PropertyValueFactory<>("artistName"));
        colAlbum.setCellValueFactory(new PropertyValueFactory<>("albumName"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("publishDate"));

        colPlay.prefWidthProperty().bind(tableViewSongs.widthProperty().multiply(0.07));
        colTitle.prefWidthProperty().bind(tableViewSongs.widthProperty().multiply(0.40));
        colArtist.prefWidthProperty().bind(tableViewSongs.widthProperty().multiply(0.2));
        colAlbum.prefWidthProperty().bind(tableViewSongs.widthProperty().multiply(0.2));
        colDate.prefWidthProperty().bind(tableViewSongs.widthProperty().multiply(0.10));
    }

    private void setRowFactory() {
        tableViewSongs.setRowFactory(tv -> {
            TableRow<SongDTO> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
                    SongDTO clickedRow = row.getItem();
                    mainController.play(clickedRow.getId());
                    System.out.println("Song " + clickedRow.getId() + " selected");
                }
            });

            return row;
        });
    }

    public void updateView(List<SongDTO> songDTOs) {
        this.tableViewSongs.getItems().clear();
        this.tableViewSongs.setItems(FXCollections.observableList(songDTOs));
    }

    public VBox getRoot() {
        return allSongsRoot;
    }
}
