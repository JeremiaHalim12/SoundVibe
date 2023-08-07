package process.usecases.album;

import model.Album;
import model.Artist;

public class AlbumGet {
    private final Album[] albums = {
            new Album("DEKADE"),
            new Album("A Rush of Blood to the Head"),
            new Album("Harus Bahagia"),
            new Album("Manusia"),
            new Album("Monokrom"),
            new Album("Sentimental"),
            new Album("Kereta Kencan"),
            new Album("In a Perfect World"),
            new Album("lowkey"),
            new Album("this is what falling in love feels like"),
            new Album("Parachutes"),
            new Album("Komang"),
            new Album("Tenang"),
            new Album("Asmalibrasi"),
            new Album("Serta Mulia"),
    };

    public Album[] getAlbums() {
        return albums;
    }
}
