package org.example.models;

public class Bot extends Player{
    public Bot(String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    BotDifficultyLevel botDifficultyLevel;
}
