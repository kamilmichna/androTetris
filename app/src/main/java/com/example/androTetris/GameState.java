package com.example.androTetris;

import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;
public class GameState {
    private final TextView score;
    Matrix matrix;
    MatrixView canvas;
    MatrixObject[] matrixObjects;
    MatrixObject activeObject;

    int currentScore = 0;
    boolean rotated = false;

    public GameState(MatrixView canvas, TextView score) {
        this.setMatrixObjects();
        this.matrix = new Matrix();
        this.setNewActiveObject();
        this.canvas = canvas;
        this.score = score;
    }

    public void onTick() {
        this.gravityHandler();
        matrix.drawMatrixObject(this.activeObject);
    }


    private void gravityHandler() {
        if (!this.checkGravityCollision()) {
            matrix.clearActive();
            matrix.drawMatrixObject(this.activeObject, true);
            this.activeObject.setCurrentPos(this.activeObject.xPos, this.activeObject.yPos + 1);
        } else if (this.activeObject.yPos == 0) {
            this.currentScore = 0;
            this.score.setText("Score: " + this.currentScore);
            this.setMatrixObjects();
            this.matrix = new Matrix();
            this.setNewActiveObject();
        } else {
            matrix.drawMatrixObject(this.activeObject, false, true);
            this.setNewActiveObject();
        }
        checkFilledLine();
    }

    private void checkFilledLine() {
        for (int i = 0; i < 20; i++) {
            if (Arrays.equals(matrix.matrix[i],new char[]{'y', 'y','y','y','y','y','y','y','y','y' })) {
                System.out.println(this.matrix.matrix[i]);
                this.matrix.matrix[i] = "xxxxxxxxxx".toCharArray();
                this.currentScore++;
                this.score.setText("Score: " + currentScore);
            }
        }
    }

    private void setNewActiveObject() {
        this.setMatrixObjects();
        this.activeObject = this.matrixObjects[0];
    }

    public void rotate() {
        matrix.clearActive();
        if (rotated) {
            this.activeObject = this.matrixObjects[0];
        } else {
            this.activeObject = this.matrixObjects[1];
        }
        this.rotated = !this.rotated;
    }

    private boolean checkGravityCollision() {
        int xPos = this.activeObject.xPos;
        int yPos = this.activeObject.yPos;
        int matrixXLen = this.activeObject.activeVariant.matrix[0].length;
        int matrixYLen = this.activeObject.activeVariant.matrix.length;

        if (yPos + matrixYLen == 20) {
            return true;
        }

        for (int i = matrixYLen - 1; i >= 0; i--) {
            for (int j = matrixXLen - 1; j >= 0; j--) {
                if ( this.matrix.matrix[i+yPos+1][j+xPos] == 'y') {
                    return true;
                }
            }
        }
        return false;
    }

    private void setMatrixObjects() {
        char[][] lineMatrix = {{'z', 'z', 'z', 'z'}};
        MatrixObjectVariant lineVariant = new MatrixObjectVariant(lineMatrix);
        MatrixObjectVariant[] lineArr = {lineVariant};
        MatrixObject line = new MatrixObject(lineArr);

        char[][] lineMatrixVert = {{'z'},{'z'}, {'z'}, {'z'}};
        MatrixObjectVariant lineVariantVert = new MatrixObjectVariant(lineMatrixVert);
        MatrixObjectVariant[] lineArrVert = {lineVariantVert};
        MatrixObject lineVert = new MatrixObject(lineArrVert);

        this.matrixObjects = new MatrixObject[]{line, lineVert};
    }
}
