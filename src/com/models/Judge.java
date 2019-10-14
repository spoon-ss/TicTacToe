package com.models;

public class Judge {

    static private Judge self;

    static public Judge getJudge(int winningLength){
        if(Judge.self == null){
            Judge.self = new Judge(winningLength);
        }
        return Judge.self;
    }
    static public Judge getJudge() {
        return Judge.self;
    }

    private int winningLength;

    private Judge(int _winningRule){
        this.winningLength = _winningRule;
    }

    public Symbol getResult(Map map){
        int m = map.getHeight();
        int n = map.getWidth();

        for(int i = 0; i < m; i++){
            int XCount = 0;
            int OCount = 0;
            for(int j = 0; j < n; j++){
                Point point = new Point(i, j);
                Symbol sym = map.symbolAt(point);
                if(sym == Symbol.N){
                    XCount = 0;
                    OCount = 0;
                }else if(sym == Symbol.X){
                    XCount += 1;
                    OCount = 0;
                }else if(sym == Symbol.O){
                    XCount = 0;
                    OCount += 1;
                }
                if(XCount == winningLength){
                    return Symbol.X;
                }
                if(OCount == winningLength){
                    return Symbol.O;
                }
            }
        }
        for(int j = 0; j < n; j++){
            int XCount = 0;
            int OCount = 0;
            for(int i = 0; i < m; i++){
                Point point = new Point(i, j);
                Symbol sym = map.symbolAt(point);
                if(sym == Symbol.N){
                    XCount = 0;
                    OCount = 0;
                }else if(sym == Symbol.X){
                    OCount = 0;
                    XCount += 1;
                }else if(sym == Symbol.O){
                    XCount = 0;
                    OCount += 1;
                }
                if(XCount == winningLength){
                    return Symbol.X;
                }
                if(OCount == winningLength){
                    return Symbol.O;
                }
            }
        }
        for(int i = 0; i < m; i++){
            int XCount = 0;
            int OCount = 0;
            for(int ii = i, jj = 0; ii < m && jj < n; ii++, jj++){
                Point point = new Point(ii, jj);
                Symbol sym = map.symbolAt(point);
                if(sym == Symbol.N){
                    XCount = 0;
                    OCount = 0;
                }else if(sym == Symbol.X){
                    XCount += 1;
                    OCount = 0;
                }else if(sym == Symbol.O){
                    XCount = 0;
                    OCount += 1;
                }
                if(XCount == winningLength){
                    return Symbol.X;
                }
                if(OCount == winningLength){
                    return Symbol.O;
                }
            }
            XCount = 0;
            OCount = 0;
            for(int ii = i, jj = 0; ii >= 0 && jj < n; ii--, jj++){
                Point point = new Point(ii, jj);
                Symbol sym = map.symbolAt(point);
                if(sym == Symbol.N){
                    XCount = 0;
                    OCount = 0;
                }else if(sym == Symbol.X){
                    OCount = 0;
                    XCount += 1;
                }else if(sym == Symbol.O){
                    XCount = 0;
                    OCount += 1;
                }
                if(XCount == winningLength){
                    return Symbol.X;
                }
                if(OCount == winningLength){
                    return Symbol.O;
                }
            }
        }
        for(int j = 0; j < n; j++){
            int XCount = 0;
            int OCount = 0;
            for(int ii = 0, jj = j; ii < m && jj < n; ii++, jj++){
                Point point = new Point(ii, jj);
                Symbol sym = map.symbolAt(point);
                if(sym == Symbol.N){
                    XCount = 0;
                    OCount = 0;
                }else if(sym == Symbol.X){
                    OCount = 0;
                    XCount += 1;
                }else if(sym == Symbol.O){
                    XCount = 0;
                    OCount += 1;
                }
                if(XCount == winningLength){
                    return Symbol.X;
                }
                if(OCount == winningLength){
                    return Symbol.O;
                }
            }
            XCount = 0;
            OCount = 0;
            for(int ii = 0, jj = j; ii < m && jj >= 0; ii++, jj--){
                Point point = new Point(ii, jj);
                Symbol sym = map.symbolAt(point);
                if(sym == Symbol.N){
                    XCount = 0;
                    OCount = 0;
                }else if(sym == Symbol.X){
                    OCount = 0;
                    XCount += 1;
                }else if(sym == Symbol.O){
                    XCount = 0;
                    OCount += 1;
                }
                if(XCount == winningLength){
                    return Symbol.X;
                }
                if(OCount == winningLength){
                    return Symbol.O;
                }
            }
        }
        if(map.isFull()){
            return Symbol.T;
        }
        return Symbol.N;
    }

}
