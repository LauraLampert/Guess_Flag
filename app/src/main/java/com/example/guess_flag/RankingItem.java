package com.example.guess_flag;

import com.mobsandgeeks.saripaar.annotation.Length;

public class RankingItem {
    @Length(min = 1, max = 4)
    public String nome;
    public int pontuacao;

    public RankingItem(String n, int p){
        this.nome = n;
        this.pontuacao = p;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontiacao() {
        return pontuacao;
    }

    public void setPontiacao(int pontiacao) {
        this.pontuacao = pontiacao;
    }
}
