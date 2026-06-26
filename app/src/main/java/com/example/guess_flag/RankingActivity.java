package com.example.guess_flag;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class RankingActivity extends AppCompatActivity {
    public ListView listaRank;
    public RankAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        listaRank = findViewById(R.id.listRanking);

        RankingItem item1 = new RankingItem("Laura", 121);
        Ranking rk = new Ranking();

        rk.setrI(item1);

        adapter = new RankAdapter(this, rk.getrI());

        listaRank.setAdapter(adapter);

    }

}
