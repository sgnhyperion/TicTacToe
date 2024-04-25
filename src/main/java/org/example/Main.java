package org.example;

import org.example.controller.GameController;
import org.example.exceptions.InvalidMoveException;
import org.example.models.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        GameController gameController = new GameController();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the game dimension");
        int dimension = sc.nextInt();

        List<Player> players = List.of(
                new Player("Harsh", new Symbol('X'), PlayerType.HUMAN),
                new Bot("Bot1", new Symbol('O'), PlayerType.BOT)
        );

        Game game = gameController.StartGame(dimension,players);

        while(game.getGameState().equals(GameState.IN_PROGRESS)){
            gameController.printBoard(game);
            gameController.makeMove(game);
        }

        if(!game.getGameState().equals(GameState.ENDED)){
            game.setGameState(GameState.DRAW);
            System.out.println("DRAW");
        } else{
            gameController.printBoard(game);
            System.out.println("Player " + gameController.getWinner(game).getName()+" is the Winner");
        }
    }
}