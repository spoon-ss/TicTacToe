package com.models;

public class HumanPlayer implements Player{
    private String name;
    private Symbol symbol;
    private Map map;

    public HumanPlayer(String _name, Symbol _symbol, Map _map){
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
        Point nextPoint = this.map.getValidNextStep();
        this.map.setPointWithSymbol(nextPoint, this.symbol);
        return;

    }
    public String toString(){
        return this.name;
    }
}
