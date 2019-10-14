package com.models;

import com.models.Symbol;
import com.models.Point;
import javafx.scene.effect.Light;

import java.util.Scanner;

public class Map {
    private Symbol[][] symbols;

    private int width;
    private int height;
    private int size;

    public Map(int _width, int _height){
        this.symbols = new Symbol[_height][_width];
        this.width = _width;
        this.height = _height;
        for(int i = 0; i < _height; i++){
            for(int j = 0; j < _width; j++){
                symbols[i][j] = Symbol.N;
            }
        }
        this.size = 0;
    }

    public Map clone(){
        Map newMap = new Map(width, height);
        for(int i = 0; i < symbols.length; i++){
            for(int j = 0; j < symbols[i].length; j++){
                newMap.symbols[i][j] = this.symbols[i][j];
            }
        }
        newMap.size = this.size;
        return newMap;
    }

    public void printMap(){
        for(int i = 0; i < symbols.length; i++){
            System.out.println("");
            for(int j = 0; j < symbols[i].length; j++){
                System.out.print(this.symbols[i][j] + " | ");
            }
            System.out.println("");
        }
    }
    public void setPointWithSymbol(Point point, Symbol symbol){
        if(symbol != Symbol.X && symbol != Symbol.O){
            throw new IllegalArgumentException("symbol has to be X or O.");
        }
        this.symbols[point.getRow()][point.getColumn()] = symbol;
        this.size += 1;
        return;
    }
    public void setPointWithEmpty(Point point){
        int i = point.getRow();
        int j = point.getColumn();
        if(this.symbols[i][j] == Symbol.N){
            return;
        }
        this.symbols[i][j] = Symbol.N;
        this.size -= 1;
        return;

    }
    public Symbol symbolAt(Point point){
        int i = point.getRow();
        int j = point.getColumn();
        if(i >= 0 && i < height
            && j >= 0 && j < width){
            return symbols[i][j];
        }
        throw new IllegalArgumentException("Index out of range.");
    }
    public Point getValidNextStep(){

        boolean getInput = false;
        int i = -1;
        int j = -1;
        while(!getInput){
            try{
                System.out.println("row: ");
                Scanner scanner = new Scanner(System.in);
                i = scanner.nextInt();
                System.out.println("col: ");
                j = scanner.nextInt();
                getInput = true;
            }catch (Exception e){
                System.out.println("not an integer! try again");
            }
        }
        if(i < 0 || i >= height || j < 0 || j >= width){
            return getValidNextStep();
        }
        if(this.symbols[i][j] != Symbol.N){
            return getValidNextStep();
        }
        return new Point(i, j);
    }

    public boolean isFull(){
        return this.size >= this.width * this.height;
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
