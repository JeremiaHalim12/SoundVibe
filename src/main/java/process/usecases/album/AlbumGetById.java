package process.usecases.album;

import model.Album;
import process.repositories.AlbumRepository;

public class AlbumGetById {
    public Album executeAlbumGetById(String id) {
        AlbumRepository albumRepository = new AlbumRepository();

        // Assuming id is a string representation of an album ID
        String albumName = albumRepository.getAlbumNameById(id);
        String albumArtist = albumRepository.getAlbumArtistById(id);

        if (albumName != null) {
            return new Album(albumName, albumArtist); // You might need to provide the artist name here
        } else {
            return null; // No album found with the provided ID
        }
    }
}
