package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.PlayList;
import com.example.demo.entities.PlayerStates;
import com.example.demo.entities.Song;
import com.example.demo.repositories.IPlaylistRepository;

public class PlayerService {
    private PlayerStates state;
    private List<Song> songsQueue;
    private IPlaylistRepository playlistRepository;
    private int currentSongIndex;

    public PlayerService(IPlaylistRepository playlistRepository) {
        this.state = PlayerStates.IDLE;
        this.playlistRepository = playlistRepository;
    }

    public String LoadPlaylist(String playlistName) {
        Optional<PlayList> playlist = this.playlistRepository.findByName(playlistName);
        if (playlist.isPresent()) {
            this.songsQueue = playlist.get().getSongs();
            this.currentSongIndex = 0;
            return playlist.get().getPlayListName();
        } else {
            throw new RuntimeException("Playlist not found");
        }
    }

    public Song playSong() {
        if (this.state == PlayerStates.PLAYING) {
            this.state = PlayerStates.PAUSED;
        } else {
            this.state = PlayerStates.PLAYING;
        }
        return songsQueue.get(currentSongIndex);
    }

    public Song playNextSong() {
        this.state = PlayerStates.PLAYING;
        this.currentSongIndex++;
        if (this.currentSongIndex == this.songsQueue.size()) {
            this.currentSongIndex = 0;
        }
        return songsQueue.get(currentSongIndex);
    }

    public Song playPreviousSong() {
        this.state = PlayerStates.PLAYING;
        this.currentSongIndex--;
        if (this.currentSongIndex == -1) {
            this.currentSongIndex = this.songsQueue.size() - 1;
        }
        return songsQueue.get(currentSongIndex);
    }

    public Song stopCurrentSong() {
        this.state = PlayerStates.IDLE;
        return songsQueue.get(currentSongIndex);
    }

    public PlayerStates getState() {
        return state;
    }



}
