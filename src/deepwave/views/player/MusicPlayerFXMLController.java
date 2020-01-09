package deepwave.views.player;

import deepwave.controller.MainController;
import deepwave.models.Song;
import deepwave.tools.FXMLTools;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Ali
 */
public class MusicPlayerFXMLController {

    private static final String FXML_FILE = "MusicPlayerFXML.fxml";
    private static final String IMAGE_PLAY_PATH = "res/image/player/play-btn.png";
    private static final String IMAGE_PAUSE_PATH = "res/image/player/pause-btn.png";
    private static final String IMAGE_PREVIOUS_PATH = "res/image/player/previous-btn.png";
    private static final String IMAGE_NEXT_PATH = "res/image/player/next-btn.png";

    private MainController mainController;
    private Song song;
    private boolean isPlaying = true;

    @FXML
    private AnchorPane playerRoot;
    @FXML
    private ImageView albumImage;
    @FXML
    private Label lblSongName;
    @FXML
    private Label lblArtistName;
    @FXML
    private ImageView btnImgPreviousSong;
    @FXML
    private ImageView btnImgPlayPause;
    @FXML
    private ImageView btnImgNextSong;
    @FXML
    private Slider sliderPlay;
    @FXML
    private Slider sliderVolume;

    public MusicPlayerFXMLController(MainController mainController) {
        this.mainController = mainController;

        FXMLLoader loader = new FXMLLoader();
        loader.setClassLoader(getClass().getClassLoader()); // set the plugin's class loader
        loader.setLocation(getClass().getResource(FXML_FILE));
        loader.setController(this);
        try {
            playerRoot = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MusicPlayerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        initButtonImage();
        initSliders();
    }

    public void initButtonImage() {
        FXMLTools.setImage(this.btnImgPreviousSong, IMAGE_PREVIOUS_PATH);
        FXMLTools.setImage(this.btnImgPlayPause, IMAGE_PLAY_PATH);
        FXMLTools.setImage(this.btnImgNextSong, IMAGE_NEXT_PATH);

        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(0.8);
        this.btnImgPreviousSong.setEffect(colorAdjust);
        this.btnImgPlayPause.setEffect(colorAdjust);
        this.btnImgNextSong.setEffect(colorAdjust);

        this.btnImgPlayPause.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("btnImgPlayPause clicked");
                if (isPlaying) {
                    FXMLTools.setImage(btnImgPlayPause, IMAGE_PAUSE_PATH);
                    isPlaying = false;
                } else {
                    FXMLTools.setImage(btnImgPlayPause, IMAGE_PLAY_PATH);
                    isPlaying = true;
                }
            }
        });
    }

    public void initSliders() {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.2);
        this.sliderPlay.setEffect(colorAdjust);
        this.sliderVolume.setEffect(colorAdjust);
    }

    public AnchorPane getRoot() {
        return playerRoot;
    }

    public void updateView(Song song) {
        FXMLTools.setImage(albumImage, song.getAlbum().getImageURL());
        this.lblSongName.setText(song.getName());
        this.lblArtistName.setText(song.getSinger().getName());
    }
}
