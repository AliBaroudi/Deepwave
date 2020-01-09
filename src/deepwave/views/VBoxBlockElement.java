/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepwave.views;

import deepwave.DeepWaveConstants;
import deepwave.tools.FXMLTools;
import java.io.File;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author atphan
 */
public abstract class VBoxBlockElement extends VBox {

    protected static String CSS_CLASS = "vbox-element";

    protected ImageView imageView;
    protected Label labelName;
    protected Label labelDescription;

    protected void initializeElements() {
        this.imageView = new ImageView();
        this.labelName = new Label();
        this.labelDescription = new Label();

        this.getChildren().add(this.imageView);
        this.getChildren().add(this.labelName);
        this.getChildren().add(this.labelDescription);

        FXMLTools.setImage(this.imageView, getImagePath());
        this.labelName.setText(getName());
        this.labelDescription.setText(getDescription());

        this.bindImageViewSize();

        FXMLTools.addStyleClass(this, CSS_CLASS);
        FXMLTools.addStyleClass(this.labelName, DeepWaveConstants.LABEL_LEVEL_1);
        FXMLTools.addStyleClass(this.labelDescription, DeepWaveConstants.LABEL_LEVEL_2);
    }

    protected void bindImageViewSize() {
        imageView.setFitHeight(this.getWidth() - 20);
        imageView.setFitWidth(this.getWidth() - 20);
        this.heightProperty().addListener(listener -> {
            imageView.setFitHeight(this.getWidth() - 20);
            imageView.setFitWidth(this.getWidth() - 20);
        });
    }

//    public void setImage() {
//        File file;
//        try {
//            file = new File(getImagePath());
//        } catch (Exception e) {
//            file = new File(EMPTY_AVATAR_IMAGE_PATH);
//        }
//
//        Image image = new Image(file.toURI().toString());
//        this.imageView.setImage(image);
//    }
    protected abstract String getImagePath();

    protected abstract String getName();

    protected abstract String getDescription();

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Label getLabelName() {
        return labelName;
    }

    public void setLabelName(Label labelName) {
        this.labelName = labelName;
    }

    public Label getLabelDescription() {
        return labelDescription;
    }

    public void setLabelDescription(Label labelDescription) {
        this.labelDescription = labelDescription;
    }

}
