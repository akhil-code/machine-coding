package com.akhil.snakeandladder.models;

/**
 * Model to store the specifics of a ladder.
 */
public class Ladder extends IntermediateObject {

    /**
     * Constructor
     *
     * @param startPosition Entry position of the ladder.
     * @param endPosition Exit position of the ladder.
     */
    public Ladder(final Integer startPosition, final Integer endPosition) {
        super(startPosition, endPosition);
    }

}
