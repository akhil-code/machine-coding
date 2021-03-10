package com.akhil.snakeandladder.models;

public class Player {
    private final String name;
    private Integer currentPosition;

    public Player(final String name) {
        this.name = name;
        this.currentPosition = 0;
    }

    public Integer getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(final Integer currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
