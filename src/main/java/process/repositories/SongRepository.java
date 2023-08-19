package process.repositories;

import Utility.JDBCConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Song;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongRepository {
//    private final Song[] songs = {
//            new Song("Panah Asmara","4:34"),
//            new Song("The Scientist","5:09"),
//            new Song("Harus Bahagia","2:53"),
//            new Song("Hati - Hati di Jalan","4:02"),
//            new Song("Monokrom","3:34"),
//            new Song("Lantas","3:54"),
//            new Song("Kereta Kencan","4:17"),
//            new Song("All I Want","5:05"),
//            new Song("lowkey","2:51"),
//            new Song("golden hour","3:29"),
//            new Song("Yellow","4:26"),
//            new Song("Komang","3:42"),
//            new Song("Tenang","4:07"),
//            new Song("Asmalibrasi","4:14"),
//            new Song("Serta Mulia","3:09"),
//    };

//    public List<Song> getSongs() {
//        List<Song> songs = new ArrayList<>();
//
//        try {
//            String query = "SELECT * FROM song";
//            PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(query);
//            ResultSet resultSet = ps.executeQuery();
//
//            while (resultSet.next()) {
////                String songId = resultSet.getString("songId");
//                String title = resultSet.getString("songTitle");
//                String duration = resultSet.getString("songDuration");
//
//                Song song = new Song(title, duration);
//                songs.add(song);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        return songs;
//    }

    public Song[] getSongs() {
        List<Song> songs = new ArrayList<>();

        try {
            String query = "SELECT * FROM song";
            PreparedStatement ps = JDBCConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String title = resultSet.getString("songTitle");
                String duration = resultSet.getString("songDuration");
                String album = resultSet.getString("album_albumId");

                Song song = new Song(title, duration, album);
                songs.add(song);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return songs.toArray(new Song[0]);
    }

//    public Song[] getSongs() {
//        return songs;
//    }
}
