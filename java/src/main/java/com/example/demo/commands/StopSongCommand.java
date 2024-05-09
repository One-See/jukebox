package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.services.PlayerService;

public class StopSongCommand implements ICommand {
    private PlayerService playerService;

    public StopSongCommand(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public void invoke(List<String> tokens) {
        Song song = this.playerService.stopCurrentSong();
        System.out.println(song + " is stopped!");
    }
    
}
