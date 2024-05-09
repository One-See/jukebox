package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.demo.entities.PlayList;
import com.example.demo.entities.Song;
import com.example.demo.repositories.IPlaylistRepository;
import com.example.demo.repositories.ISongRepository;

public class PlaylistService {
    private IPlaylistRepository iPlaylistRepository;
    private ISongRepository iSongRepository;

    public PlaylistService(IPlaylistRepository iPlaylistRepository, ISongRepository iSongRepository) {
        this.iPlaylistRepository = iPlaylistRepository;
        this.iSongRepository = iSongRepository;
    }

    public PlayList createPlaylist(String playlistName, List<Long> songIds) {
        List<Song> temp = new ArrayList<Song>();
        for (Long id: songIds) {
            Optional<Song> tempSong = this.iSongRepository.findById(id);
            if (tempSong.isPresent()) temp.add(tempSong.get());
        }
        return this.iPlaylistRepository.save(new PlayList(playlistName, temp));
    }

    public List<Song> addSongToPlayList(String playlistName, Long songId) {
        Optional<PlayList> playlist = this.iPlaylistRepository.findByName(playlistName);
        if (playlist.isPresent()) {
            Optional<Song> tempSong = this.iSongRepository.findById(songId);
            if (tempSong.isPresent()) playlist.get().addSong(tempSong.get());
        }
        return playlist.get().getSongs();
    }

    public List<Song> removeSongFromPlaylist(String playlistName, Long songId) {
        Optional<PlayList> playlist = this.iPlaylistRepository.findByName(playlistName);
        if (playlist.isPresent()) {
            Optional<Song> tempSong = this.iSongRepository.findById(songId);
            if (tempSong.isPresent()) playlist.get().removeSong(tempSong.get().getId());
        }
        return playlist.get().getSongs();
    }

    public String deletePlaylist(String playlistName) {
        this.iPlaylistRepository.deleteByName(playlistName);
        return playlistName;
    }
}
