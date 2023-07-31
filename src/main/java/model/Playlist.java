package model;

public class Playlist {
    private String playlistId;
    private String playlistName;
    private String playlistTotalDuration;

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistTotalDuration() {
        return playlistTotalDuration;
    }

    public void setPlaylistTotalDuration(String playlistTotalDuration) {
        this.playlistTotalDuration = playlistTotalDuration;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }
}
