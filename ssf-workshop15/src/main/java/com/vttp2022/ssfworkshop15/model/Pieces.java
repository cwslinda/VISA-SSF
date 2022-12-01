package com.vttp2022.ssfworkshop15.model;

public class Pieces {
    private Rulebook rulebook;
    private Board board;
    private Units units;

    public Rulebook getRulebook() { return rulebook; }
    public void setRulebook(Rulebook value) { this.rulebook = value; }

    public Board getBoard() { return board; }
    public void setBoard(Board value) { this.board = value; }

    public Units getUnits() { return units; }
    public void setUnits(Units value) { this.units = value; }
}