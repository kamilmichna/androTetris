package com.example.androTetris;

public class MatrixObject extends Matrix {
    private final MatrixObjectVariant[] variants;
    public MatrixObjectVariant activeVariant;

    public MatrixObject(MatrixObjectVariant[] variants) {
        this.variants = variants;
        this.activeVariant = variants[0];
    }

    public void rotateObject(String direction) {
      //todo
    }
}
