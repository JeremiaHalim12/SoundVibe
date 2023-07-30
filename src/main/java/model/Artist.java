package model;
// INI ARTIST.JAVA
public class Artist {
    private String artistName;
    private String artistPhoto;

    public Artist(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistPhoto() {
        return artistPhoto;
    }

    public void setArtistPhoto(String artistPhoto) {
        this.artistPhoto = artistPhoto;
    }
}
