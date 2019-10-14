package com.models;

public class Point {
    private int i;
    private int j;

    public Point(int _i, int _j){
        this.i = _i;
        this.j = _j;
    }

    public int getRow(){
        return this.i;
    }
    public int getColumn(){
        return this.j;
    }
}
