package com.example.androTetris;

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
        if (!this.checkGravityCollision()) {
            matrix.clearActive();
            matrix.drawMatrixObject(this.activeObject, true);
            this.activeObject.setCurrentPos(this.activeObject.xPos, this.activeObject.yPos + 1);
        } else {
            matrix.drawMatrixObject(this.activeObject, false, true);
            this.setNewActiveObject();
        }
    }

    private void setNewActiveObject() {
        //add randomness here
        this.setMatrixObjects();
        this.activeObject = this.matrixObjects[0];
    }

    private boolean checkGravityCollision() {
        int xPos = this.activeObject.xPos;
        int yPos = this.activeObject.yPos;
        int matrixXLen = this.activeObject.activeVariant.matrix[0].length;
        int matrixYLen = this.activeObject.activeVariant.matrix.length;

        if (yPos >= 19) {
            return true;
        }



        for (int i = matrixYLen - 1; i >= 0; i--) {
            for (int j = matrixXLen - 1; j >= 0; j--) {
                System.out.println(j+xPos);
                if ( this.matrix.matrix[i+yPos+1][j+xPos] != 'x') {
                    return true;
                }
            }
        }
        return false;
    }

    private void setMatrixObjects() {
        char[][] lineMatrix = {{'z', 'z', 'z', 'z'}};
        MatrixObjectVariant lineVariant = new MatrixObjectVariant("t", lineMatrix);
        MatrixObjectVariant[] lineArr = {lineVariant};
        MatrixObject line = new MatrixObject(lineArr);

        this.matrixObjects = new MatrixObject[]{line};
    }
}
