package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.repositories.ISongRepository;

public class SongService {
    private ISongRepository iSongRepository;

    public SongService(ISongRepository iSongRepository) {
        this.iSongRepository = iSongRepository;
    }

    public Song addSong(String songName, String artistName, String albumName, String genre) {
        return this.iSongRepository.save(new Song(songName, artistName, albumName, genre));
    }

    public List<Song> listSongs() {
        return this.iSongRepository.findAll();
    }
}
