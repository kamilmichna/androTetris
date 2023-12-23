package com.example.androTetris;

public class MatrixObject extends Matrix {
    private final MatrixObjectVariant[] variants;
    private MatrixObjectVariant activeVariant;

    public MatrixObject(String[][] matrix, MatrixObjectVariant[] variants) {
//        super(matrix);
        this.variants = variants;
    }

    public void rotateObject(String direction) {
      //todo
    }
}
