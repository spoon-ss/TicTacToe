package com.controlers;
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
    public Symbol run(){
        while(judge.getResult(map) == Symbol.N){
            map.printMap();
            player1.makeMove();
            if(judge.getResult(map) != Symbol.N){
                break;
            }
            map.printMap();
            player2.makeMove();
            if(judge.getResult(map) != Symbol.N){
                break;
            }
        }

        map.printMap();

        Symbol result = judge.getResult(map);
        return result;

    }
}
