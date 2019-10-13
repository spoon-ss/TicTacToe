package com.controlers;
import com.models.*;
import com.views.Map;

public class GameStarter {
    private Game game;
    private String result;
    public GameStarter(){
        this.game = null;
        this.result = "no result!";
    }
    public void addTwoPlayer(String name1, String name2){
        Map map = new Map();
        Player player1 = new HumanPlayer(name1, Symbol.O, map);
        Player player2 = new HumanPlayer(name2, Symbol.X, map);
        Judge judge = new Judge(map);
        this.game = new Game(map, player1, player2, judge);
    }
    public void addOnePlayerWithOneAI(String name1, String name2){
        Map map = new Map();
        Player player1 = new HumanPlayer(name1, Symbol.O, map);
        Player player2 = new ArtificialPlayer(name2, Symbol.X, map);
        Judge judge = new Judge(map);
        this.game = new Game(map, player1, player2, judge);
    }
    public void play(){
        if(this.game == null){
            return;
        }
        this.result = this.game.run();
        return;
    }
    public String getResult(){
        return this.result;
    }
}
