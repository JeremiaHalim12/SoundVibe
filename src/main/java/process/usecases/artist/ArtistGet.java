package process.usecases.artist;

import model.Album;
import model.Artist;
import process.repositories.AlbumRepository;
import process.repositories.ArtistRepository;

public class ArtistGet {
    public Artist[] exexuteArtistGet() {
        ArtistRepository artistRepository = new ArtistRepository();
        return artistRepository.getArtists();
    }
}
