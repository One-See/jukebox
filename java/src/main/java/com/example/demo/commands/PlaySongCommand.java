package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.PlayerStates;
import com.example.demo.entities.Song;
import com.example.demo.services.PlayerService;

public class PlaySongCommand implements ICommand {
    private PlayerService playerService;

    public PlaySongCommand(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public void invoke(List<String> tokens) {
        Song song = this.playerService.playSong();
        if (this.playerService.getState() == PlayerStates.PLAYING) {
            System.out.println(song + " is playing!");
        } else {
            System.out.println(song + " is paused!");
        }
    }
}
