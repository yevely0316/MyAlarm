package com.example.motion.myalarm;

import java.io.Serializable;

public class MySdSound implements Serializable {

    private String id;
    private String title;
    private String artist;

    public MySdSound() {
    }

    //static 메소드에서는 static 변수만 리턴할수있어요
    public String getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "MySdSound{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", artist='" + artist + '\'' + '}';
    }
}
