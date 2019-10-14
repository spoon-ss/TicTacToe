package com.models;

import java.nio.channels.Pipe;

public class AISolver {
    private Judge judge;

    public AISolver() {
        this.judge = Judge.getJudge();
    }
    public Point getNextStep(Map map, Symbol mySymbol, Symbol opSymbol){

        map = map.clone();
        int m = map.getHeight();
        int n = map.getWidth();

        Point lastPoint = null;
        Point TPoint = null;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                Point currentPoint = new Point(i, j);
                if(map.symbolAt(currentPoint) != Symbol.N){
                    continue;
                }
                lastPoint = currentPoint;
                map.setPointWithSymbol(currentPoint, mySymbol);
                Symbol result = makeSmartStep(map, opSymbol, mySymbol);
                if(result == mySymbol){
                    map.setPointWithEmpty(currentPoint);
                    return currentPoint;
                }
                if(result == Symbol.T){
                    TPoint = currentPoint;
                }
                map.setPointWithEmpty(currentPoint);
            }
        }
        if(TPoint == null){
            return lastPoint;
        }else{
            return TPoint;
        }
    }
    private Symbol makeSmartStep(Map map, Symbol mySymbol, Symbol opSymbol){

        Symbol result = judge.getResult(map);
        if(result != Symbol.N){
            return result;
        }

        Symbol worstResult = opSymbol;
        int m = map.getHeight();
        int n = map.getWidth();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                Point currentPoint = new Point(i, j);
                if(map.symbolAt(currentPoint) != Symbol.N){
                    continue;
                }
                map.setPointWithSymbol(currentPoint, mySymbol);
                result = makeSmartStep(map, opSymbol, mySymbol);
                if(result == mySymbol){
                    map.setPointWithEmpty(currentPoint);
                    return mySymbol;
                }else if(result == Symbol.T){
                    worstResult = Symbol.T;
                }
                map.setPointWithEmpty(currentPoint);
            }
        }
        return worstResult;
    }
}
