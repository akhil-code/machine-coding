package com.akhil.snakeandladder;

import com.akhil.snakeandladder.handlers.GameHandler;
import com.akhil.snakeandladder.models.Game;
import com.akhil.snakeandladder.models.Ladder;
import com.akhil.snakeandladder.models.Player;
import com.akhil.snakeandladder.models.Snake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        final List<Player> playersList = new ArrayList<>();
        final List<Snake> snakesList = new ArrayList<>();
        final List<Ladder> ladderList = new ArrayList<>();
        final Integer totalCells = 100;

        // Filling temp input
        addTempInput(playersList, snakesList, ladderList);

        final Game game = new Game(playersList, snakesList, ladderList, totalCells);
        final GameHandler gameHandler = new GameHandler(game);
        gameHandler.runGame();
    }

    private static void addTempInput(final List<Player> players, final List<Snake> snakes, final List<Ladder> ladders) {
        Player player1 = new Player("Akhil");
        Player player2 = new Player("Pavan");
        Player player3 = new Player("Karthik");
        Player player4 = new Player("Sai teja");
        players.addAll(Arrays.asList(player1, player2, player3, player4));

        Snake snake1 = new Snake(25, 5);
        Snake snake2 = new Snake(10, 2);
        Snake snake3 = new Snake(45, 38);
        Snake snake4 = new Snake(97, 46);
        Snake snake5 = new Snake(80, 66);
        snakes.addAll(Arrays.asList(snake1, snake2, snake3, snake4, snake5));

        Ladder ladder1 = new Ladder(7, 23);
        Ladder ladder2 = new Ladder(13, 33);
        Ladder ladder3 = new Ladder(67, 72);
        Ladder ladder4 = new Ladder(29, 55);


    }


}
