/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepwave.views.artists;

import deepwave.models.Artist;
import deepwave.tools.FXMLTools;
import deepwave.views.VBoxBlockElement;

/**
 *
 * @author atphan
 */
public class ArtistVBox extends VBoxBlockElement {

    public static String ARTIST_CSS_CLASS = "artist-vbox";
    private final Artist artist;

    public ArtistVBox(Artist artist) {
        super();
        this.artist = artist;
//        this.initializeElements(artist);
        super.initializeElements();
    }

    protected final void initializeElements(Artist artist) {
        super.initializeElements();

        this.labelName.setText(artist.getName());
        this.labelDescription.setText(artist.getDescription());

        FXMLTools.addStyleClass(this, CSS_CLASS);
        FXMLTools.addStyleClass(this, ARTIST_CSS_CLASS);
    }

    @Override
    protected String getImagePath() {
        return this.artist.getImagePath();
    }

    @Override
    protected String getName() {
        return this.artist.getName();
    }

    @Override
    protected String getDescription() {
        return this.artist.getDescription();
    }
}
