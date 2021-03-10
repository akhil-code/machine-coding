package com.akhil.snakeandladder.handlers;

import com.akhil.snakeandladder.models.*;

import java.util.Iterator;
import java.util.Random;

public class GameHandler {

    private final Game game;
    private final Random randomNumberGenerator;

    public GameHandler(final Game game) {
        this.game = game;
        this.randomNumberGenerator = new Random();
    }

    public void runGame() {
        while(game.getPlayersLeft().size() > 1) {
            final Iterator<Player> playerIterator = game.getPlayersLeft().iterator();
            executeNextStep(playerIterator);
        }
        System.out.println("Game completed list of winners " + game.getSortedWinners());
    }


    private void executeNextStep(final Iterator<Player> playerIterator) {
        while(playerIterator.hasNext()) {
            final Player currentPlayer = playerIterator.next();
            // throw dice
            final Integer diceOutcome = this.throwDice();
            // add the outcome of dice to the player position
            Integer newPosition = currentPlayer.getCurrentPosition() + diceOutcome;
            // if out of bounds then return, else proceed
            if (newPosition > game.getTotalCells()) {
                continue;
            }
            // check for presence of snakes and ladders
            if (game.getBoard().containsKey(newPosition)) {
                final IntermediateObject intermediateObject = game.getBoard().get(newPosition);
                if (intermediateObject instanceof Snake) {
                    final Snake snake = (Snake) intermediateObject;
                    newPosition = snake.getEndPosition();
                } else {
                    final Ladder ladder = (Ladder) intermediateObject;
                    newPosition = ladder.getEndPosition();
                }
            }

            // Print the output
            System.out.println(String.format("%s rolled a %d and moved from %d to %d ", currentPlayer.getName(),
                    diceOutcome, currentPlayer.getCurrentPosition(), newPosition));
            currentPlayer.setCurrentPosition(newPosition);

            // If reached the destination then end the game for the current player.
            if (newPosition == 100) {
                game.getSortedWinners().add(currentPlayer);
                playerIterator.remove();
            }
        }
    }

    private Integer throwDice() {
        return randomNumberGenerator.nextInt(6) + 1;
    }
}
