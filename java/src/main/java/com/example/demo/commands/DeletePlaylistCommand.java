package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.PlayList;
import com.example.demo.services.PlaylistService;

public class DeletePlaylistCommand implements ICommand {
    private PlaylistService playlistService;

    public DeletePlaylistCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String playlist = this.playlistService.deletePlaylist(tokens.get(1));
        System.out.println("Playlist " + playlist + " is deleted!");
    }
}
