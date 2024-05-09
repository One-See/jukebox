package com.example.demo.commands;
import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.services.PlayerService;

public class PreviousSongCommand implements ICommand {
    private PlayerService playerService;

    public PreviousSongCommand(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public void invoke(List<String> tokens) {
        Song song = this.playerService.playPreviousSong();
        System.out.println(song + " is playing!");
    }
}
