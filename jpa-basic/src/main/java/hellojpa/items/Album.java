package hellojpa.items;

import javax.persistence.Entity;

@Entity
public class Album extends Items {

    private String artist;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
