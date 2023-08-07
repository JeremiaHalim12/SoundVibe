package process.usecases.artist;

import model.Artist;

public class ArtistGet {
    private final Artist[] artists = {
            new Artist("Afgan"),
            new Artist("Coldplay"),
            new Artist("Yura Yunita"),
            new Artist("Tulus"),
            new Artist("Tulus"),
            new Artist("Juicy Luicy"),
            new Artist("Hivi!"),
            new Artist("Kodaline"),
            new Artist("NIKI"),
            new Artist("JVKE"),
            new Artist("Coldplay"),
            new Artist("Raim Laode"),
            new Artist("Yura Yunita"),
            new Artist("Soegi Bornean"),
            new Artist("Sal Priadi")
    };

    // Getter method for the artists array
    public Artist[] getArtists() {
        return artists;
    }
}
