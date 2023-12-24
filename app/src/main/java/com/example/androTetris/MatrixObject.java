package com.example.androTetris;

import androidx.annotation.NonNull;

public class MatrixObject extends Matrix {
    private final MatrixObjectVariant[] variants;
    public MatrixObjectVariant activeVariant;
    public int xPos;
    public int yPos;

    public MatrixObject(MatrixObjectVariant[] variants) {
        this.variants = variants;
        this.activeVariant = variants[0];
    }

    public void setCurrentPos(int x, int y) {
        this.xPos = x;
        this.yPos = y;
    }

    @NonNull
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
