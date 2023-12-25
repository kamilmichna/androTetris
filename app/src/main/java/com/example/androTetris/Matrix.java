package com.example.androTetris;


// x for empty space
// y for active block
// z for inactive blocks
public class Matrix {
    public char[][] matrix;
    public Matrix() {
        this.matrix = getDefaultMatrix();
    }


    public void drawMatrixObject(MatrixObject obj, boolean... clear) {
        int yLen = obj.activeVariant.matrix.length;
        int xLen = obj.activeVariant.matrix[0].length;
        boolean shouldClear = clear.length >= 1 ? clear[0] : false;
        boolean markAsOld = clear.length >= 2 ? clear[1] : false;
        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                if (shouldClear) {
                    this.matrix[y+obj.yPos][x+obj.xPos] = 'x';
                } else if (markAsOld) {
                    this.matrix[y+obj.yPos][x+obj.xPos] = 'y';
                } else {
                    this.matrix[y+obj.yPos][x+obj.xPos] = obj.activeVariant.matrix[y][x];
                }
            }
        }
    }


    public void clearActive() {
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 10; x++) {
                if (matrix[y][x] == 'z') {
                    matrix[y][x] = 'x';
                }
            }
        }
    }
    private char[][] getDefaultMatrix() {
        char[][] arr = {
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}
        };
        return arr;
    }
}
