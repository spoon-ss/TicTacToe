package com.models;
import com.views.Map;
public class Judge {

    private Map map;
    private Symbol winner;

    public Judge(Map _map){
        this.map = _map;
        this.winner = Symbol.N;
    }
    public boolean hasResult(){
        decideResult();
        if(this.winner == Symbol.N){
            return false;
        }
        return true;
    }
    private void decideResult(){
        Symbol[][] mapCopy = this.map.getCopy();
        if(map.isFull()){
            this.winner = Symbol.T;
            return;
        }
        for(int i = 0; i < 3; i++){
            int xCount = 0;
            int oCount = 0;
            for(int j = 0; j < 3; j++){
                if(mapCopy[i][j] == Symbol.X){
                    xCount += 1;
                }else if(mapCopy[i][j] == Symbol.O){
                    oCount += 1;
                }
            }
            if(xCount == 3){
                this.winner = Symbol.X;
                return;
            }
            if(oCount == 3){
                this.winner = Symbol.O;
                return;
            }
        }
        for(int i = 0; i < 3; i++){
            int xCount = 0;
            int oCount = 0;
            for(int j = 0; j < 3; j++){
                if(mapCopy[j][i] == Symbol.X){
                    xCount += 1;
                }else if(mapCopy[j][i] == Symbol.O){
                    oCount += 1;
                }
            }
            if(xCount == 3){
                this.winner = Symbol.X;
                return;
            }
            if(oCount == 3){
                this.winner = Symbol.O;
                return;
            }
        }
        int xCount = 0;
        int oCount = 0;
        for(int i = 0; i < 3; i++){
            if(mapCopy[i][i] == Symbol.X){
                xCount += 1;
            }else if(mapCopy[i][i] == Symbol.O){
                oCount += 1;
            }
        }
        if(xCount == 3){
            this.winner = Symbol.X;
            return;
        }
        if(oCount == 3){
            this.winner = Symbol.O;
            return;
        }

        xCount = 0;
        oCount = 0;
        for(int i = 0; i < 3; i++){
            if(mapCopy[i][2 - i] == Symbol.X){
                xCount += 1;
            }else if(mapCopy[i][2 - i] == Symbol.O){
                oCount += 1;
            }
        }
        if(xCount == 3){
            this.winner = Symbol.X;
            return;
        }
        if(oCount == 3){
            this.winner = Symbol.O;
            return;
        }
        return;
    }
    public Symbol getResult(){
        return this.winner;
    }
}
