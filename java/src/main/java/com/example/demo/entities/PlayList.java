package com.example.demo.entities;

import java.util.List;
import java.util.stream.Collectors;

public class PlayList {
    private String playListName;
    private List<Song> songs;

    private Long id = 1L;

    public PlayList(String playlistName, List<Song> songs) {
        this.playListName = playlistName;
        this.songs = songs;
    }

    public PlayList(String playlistName, List<Song> songs, Long id) {
        this.playListName = playlistName;
        this.songs = songs;
        this.id = id;
    }

    public String getPlayListName() {
        return this.playListName;
    }

    public List<Song> getSongs() {
        return this.songs;
    }

    public Long getId() {
        return this.id;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public void removeSong(Long id) {
        this.songs = this.songs.stream().filter(song -> song.getId() != id).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Playlist [id=" + id + "]";
    }
}
