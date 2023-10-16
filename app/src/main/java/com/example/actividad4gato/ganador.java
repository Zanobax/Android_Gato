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

public class ganador extends AppCompatActivity implements View.OnClickListener {
   public int puntoO,
    puntoX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ganador);
        Button volver=findViewById(R.id.again),
        reset=findViewById(R.id.reiniciar);
        ImageView elx=findViewById(R.id.elx),
                elO=findViewById(R.id.elO);

        TextView puntuacionxd=findViewById(R.id.puntuacionx),
                puntuacionoo=findViewById(R.id.puntuacionO),
        resultado=findViewById(R.id.resultado);



        volver.setOnClickListener(this);
        reset.setOnClickListener(this);
        String res=getIntent().getExtras().getString("Resultado");
         puntoO=getIntent().getExtras().getInt("puntosO");
         puntoX=getIntent().getExtras().getInt("puntox");


        if (res.equals("O")) {

            resultado.setText("El ganador es O");
            elO.setImageResource(R.drawable.victoriaoo);
            elx.setImageResource(R.drawable.pierdex);
            puntoO++;
            puntuacionoo.setText(String.valueOf(puntoO));
            puntuacionxd.setText(String.valueOf(puntoX));
        }else if (res.equals("X")) {
            resultado.setText("El ganador es X");
            elO.setImageResource(R.drawable.pierdeo);
            puntoX++;
            elx.setImageResource(R.drawable.victoriax);
            puntuacionoo.setText(String.valueOf(puntoO));
            puntuacionxd.setText(String.valueOf(puntoX));
        }else if (res.equals("empate")) {
            resultado.setText("Es un empate");
            elO.setImageResource(R.drawable.pierdeo);
            elx.setImageResource(R.drawable.pierdex);
            puntuacionoo.setText(String.valueOf(puntoO));
            puntuacionxd.setText(String.valueOf(puntoX));
        }







    }


    @Override
    public void onClick(View view) {
    if (view.getId()==R.id.again) {
        Bundle devuelta = new Bundle();
        devuelta.putInt("puntosO", puntoO);
        devuelta.putInt("PuntosX", puntoX);

        Intent vuelta = new Intent(this, juego.class);
        vuelta.putExtras(devuelta);
        startActivity(vuelta);
    } else if (view.getId()==R.id.reiniciar) {
        TextView puntuacionx=findViewById(R.id.puntuacionx),
                puntuaciono=findViewById(R.id.puntuacionO);
        puntoO=0;
        puntoX=0;
        puntuacionx.setText(String.valueOf(puntoX));
        puntuaciono.setText(String.valueOf(puntoO));
    }
    }
}
