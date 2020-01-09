/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepwave.views.albums;

import deepwave.models.Album;
import deepwave.tools.FXMLTools;
import deepwave.views.VBoxBlockElement;

/**
 *
 * @author atphan
 */
public class AlbumVBox extends VBoxBlockElement {

    public static String ALBUM_CSS_CLASS = "album-vbox";
    public static String ALBUM_IMAGE_CSS_CLASS = "album-image";
    private final Album album;

    public AlbumVBox(Album album) {
        super();
        this.album = album;
        super.initializeElements();
        FXMLTools.addStyleClass(this, ALBUM_CSS_CLASS);
    }

    @Override
    protected String getImagePath() {
        return this.album.getImageURL();
    }

    @Override
    protected String getName() {
        return this.album.getName();
    }

    @Override
    protected String getDescription() {
        return this.album.getDescription();
    }

}
