package com.example.actividad4gato;
import androidx.appcompat.app.AppCompatActivity;

import android.provider.Settings;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.os.CountDownTimer;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;
import android.app.AlertDialog;
import android.content.DialogInterface;
public class juego extends AppCompatActivity {

   public int turno=1,puntosx=0,puntosO=0;
    String turnoactual = "";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);
        vaciar();
        TextView puntuacioncirculo = findViewById(R.id.puntuacioncirculo),
                puntuacionequis = findViewById(R.id.puntuacionequis);

        Bundle extras = getIntent().getExtras();

        if (extras!= null) {
            puntosO=extras.getInt("puntosO");
            puntosx=extras.getInt("PuntosX");
        }


        puntuacioncirculo.setText(String.valueOf(puntosO));
        puntuacionequis.setText(String.valueOf(puntosx));
        ImageView indicador = findViewById(R.id.indicador);
        Button boton00=findViewById(R.id.boton00),
                boton01=findViewById(R.id.boton01),
                boton02=findViewById(R.id.boton02),
                boton10=findViewById(R.id.boton10),
                boton11=findViewById(R.id.boton11),
                boton12=findViewById(R.id.boton12),
                boton20=findViewById(R.id.boton20),
                boton21=findViewById(R.id.boton21),
                boton22=findViewById(R.id.boton22);

        ArrayList<Button>celdas= new ArrayList<>();
        celdas.add(boton00);
        celdas.add(boton01);
        celdas.add(boton02);
        celdas.add(boton10);
        celdas.add(boton11);
        celdas.add(boton12);
        celdas.add(boton20);
        celdas.add(boton21);
        celdas.add(boton22);






        for (Button b:celdas){
            b.setOnClickListener(view ->
            {
                if (b.getText().toString().equals("")) {
                    if (turno == 1) {
                        b.setText("X");
                        indicador.setImageResource(R.drawable.gatoizquierda);
                        turno = 2;
                    } else {

                        b.setText("O");
                        indicador.setImageResource(R.drawable.gatoderecha);
                        turno = 1;
                    }

                    if (condicionesvictoria(turno)){
                        Bundle bolsita= new Bundle();
                        bolsita.putString("Resultado",turnoactual);
                        bolsita.putInt("puntox",puntosx);
                        bolsita.putInt("puntosO",puntosO);
                        Intent i = new Intent(this, ganador.class);
                        i.putExtras(bolsita);
                        startActivity(i);

                    }
                }
            });
        }
    }
    public boolean condicionesvictoria(int jugador){
        Button boton00=findViewById(R.id.boton00),
                boton01=findViewById(R.id.boton01),
                boton02=findViewById(R.id.boton02),
                boton10=findViewById(R.id.boton10),
                boton11=findViewById(R.id.boton11),
                boton12=findViewById(R.id.boton12),
                boton20=findViewById(R.id.boton20),
                boton21=findViewById(R.id.boton21),
                boton22=findViewById(R.id.boton22);

                String[][] tablero = new String[3][3];


                tablero[0][0]=boton00.getText().toString();
        tablero[0][1]=boton01.getText().toString();
        tablero[0][2]=boton02.getText().toString();
        tablero[1][0]=boton10.getText().toString();
        tablero[1][1]=boton11.getText().toString();
        tablero[1][2]=boton12.getText().toString();
        tablero[2][0]=boton20.getText().toString();
        tablero[2][1]=boton21.getText().toString();
        tablero[2][2]=boton22.getText().toString();
                if (jugador==1){
                    turnoactual="O";
                }else if(jugador==2){
                    turnoactual="X";
                }
        for (int fila = 0; fila < 3; fila++) {
            if (tablero[fila][0].equals(turnoactual)&&tablero[fila][1].equals(turnoactual)&& tablero[fila][2].equals(turnoactual)){
                return true;
            }
        }
        for (int columna = 0; columna < 3; columna++) {
            if (tablero[0][columna].equals(turnoactual) && tablero[1][columna].equals(turnoactual) && tablero[2][columna].equals(turnoactual)) {
                return true;
            }
        }
        if (tablero[0][0].equals(turnoactual) && tablero[1][1].equals(turnoactual) && tablero[2][2].equals(turnoactual)) {
            return true;
        }
        if (tablero[0][2].equals(turnoactual) && tablero[1][1].equals(turnoactual) && tablero[2][0].equals(turnoactual)) {
            return true;
        }

        return relleno(tablero);
    }

    public void vaciar(){
        Button boton00=findViewById(R.id.boton00),
                boton01=findViewById(R.id.boton01),
                boton02=findViewById(R.id.boton02),
                boton10=findViewById(R.id.boton10),
                boton11=findViewById(R.id.boton11),
                boton12=findViewById(R.id.boton12),
                boton20=findViewById(R.id.boton20),
                boton21=findViewById(R.id.boton21),
                boton22=findViewById(R.id.boton22);
        boton00.setText("");
        boton01.setText("");
        boton02.setText("");
        boton10.setText("");
        boton11.setText("");
        boton12.setText("");
        boton20.setText("");
        boton21.setText("");
        boton22.setText("");

    }
    public boolean relleno(String[][] tablero){

        int celdasOcupadas=0;
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                if (!tablero[fila][columna].isEmpty()) {
                    celdasOcupadas++;
                }
            }
        }

        boolean a=celdasOcupadas==(3*3);
        if (a){
            turnoactual="empate";
        }
       return a;
    }

}
