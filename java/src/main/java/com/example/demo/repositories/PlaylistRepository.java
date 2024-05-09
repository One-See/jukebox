package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.PlayList;

public class PlaylistRepository implements IPlaylistRepository {
    Map<String, PlayList> playlistMap = new HashMap<String, PlayList>();

    Long autoIncrementId = 1L;

    @Override
    public PlayList save(PlayList playlist) {
        PlayList p = new PlayList(playlist.getPlayListName(), playlist.getSongs(), autoIncrementId);
        this.autoIncrementId++;
        playlistMap.put(playlist.getPlayListName(), p);
        return p;
    }

    @Override
    public boolean existsByName(String playlistName) {
        return playlistMap.containsKey(playlistName);
    }

    @Override
    public Optional<PlayList> findByName(String playlistName) {
        return Optional.of(playlistMap.get(playlistName));
    }

    @Override
    public List<PlayList> findAll() {
        return playlistMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteByName(String playlistName) {
        playlistMap.remove(playlistName);        
    }

    @Override
    public long count() {
        return playlistMap.size();
    }
    
}
