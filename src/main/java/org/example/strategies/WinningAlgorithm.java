package org.example.strategies;

import org.example.models.Board;
import org.example.models.Move;

import java.util.HashMap;

public class WinningAlgorithm {
    HashMap<Integer, HashMap<Character,Integer>> rowMap = new HashMap<>();
    HashMap<Integer, HashMap<Character,Integer>> colMap = new HashMap<>();
    HashMap<Character,Integer> leftDiagonal  = new HashMap<>();
    HashMap<Character,Integer> rightDiagonal  = new HashMap<>();

    public boolean checkWinner(Board board, Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character character = move.getPlayer().getSymbol().getCharacter();

        //For Rows

        if(!rowMap.containsKey(row)){
            rowMap.put(row, new HashMap<>());
        }
        HashMap<Character, Integer> currRowMap = rowMap.get(row);

        if(!currRowMap.containsKey(character)){
            currRowMap.put(character, 1);
        }
        else{
            currRowMap.put(character, currRowMap.get(character) + 1);
        }
        if(currRowMap.get(character) == board.getSize()){
            return true;
        }

        //For Columns

        if(!colMap.containsKey(col)){
            colMap.put(col, new HashMap<>());
        }
        HashMap<Character, Integer> currColMap = colMap.get(col);

        if(!currColMap.containsKey(character)){
            currColMap.put(character, 1);
        }
        else{
            currColMap.put(character, currColMap.get(character) + 1);
        }
        if(currColMap.get(character) == board.getSize()){
            return true;
        }

        //Left Diagonal

        if(row == col){
            if(!leftDiagonal.containsKey(character)){
                leftDiagonal.put(character, 1);
            }
            else{
                leftDiagonal.put(character, leftDiagonal.get(character) + 1);
            }

            if(leftDiagonal.get(character) == board.getSize()){
                return true;
            }
        }

        //Right Diagonal

        if(row + col == board.getSize()-1){
            if(!rightDiagonal.containsKey(character)){
                rightDiagonal.put(character, 1);
            }
            else{
                rightDiagonal.put(character, rightDiagonal.get(character) + 1);
            }

            if(rightDiagonal.get(character) == board.getSize()){
                return true;
            }
        }

        return false;

    }
}
