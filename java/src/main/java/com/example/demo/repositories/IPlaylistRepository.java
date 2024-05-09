package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.PlayList;

public interface IPlaylistRepository {
    PlayList save(PlayList playlist);
    boolean existsByName(String playlistName);
    Optional<PlayList> findByName(String playlistName);
    List<PlayList> findAll();
    void deleteByName(String playlistName);
    long count();
}
