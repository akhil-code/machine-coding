package com.akhil.snakeandladder.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    /** List of players who have not completed the game. */
    private List<Player> playersLeft;
    /** List of snakes */
    private List<Snake> snakes;
    /** List of ladders */
    private List<Ladder> ladders;
    /** Map that stores if a specific snake or ladder is present at the given position on the board
     *  Key - position on the board
     *  Value - Snake / ladder object. Will be null if nothing is present.
    */
    private Map<Integer, IntermediateObject> board;
    /** Stores list of winners in the sorted fashion. The first element represents the player in first position. */
    private List<Player> sortedWinners;
    /** Total number of cells on the board*/
    private Integer totalCells;

    public Game(final List<Player> playersLeft, final List<Snake> snakes, final List<Ladder> ladders, final Integer totalCells) {
        this.playersLeft = playersLeft;
        this.snakes = snakes;
        this.ladders = ladders;
        this.board = initBoard(snakes, ladders);
        this.totalCells = totalCells;
        sortedWinners = new ArrayList<>();
    }

    /**
     * Initializes {@link Game#board} object with snakes and ladders present.
     *
     * @param snakes list of all snakes.
     * @param ladders list of all ladders.
     * @return {@link Game#board}
     */
    private Map<Integer, IntermediateObject> initBoard(final List<Snake> snakes, List<Ladder> ladders) {
        final Map<Integer, IntermediateObject> newBoard = new HashMap<>();
        snakes.stream().forEach(snake -> newBoard.put(snake.getStartPosition(), snake));
        ladders.stream().forEach(ladder -> newBoard.put(ladder.getStartPosition(), ladder));
        return newBoard;
    }

    /** SETTERS */

    public void setPlayersLeft(List<Player> playersLeft) {
        this.playersLeft = playersLeft;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public void setBoard(Map<Integer, IntermediateObject> board) {
        this.board = board;
    }

    public void setSortedWinners(List<Player> sortedWinners) {
        this.sortedWinners = sortedWinners;
    }

    /** GETTERS */

    public List<Player> getPlayersLeft() {
        return playersLeft;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public Map<Integer, IntermediateObject> getBoard() {
        return board;
    }

    public List<Player> getSortedWinners() {
        return sortedWinners;
    }

    public Integer getTotalCells() {
        return totalCells;
    }
}
