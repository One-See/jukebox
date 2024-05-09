package com.example.demo.entities;

public class Song {
    private String songName;
    private String artistName;
    private String albumName;
    private String genre;

    private Long id = 1L;

    public Song(String songName, String artistName, String albumName, String genre) {
        this.songName = songName;
        this.artistName = artistName;
        this.albumName = albumName;
        this.genre = genre;
    }

    public Song(String songName, String artistName, String albumName, String genre, Long id) {
        this.songName = songName;
        this.artistName = artistName;
        this.albumName = albumName;
        this.genre = genre;
        this.id = id;
    }

    public String getSongName() {
        return this.songName;
    }

    public String getArtistName() {
        return this.artistName;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public String getGenre() {
        return this.genre;
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Song [id=" + id + "]";
    }

}
