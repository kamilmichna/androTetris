package com.example.androTetris;

public class MatrixObjectVariant {
    public String direction;
    public char[][] matrix;

    public MatrixObjectVariant(String direction, char[][] matrix){
        this.direction = direction;
        this.matrix = matrix;
    }
}
