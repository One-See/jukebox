package com.example.demo.entities;

public enum PlayerStates {
    IDLE("idle"), PLAYING("playing"), PAUSED("paused");

    private String state;

    PlayerStates(String state) {
        this.state = state;
    }

    String getState() {
        return state;
    }
}
