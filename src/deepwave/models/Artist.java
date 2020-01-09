/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepwave.models;


import java.time.LocalDate;

/**
 *
 * @author atphan
 */
public class Artist extends AbstractMusicElement {

    private static int ID_COUNTER = 0;

    private String imagePath;
    private LocalDate birthday;

    public Artist() {
        this.id = ID_COUNTER;
        ID_COUNTER++;
    }

    public Artist(String name, String imagePath, LocalDate birthday, String description) {
        this.id = ID_COUNTER;
        this.name = name;
        this.imagePath = imagePath;
        this.birthday = birthday;
        this.description = description;
        ID_COUNTER++;
    }

    public Artist(int id, String name, String imagePath, LocalDate birthday, String description) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "{name: '" + name + "', birthday: " + birthday + "}";
    }
}
