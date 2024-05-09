package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlayerService;

public class LoadPlaylistCommand implements ICommand {
    private PlayerService playerService;

    public LoadPlaylistCommand(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String playlistName = this.playerService.LoadPlaylist(tokens.get(1));
        System.out.println("Playlist " + playlistName + " is loaded!");
    }
}
