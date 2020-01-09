/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepwave.tools;

import deepwave.models.Album;
import deepwave.models.Artist;
import deepwave.models.Song;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author atphan
 */
public class DataGenerator {

    public static void main(String[] args) {

    }

    public static Set<Album> generateData() {
        // Artist1
        Artist maroon5 = new Artist();
        maroon5.setName("Marron 5");
        maroon5.setImagePath("res/image/artist/maroon5.jpg");

        //Artist2
        Artist John_Mayer = new Artist();
        John_Mayer.setName("John Mayer");
        John_Mayer.setImagePath("res/image/artist/john-Mayer.jpg");

        //Artist3
        Artist Marcus_Miller = new Artist();
        Marcus_Miller.setName("Marcus Miller");
        Marcus_Miller.setImagePath("res/image/artist/Marcus-Miller.jpg");

        //Artist4
        Artist Snarky_Puppy = new Artist();
        Snarky_Puppy.setName(" Snarky Puppy");
        Snarky_Puppy.setImagePath("res/image/artist/Snarky-Puppy.jpg");

        //Artist5
        Artist Jason_Mraz = new Artist();
        Jason_Mraz.setName("Jason Mraz");
        Jason_Mraz.setImagePath("res/image/artist/Jason-mraz.jpg");

        //Artist6
        Artist Pink_Floyd = new Artist();
        Pink_Floyd.setName("Pink Floyd");
        Pink_Floyd.setImagePath("res/image/artist/Pink-floyd.jpg");

        //Artist7
        Artist Green_day = new Artist();
        Green_day.setName("Green day");
        Green_day.setImagePath("res/image/artist/Green-day.jpg");

        // Songs
        // for album 1
        Song song1 = new Song();
        song1.setName("Something just like this");
        song1.setSinger(maroon5);

        // for album 1
        Song song11 = new Song();
        song11.setName("This Love");
        song11.setSinger(maroon5);

        // Songs
        // for album 2
        Song song2 = new Song();
        song2.setName("Free fallin");
        song2.setSinger(John_Mayer);

        // for album 2
        Song song22 = new Song();
        song22.setName("Slow dancing in a burning room");
        song22.setSinger(John_Mayer);

        // Songs
        // for album 3
        Song song3 = new Song();
        song3.setName("Afrodezia");
        song3.setSinger(Marcus_Miller);

        // for album 3
        Song song33 = new Song();
        song33.setName("Jean Pierre");
        song33.setSinger(Marcus_Miller);

        // Songs
        // for album 4
        Song song4 = new Song();
        song4.setName("Shofokan");
        song4.setSinger(Snarky_Puppy);

        // Songs
        // for album 5
        Song song5 = new Song();
        song5.setName("I'm yours");
        song5.setSinger(Jason_Mraz);

        // for album 5
        Song song55 = new Song();
        song55.setName("The remedy");
        song55.setSinger(Jason_Mraz);

        // Songs
        // for album 6
        Song song6 = new Song();
        song6.setName("Another Brick in the wall");
        song6.setSinger(Pink_Floyd);

        // Songs
        // for album 7
        Song song7 = new Song();
        song7.setName("Boulevard of broken dreams");
        song7.setSinger(Green_day);

        List<Song> album1Songs = Arrays.asList(song1, song11);

        List<Song> album2Songs = Arrays.asList(song2, song22);

        List<Song> album3Songs = Arrays.asList(song3, song33);

        List<Song> album4Songs = Arrays.asList(song4);

        List<Song> album5Songs = Arrays.asList(song5, song55);

        List<Song> album6Songs = Arrays.asList(song6);

        List<Song> album7Songs = Arrays.asList(song7);

        // for album 2
        // Albums
        // album 1
        Album album1 = new Album();
        Album album2 = new Album();
        Album album3 = new Album();
        Album album4 = new Album();
        Album album5 = new Album();
        Album album6 = new Album();
        Album album7 = new Album();

        album1.setName("Something just like this");
        album1.setDescription("A new single of Maroon 5");
        album1.setImageURL("res/image/album/something-just-like-this.jpg");
        album1.setSongs(new HashSet<>(album1Songs));

        album2.setName("Where the light is");
        album2.setDescription("a new single of John Mayer");
        album2.setImageURL("res/image/album/where-the-light-is.jpg");
        album2.setSongs(new HashSet<>(album2Songs));

        album3.setName("Afrodezia");
        album3.setDescription("Tour in Africa");
        album3.setImageURL("res/image/album/Marcus-Miller.jpg");
        album3.setSongs(new HashSet<>(album3Songs));

        album4.setName("Family Dinner");
        album4.setDescription("Live session album");
        album4.setImageURL("res/image/album/Snarky-Puppy.jpg");
        album4.setSongs(new HashSet<>(album4Songs));

        album5.setName("Acoustique session");
        album5.setDescription("Live session album");
        album5.setImageURL("res/image/album/Pink-floyd.jpg");
        album5.setSongs(new HashSet<>(album5Songs));

        album6.setName("Pink Floyd");
        album6.setDescription("Live album");
        album6.setImageURL("res/image/album/Jason-mraz.jpg");
        album6.setSongs(new HashSet<>(album6Songs));

        album7.setName("Punk music");
        album7.setDescription("Punk rock");
        album7.setImageURL("res/image/album/Green-day.jpg");
        album7.setSongs(new HashSet<>(album7Songs));

        List<Album> albums = Arrays.asList(album1, album2, album3, album4, album5, album6);

        // album 2
        return new HashSet<>(albums);
    }

}
