/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepwave.tools;

import java.io.File;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author atphan
 */
public class FXMLTools {

    public static String EMPTY_AVATAR_IMAGE_PATH = "res/image/avatar-empty.jpg";

    private FXMLTools() {
        // hidden constructor
    }

    /**
     * Add a style class to a node if it doesn't exist
     *
     * @param node
     * @param styleClass
     * @return true if the style class is added successfully; false if the style
     * class has already existed
     */
    public static boolean addStyleClass(Node node, String styleClass) {
        if (node.getStyleClass().contains(styleClass)) {
            return false;
        }

        node.getStyleClass().add(styleClass);
        return true;
    }

    /**
     * Remove a style class to a node if it exist
     *
     * @param node
     * @param styleClass
     * @return true if the style class is removed successfully; false if the
     * style class doesn't exist
     */
    public static boolean removeStyleClass(Node node, String styleClass) {
        if (!node.getStyleClass().contains(styleClass)) {
            return false;
        }

        node.getStyleClass().remove(styleClass);
        return true;
    }

    public static boolean setImage(ImageView imageView, String path) {
        boolean res = true;
        File file;
        try {
            file = new File(path);
        } catch (Exception e) {
            file = new File(EMPTY_AVATAR_IMAGE_PATH);
            res = false;
        }

        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
        return res;
    }
}
