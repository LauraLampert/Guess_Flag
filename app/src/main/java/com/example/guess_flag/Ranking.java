package com.example.guess_flag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ranking {
    public List<RankingItem> rI;

    public Ranking() {
        this.rI = new ArrayList<>();
    }

    public void ordenarTabela(){
        Collections.sort(rI, Comparator.comparingInt(RankingItem::getPontiacao).reversed());
    }

    public void setrI(RankingItem it) {
        this.rI.add(it);
        ordenarTabela();
    }

    public List<RankingItem> getrI() {
        return rI;
    }
}
