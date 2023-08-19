package process.repositories;

import Utility.JDBCConnection;
import model.Album;
import model.Song;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepository {
//    private final Album[] albums = {
//            new Album("DEKADE"),
//            new Album("A Rush of Blood to the Head"),
//            new Album("Harus Bahagia"),
//            new Album("Manusia"),
//            new Album("Monokrom"),
//            new Album("Sentimental"),
//            new Album("Kereta Kencan"),
//            new Album("In a Perfect World"),
//            new Album("lowkey"),
//            new Album("this is what falling in love feels like"),
//            new Album("Parachutes"),
//            new Album("Komang"),
//            new Album("Tenang"),
//            new Album("Asmalibrasi"),
//            new Album("Serta Mulia"),
//    };

    public Album[] getAlbums() {
        List<Album> albums = new ArrayList<>();

        try {
            String query = "SELECT * FROM album";
            PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("albumName");
                String artist = resultSet.getString("artist_artistID");

                Album album = new Album(name,artist);
                albums.add(album);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return albums.toArray(new Album[0]);
    }

    public String getAlbumNameById(String albumID) {
        String albumName = null;

        try {
            String query = "SELECT albumName FROM album WHERE albumID = ?";
            PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setString(1, albumID);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                albumName = resultSet.getString("albumName");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return albumName;
    }

    public String getAlbumArtistById(String albumID) {
        String artistID = null;

        try {
            String query = "SELECT artist_artistID FROM album WHERE albumID = ?";
            PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setString(1, albumID);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                artistID = resultSet.getString("artist_artistID");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return artistID;
    }

//    public Album[] getAlbums() {
//        return albums;
//    }

}
