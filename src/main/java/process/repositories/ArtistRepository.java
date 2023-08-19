package process.repositories;

import Utility.JDBCConnection;
import model.Album;
import model.Artist;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistRepository {
//    private final Artist[] artists = {
//            new Artist("Afgan"),
//            new Artist("Coldplay"),
//            new Artist("Yura Yunita"),
//            new Artist("Tulus"),
//            new Artist("Tulus"),
//            new Artist("Juicy Luicy"),
//            new Artist("Hivi!"),
//            new Artist("Kodaline"),
//            new Artist("NIKI"),
//            new Artist("JVKE"),
//            new Artist("Coldplay"),
//            new Artist("Raim Laode"),
//            new Artist("Yura Yunita"),
//            new Artist("Soegi Bornean"),
//            new Artist("Sal Priadi")
//    };

    public Artist[] getArtists() {
        List<Artist> artists = new ArrayList<>();

        try {
            String query = "SELECT * FROM artist";
            PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("artistName");

                Artist artist = new Artist(name);
                artists.add(artist);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return artists.toArray(new Artist[0]);
    }

    public String getArtistNameById(String artistId) {
        String artistName = null;

        try {
            String query = "SELECT artistName FROM artist WHERE artistId = ?";
            PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setString(1, artistId);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                artistName = resultSet.getString("artistName");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return artistName;
    }

    // Getter method for the artists array
//    public Artist[] getArtists() {
//        return artists;
//    }
}
