package process.repositories;

import model.Song;

public class SongRepository {
    private final Song[] songs = {
            new Song("Panah Asmara","4:34"),
            new Song("The Scientist","5:09"),
            new Song("Harus Bahagia","2:53"),
            new Song("Hati - Hati di Jalan","4:02"),
            new Song("Monokrom","3:34"),
            new Song("Lantas","3:54"),
            new Song("Kereta Kencan","4:17"),
            new Song("All I Want","5:05"),
            new Song("lowkey","2:51"),
            new Song("golden hour","3:29"),
            new Song("Yellow","4:26"),
            new Song("Komang","3:42"),
            new Song("Tenang","4:07"),
            new Song("Asmalibrasi","4:14"),
            new Song("Serta Mulia","3:09"),
    };

    public Song[] getSongs() {
        return songs;
    }
}
