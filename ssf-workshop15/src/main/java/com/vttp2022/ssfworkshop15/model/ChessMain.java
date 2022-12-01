package com.vttp2022.ssfworkshop15.model;

import java.io.Serializable;

public class ChessMain implements Serializable {
    private String name;
    private Pieces pieces;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pieces getPieces() {
        return pieces;
    }

    public void setPieces(Pieces pieces) {
        this.pieces = pieces;
    }
    
}
