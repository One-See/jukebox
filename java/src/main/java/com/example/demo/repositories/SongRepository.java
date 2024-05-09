package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Song;

public class SongRepository implements ISongRepository{
    private Map<Long, Song> songMap = new HashMap<Long, Song>();

    private long autoIncrementId = 1L;

    @Override
    public Song save(Song song) {
        Song s = new Song(song.getSongName(), song.getArtistName(), song.getAlbumName(), song.getGenre(), autoIncrementId);

        songMap.put(autoIncrementId, s);

        this.autoIncrementId++;

        return s;
    }

    @Override
    public boolean existsById(Long id) {
        return songMap.containsKey(id);
    }

    @Override
    public Optional<Song> findById(Long id) {
        return Optional.of(songMap.get(id));
    }

    @Override
    public List<Song> findAll() {
        return songMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        songMap.remove(id);
        
    }

    @Override
    public long count() {
        return songMap.size();
    }
    
}
