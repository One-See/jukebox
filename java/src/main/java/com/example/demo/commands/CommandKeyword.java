package com.example.demo.commands;

public enum CommandKeyword {

    // Register Command Keywords
    ADD_SONG_COMMAND("ADD_SONG"),
    CREATE_PLAYLIST_COMMAND ("CREATE_PLAYLIST"),
    ADD_SONG_TO_PLAYLIST_COMMAND ("ADD_SONG_TO_PLAYLIST"),
    DELETE_SONG_FROM_PLAYLIST_COMMAND("DELETE_SONG_FROM_PLAYLIST"),
    DELETE_PLAYLIST_COMMAND("DELETE_PLAYLIST"),
    LOAD_PLAYLIST_COMMAND("LOAD_PLAYLIST"),
    PLAY_SONG_COMMAND("PLAY_SONG"),
    NEXT_SONG_COMMAND("NEXT_SONG"),
    PREVIOUS_SONG_COMMAND("PREVIOUS_SONG"),
    STOP_SONG_COMMAND("STOP_SONG"),
    LIST_SONGS_COMMAND("LIST_SONGS");

    private final String name;
    private CommandKeyword(String name){
        this.name = name;
    }

    public String getName() {
        return name;
     } 
}
