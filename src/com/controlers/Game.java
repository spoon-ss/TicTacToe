package com.controlers;
import com.views.Map;
import com.models.*;
public class Game {
    private Map map;
    private Player player1;
    private Player player2;
    private Judge judge;

    public Game(Map _map, Player _player1, Player _player2, Judge _judge){
        this.player1 = _player1;
        this.player2 = _player2;
        this.judge = _judge;
        this.map = _map;
    }
    public String run(){
        while(!judge.hasResult()){
            map.printMap();
            player1.makeMove();
            if(judge.hasResult()){
                break;
            }
            map.printMap();
            player2.makeMove();
            if(judge.hasResult()){
                break;
            }
        }

        map.printMap();
        if(judge.getResult() == player1.getSymbol()){
            return player1.toString() + " has win";
        }else if(judge.getResult() == player2.getSymbol()){
            return player2.toString() + " has win";
        }
        return "Tie!";

    }
}
