package process.usecases.album;

import model.Album;
import model.Artist;
import process.repositories.AlbumRepository;

public class AlbumGet {
    public Album[] executeAlbumGet() {
        AlbumRepository albumRepository = new AlbumRepository();
        return albumRepository.getAlbums();
    }
}
