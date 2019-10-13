package com.views;

import com.models.Symbol;
import com.models.Point;

import java.util.Scanner;

public class Map {
    private Symbol[][] symbols;
    private int size;

    public Map(){
        this.symbols = new Symbol[3][3];
        for(int i = 0; i < symbols.length; i++){
            for(int j = 0; j < this.symbols.length; j++){
                symbols[i][j] = Symbol.N;
            }
        }
        this.size = 0;
    }
    public Symbol[][] getCopy(){
        Symbol[][] copy = new Symbol[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                copy[i][j] = this.symbols[i][j];
            }
        }
        return copy;
    }
    public void printMap(){
        for(int i = 0; i < 3; i++){
            System.out.println("");
            for(int j = 0; j < 3; j++){
                System.out.print(this.symbols[i][j] + " | ");
            }
            System.out.println("");
        }
    }
    public void setPointWithSymbol(Point point, Symbol symbol){
        this.symbols[point.getY()][point.getX()] = symbol;
        this.size += 1;
        System.out.println(this.size);
        return;
    }
    public Point getValidNextStep(){

        boolean getInput = false;
        int x = -1;
        int y = -1;
        while(!getInput){
            try{
                System.out.println("x: ");
                Scanner scanner = new Scanner(System.in);
                x = scanner.nextInt();
                System.out.println("y: ");
                y = scanner.nextInt();
                getInput = true;
            }catch (Exception e){
                System.out.println("not an integer! try again");
            }
        }
        if(x < 0 || x >= 3 || y < 0 || y >= 3){
            return getValidNextStep();
        }
        if(this.symbols[y][x] != Symbol.N){
            return getValidNextStep();
        }
        return new Point(x, y);
    }

    public boolean isFull(){
        return this.size >= 9;
    }

}
