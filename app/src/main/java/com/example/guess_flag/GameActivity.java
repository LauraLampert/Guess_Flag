package com.example.guess_flag;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private Button btn_verifica;
    private ImageView imagemBandeira;
    private TextView tituloPergunta;
    private EditText palpite;

    private ArrayList<Pergunta> perguntas;
    private int perguntaAtual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        btn_verifica = findViewById(R.id.btn_verifica);
        imagemBandeira = findViewById(R.id.imagemBandeira);
        tituloPergunta = findViewById(R.id.tituloPergunta);
        palpite = findViewById(R.id.palpite);

        perguntas = new ArrayList<>();

        perguntas.add(new Pergunta(
                "Qual é este país?",
                "https://flagcdn.com/w320/br.png",
                new String[]{"Brasil"},
                0));

        perguntas.add(new Pergunta(
                "Qual é este país?",
                "https://flagcdn.com/w320/us.png",
                new String[]{"Estados Unidos"},
                0));

        perguntas.add(new Pergunta(
                "Qual é este país?",
                "https://flagcdn.com/w320/jp.png",
                new String[]{"Japão"},
                0));

        loadQuestion(perguntas.get(perguntaAtual));

        btn_verifica.setOnClickListener(v -> {

            String resposta = palpite.getText().toString().trim();

            String respostaCorreta = perguntas.get(perguntaAtual)
                    .getAlternativas()[perguntas.get(perguntaAtual).getAlternativaCorreta()];

            if (resposta.equalsIgnoreCase(respostaCorreta)) {
                Toast.makeText(this, "Correto!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Errado!", Toast.LENGTH_SHORT).show();
            }

            palpite.setText("");

            perguntaAtual++;

            if (perguntaAtual < perguntas.size()) {

                loadQuestion(perguntas.get(perguntaAtual));

            } else {

                tituloPergunta.setText("Fim do jogo!");

                new android.os.Handler().postDelayed(() -> {

                    Intent intent = new Intent(GameActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Fecha a GameActivity

                }, 1500);

            }

        });
    }

    private void loadQuestion(Pergunta pergunta) {

        tituloPergunta.setText(pergunta.getTitulo());

        Glide.with(this)
                .load(pergunta.getImagem())
                .into(imagemBandeira);
    }
}