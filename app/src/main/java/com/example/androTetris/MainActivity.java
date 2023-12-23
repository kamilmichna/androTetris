package com.example.androTetris;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MatrixView canvas = findViewById(R.id.canvas);
        Matrix matrix = new Matrix();
        canvas.setMatrix(matrix.matrix);
    }
}