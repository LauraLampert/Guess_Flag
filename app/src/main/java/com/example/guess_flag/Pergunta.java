package com.example.guess_flag;

public class Pergunta {

    private String titulo;
    private String imagem;
    private String[] alternativas;
    private int alternativaCorreta;

    public Pergunta(String titulo, String imagem, String[] alternativas, int alternativaCorreta) {
        this.titulo = titulo;
        this.imagem = imagem;
        this.alternativas = alternativas;
        this.alternativaCorreta = alternativaCorreta;
    }

    public Pergunta() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String[] getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(String[] alternativas) {
        this.alternativas = alternativas;
    }

    public int getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(int alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }
}