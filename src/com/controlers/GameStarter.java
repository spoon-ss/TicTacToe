package com.controlers;
import com.models.*;
import com.models.Map;

public class GameStarter {
    private Game game;
    private Symbol result;
    public GameStarter(){
        this.game = null;
        this.result = Symbol.N;
    }

    public void playWithTwoHuman(int width, int height, int winningLength,
                             String name1, String name2){
        Map map = new Map(width, height);
        Judge judge = Judge.getJudge(winningLength);
        Player player1 = new HumanPlayer(name1, Symbol.O, map);
        Player player2 = new HumanPlayer(name2, Symbol.X, map);
        this.game = new Game(map, player1, player2, judge);
    }
    public void playWithOneAIAndOneHuman(int width, int height, int winningLength,
                                      String name1, String name2){
        Map map = new Map(width, height);
        Judge judge = Judge.getJudge(winningLength);
        Player player1 = new HumanPlayer(name1, Symbol.O, map);
        Player player2 = new ArtificialPlayer(name2, Symbol.X, map);
        this.game = new Game(map, player1, player2, judge);
    }
    public void play(){
        if(this.game == null){
            return;
        }
        this.result = this.game.run();
        return;
    }
    public Symbol getResult(){
        return this.result;
    }
}
