package process.usecases.artist;

import model.Album;
import model.Artist;
import process.repositories.AlbumRepository;
import process.repositories.ArtistRepository;

public class ArtistGetById {
    public Artist executeArtistGetById(String id) {
        ArtistRepository artistRepository = new ArtistRepository();

        // Assuming id is a string representation of an album ID
        String artistName = artistRepository.getArtistNameById(id);

        if (artistName != null) {
            return new Artist(artistName); // You might need to provide the artist name here
        } else {
            return null; // No album found with the provided ID
        }
    }
}
