package process.usecases.song;

import model.Artist;
import model.Song;
import process.repositories.SongRepository;

public class SongGet {
    public Song[] executeSongGet() {
        SongRepository songRepository = new SongRepository();
        return songRepository.getSongs();
    }
}
