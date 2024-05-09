package com.example.demo.commands;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.PlayList;
import com.example.demo.services.PlaylistService;

public class CreatePlaylistCommand implements ICommand {

    private PlaylistService playlistService;

    public CreatePlaylistCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        List<Long> ids = new ArrayList<Long>();
        for (int i = 2; i < tokens.size(); i++) {
            ids.add(Long.valueOf(tokens.get(i)));
        }
        PlayList playList = this.playlistService.createPlaylist(tokens.get(1), ids);
        System.out.println(playList);
    }
    
}
