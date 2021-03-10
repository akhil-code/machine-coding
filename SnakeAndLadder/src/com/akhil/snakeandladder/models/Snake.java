package com.akhil.snakeandladder.models;

/**
 * Model to store specifics of a snake.
 */
public class Snake extends IntermediateObject {
    /**
     * Constructor.
     *
     * @param startPosition Head of the snake.
     * @param endPosition Tail of the snake.
     */
    public Snake(final Integer startPosition, final Integer endPosition) {
        super(startPosition, endPosition);
    }

}
