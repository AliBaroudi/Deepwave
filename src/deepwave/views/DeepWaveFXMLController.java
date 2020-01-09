/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepwave.views;

import deepwave.DeepWaveConstants;
import deepwave.controller.MainController;
import deepwave.tools.FXMLTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;

/**
 * @author atphan
 */
public final class DeepWaveFXMLController {

    public static final String FXML_FILE = "DeepWaveFXML.fxml";
    public static final String CSS_FILE = "DeepWave.css";

    private final MainController mainController;
    private Scene scene;

    @FXML
    private VBox root;
    @FXML
    private ImageView userAvatar;
    @FXML
    private Button buttonSongs;
    @FXML
    private Button buttonAlbums;
    @FXML
    private Button buttonArtists;
    @FXML
    private AnchorPane mainContainerPane;
    @FXML
    private HBox hboxMusicPlayer;

    public DeepWaveFXMLController(MainController mainController) {
        this.mainController = mainController;
    }

    public void show(Stage stage) {
        FXMLLoader loader = new FXMLLoader();
        loader.setClassLoader(getClass().getClassLoader()); // set the plugin's class loader
        loader.setLocation(getClass().getResource(FXML_FILE));
        loader.setController(this);
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource(CSS_FILE).toExternalForm());

        setButtonsAction();
        FXMLTools.setImage(userAvatar, FXMLTools.EMPTY_AVATAR_IMAGE_PATH);

        stage.setScene(scene);
        stage.show();
    }



    public void setButtonsAction() {
        buttonSongs.setOnAction((ActionEvent event) -> {
            System.out.println("Button Songs clicked...");
            mainController.showAllSongsView();
        });

        buttonArtists.setOnAction((ActionEvent event) -> {
            System.out.println("Button Artists clicked...");
            mainController.showAllArtistsView();
        });

        buttonAlbums.setOnAction((ActionEvent event) -> {
            System.out.println("Button Albums clicked...");
            mainController.showAllAlbumsView();
        });
    }

    public void setClickedButtonStyleClass(LeftMenuButton button) {
        switch (button) {
            case SONGS:
                FXMLTools.addStyleClass(buttonSongs, DeepWaveConstants.LEFT_MENU_CLICKED_BUTTON_CSS_CLASS);
                FXMLTools.removeStyleClass(buttonAlbums, DeepWaveConstants.LEFT_MENU_CLICKED_BUTTON_CSS_CLASS);
                FXMLTools.removeStyleClass(buttonArtists, DeepWaveConstants.LEFT_MENU_CLICKED_BUTTON_CSS_CLASS);
                break;
            case ALBUMS:
                FXMLTools.addStyleClass(buttonAlbums, DeepWaveConstants.LEFT_MENU_CLICKED_BUTTON_CSS_CLASS);
                FXMLTools.removeStyleClass(buttonSongs, DeepWaveConstants.LEFT_MENU_CLICKED_BUTTON_CSS_CLASS);
                FXMLTools.removeStyleClass(buttonArtists, DeepWaveConstants.LEFT_MENU_CLICKED_BUTTON_CSS_CLASS);
                break;
            case ARTISTS:
                FXMLTools.addStyleClass(buttonArtists, DeepWaveConstants.LEFT_MENU_CLICKED_BUTTON_CSS_CLASS);
                FXMLTools.removeStyleClass(buttonSongs, DeepWaveConstants.LEFT_MENU_CLICKED_BUTTON_CSS_CLASS);
                FXMLTools.removeStyleClass(buttonAlbums, DeepWaveConstants.LEFT_MENU_CLICKED_BUTTON_CSS_CLASS);
                break;
        }
    }

    public void loadMainContainerView(Node node) {
        this.mainContainerPane.getChildren().clear();
        this.mainContainerPane.getChildren().add(node);

        // make vbox fill mainContainerPane
        final double VALUE = 0.0;
        AnchorPane.setTopAnchor(node, VALUE);
        AnchorPane.setLeftAnchor(node, VALUE);
        AnchorPane.setRightAnchor(node, VALUE);
        AnchorPane.setBottomAnchor(node, VALUE);
    }


    public void loadPlayerView(Node node) {
        this.hboxMusicPlayer.getChildren().clear();
        this.hboxMusicPlayer.getChildren().add(node);

        // make node fill its parent hortizontal
        HBox.setHgrow(node, Priority.ALWAYS);
    }

    public enum LeftMenuButton {
        SONGS,
        ALBUMS,
        ARTISTS
    }
}
