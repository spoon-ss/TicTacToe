package com.models;
import com.views.Map;

import java.util.Arrays;

public class ArtificialPlayer implements Player {
    private String name;
    private Symbol symbol;
    private Map map;

    public ArtificialPlayer(String _name, Symbol _symbol, Map _map){
        this.name = _name;
        this.symbol = _symbol;
        this.map = _map;
    }
    public void setName(String _name){
        this.name = _name;
    }

    public String getName(){
        return this.name;
    }

    public void setSymbol(Symbol _symbol){
        this.symbol = _symbol;
    }

    public Symbol getSymbol(){
        return this.symbol;
    }

    public void makeMove(){
        Symbol[][] symbols = this.map.getCopy();
        Symbol opChoice = this.symbol == Symbol.X ? Symbol.O : Symbol.X;
        Symbol worstResult = opChoice;
        Point next = null;
        Point TPoint = null;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.println(symbols[i][j]);
                if(symbols[i][j] != Symbol.N){
                    continue;
                }

                next = new Point(j, i);
                symbols[i][j] = this.symbol;
                Symbol result = getResult(symbols, j, i, this.symbol, opChoice);
                if(result != Symbol.N){
                    this.map.setPointWithSymbol(next, this.symbol);
                    return;
                }
                result = makeSmartMove(symbols, opChoice, this.symbol);
                if(result == this.symbol){
                    this.map.setPointWithSymbol(next, this.symbol);
                    return;
                }
                if(result == Symbol.T){
                    TPoint = next;
                }
                symbols[i][j] = Symbol.N;
            }
        }
        if(TPoint == null){
            this.map.setPointWithSymbol(next, this.symbol);
        }else{
            this.map.setPointWithSymbol(TPoint, this.symbol);
        }
    }

    private Symbol makeSmartMove(Symbol[][] symbols, Symbol myChoice, Symbol opChoice){
        Symbol worstResult = opChoice;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(symbols[i][j] != Symbol.N){
                    continue;
                }
                symbols[i][j] = myChoice;
                Symbol result = getResult(symbols, j, i, myChoice, opChoice);
                if(result != Symbol.N){
                    symbols[i][j] = Symbol.N;
                    return result;
                }
                result = makeSmartMove(symbols, opChoice, myChoice);
                if(result == myChoice){
                    symbols[i][j] = Symbol.N;
                    return myChoice;
                }else if(result == Symbol.T){
                    worstResult = Symbol.T;
                }
                symbols[i][j] = Symbol.N;
            }
        }
        return worstResult;
    }

    private Symbol getResult(Symbol[][] symbols, int x, int y, Symbol myChoice, Symbol opChoice){
        int myCount = 0;
        int opCount = 0;
        for(int i = 0; i < 3; i++){
            if(symbols[i][x] == myChoice){
                myCount += 1;
            }else if(symbols[i][x] == opChoice){
                opCount += 1;
            }
        }
        if(myCount == 3){
            return myChoice;
        }
        if(opCount == 3){
            return opChoice;
        }

        myCount = 0;
        opCount = 0;
        for(int i = 0; i < 3; i++){
            if(symbols[y][i] == myChoice){
                myCount += 1;
            }else if(symbols[y][i] == opChoice){
                opCount += 1;
            }
        }
        if(myCount == 3){
            return myChoice;
        }
        if(opCount == 3){
            return opChoice;
        }

        myCount = 0;
        opCount = 0;
        for(int i = 0; i < 3; i++){
            if(symbols[i][i] == myChoice){
                myCount += 1;
            }else if(symbols[i][i] == opChoice){
                opCount += 1;
            }
        }
        if(myCount == 3){
            return myChoice;
        }
        if(opCount == 3){
            return opChoice;
        }

        myCount = 0;
        opCount = 0;
        for(int i = 0; i < 3; i++){
            if(symbols[i][2 - i] == myChoice){
                myCount += 1;
            }else if(symbols[i][2 - i] == opChoice){
                opCount += 1;
            }
        }
        if(myCount == 3){
            return myChoice;
        }
        if(opCount == 3){
            return opChoice;
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(symbols[i][j] == Symbol.N){
                    return Symbol.N;
                }
            }
        }
        return Symbol.T;
    }
}
