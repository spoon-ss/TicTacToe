package com.models;

public enum Symbol {
    X("X"), O("O"), N("N"), T("T");

    private final String symbol;

    private Symbol(final String symbolName){
        symbol = symbolName;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
