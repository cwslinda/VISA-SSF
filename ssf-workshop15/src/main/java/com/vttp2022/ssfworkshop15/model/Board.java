package com.vttp2022.ssfworkshop15.model;

public class Board {
    private int totalCount;
    private int size;
    private Type[] types;

    public int getTotalCount() { return totalCount; }
    public void setTotalCount(int value) { this.totalCount = value; }

    public int getSize() { return size; }
    public void setSize(int value) { this.size = value; }

    public Type[] getTypes() { return types; }
    public void setTypes(Type[] value) { this.types = value; }
}
