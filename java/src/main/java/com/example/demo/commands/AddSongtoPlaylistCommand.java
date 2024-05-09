package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.services.PlaylistService;

public class AddSongtoPlaylistCommand implements ICommand {
    private PlaylistService playlistService;

    public AddSongtoPlaylistCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        List<Song> songs = this.playlistService.addSongToPlayList(tokens.get(1), Long.valueOf(tokens.get(2)));
        System.out.println("Playlist "+ tokens.get(1) + " is revised with " + songs);
    }
}
