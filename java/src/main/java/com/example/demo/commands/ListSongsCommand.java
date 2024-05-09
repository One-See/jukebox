package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.services.SongService;


public class ListSongsCommand implements ICommand {
    private SongService songService;

    public ListSongsCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        List<Song> songs = this.songService.listSongs();
        System.out.println(songs);
    }
}
