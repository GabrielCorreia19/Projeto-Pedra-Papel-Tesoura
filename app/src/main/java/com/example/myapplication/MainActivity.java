package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("Pedra");
    }
    public void selecionadoPapel(View view){
        this.opcaoSelecionada("Papel");
    }
    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("Tesoura");
    }


    public void opcaoSelecionada(String opcaoSelecionada){

        ImageView imagemResultado = (ImageView) findViewById(R.id.imageResultado);
        TextView textoResultado = (TextView) findViewById(R.id.textResultado);

        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int numero = new Random().nextInt(3);
        String opcaoApp = opcoes[numero];

        switch (opcaoApp){
            case "Pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if(
        (opcaoApp == "Pedra" && opcaoSelecionada == "Tesoura") ||
        (opcaoApp == "Papel" && opcaoSelecionada == "Pedra") ||
        (opcaoApp == "Tesoura" && opcaoSelecionada == "Papel")
        ){
            textoResultado.setText("Você Perdeu :( ");
        } else if(
       (opcaoSelecionada == "Pedra" && opcaoApp == "Tesoura") ||
       (opcaoSelecionada == "Papel" && opcaoApp == "Pedra")   ||
       (opcaoSelecionada == "Tesoura" && opcaoApp == "Papel")
        ){
            textoResultado.setText("Você ganhou :) ");
        } else {
            textoResultado.setText("O round empatou ;D");
        }
    }
}
