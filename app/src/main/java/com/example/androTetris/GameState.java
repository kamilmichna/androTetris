package com.example.androTetris;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

public class GameState {
    Matrix matrix;
    MatrixView canvas;
    MatrixObject[] matrixObjects;
    MatrixObject activeObject;

    public GameState(MatrixView canvas) {
        this.setMatrixObjects();
        this.matrix = new Matrix();
        this.setNewActiveObject();
        this.canvas = canvas;
    }

    public void onTick() {
        this.gravityHandler();
        matrix.drawMatrixObject(this.activeObject);
    }


    private void gravityHandler() {
        if (this.activeObject.yPos < 19) {
            matrix.drawMatrixObject(this.activeObject, true);
            this.activeObject.setCurrentPos(this.activeObject.xPos, this.activeObject.yPos + 1);
        } else {
            matrix.drawMatrixObject(this.activeObject, false, true);
            this.setNewActiveObject();
            System.out.println(this.activeObject.yPos);
        }
    }

    private void setNewActiveObject() {
        //add randomness here
        this.setMatrixObjects();
        this.activeObject = this.matrixObjects[0];
    }

    private void checkCollisions() {
//        todo
    }

    private void setMatrixObjects() {
        char[][] lineMatrix = {{'z', 'z', 'z', 'z'}};
        MatrixObjectVariant lineVariant = new MatrixObjectVariant("t", lineMatrix);
        MatrixObjectVariant[] lineArr = {lineVariant};
        MatrixObject line = new MatrixObject(lineArr);

        this.matrixObjects = new MatrixObject[]{line};
    }
}
