package com.akhil.snakeandladder.models;

public abstract class IntermediateObject {
    private final Integer startPosition;
    private final Integer endPosition;

    public IntermediateObject(final Integer startPosition, final Integer endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public Integer getStartPosition() {
        return startPosition;
    }

    public Integer getEndPosition() {
        return endPosition;
    }
}
