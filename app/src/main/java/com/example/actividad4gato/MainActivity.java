package com.example.actividad4gato;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ProgressBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private ProgressBar progBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progBar = findViewById(R.id.progressBar);

        long msFuture = 4000;

        progBar.setMax((int)msFuture);


        new CountDownTimer(msFuture, 1000) {

            public void onTick(long restante) {
                progBar.setProgress((int)restante);
            }


            public void onFinish() {
                startActivity(new Intent(MainActivity.this,juego.class));
            }
        }.start();

    }



}