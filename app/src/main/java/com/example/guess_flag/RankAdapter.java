package com.example.guess_flag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class RankAdapter extends BaseAdapter {
    private List<RankingItem> lista;
    private Context context;

    public RankAdapter(Context context, List<RankingItem> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.activity_ranking, parent, false);

        TextView rank = view.findViewById(R.id.idRank);
        TextView nome = view.findViewById(R.id.idNome);
        TextView score = view.findViewById(R.id.idPont);

        RankingItem item = lista.get(position);

        rank.setText((position + 1) + "º");
        nome.setText(item.getNome());
        score.setText(String.valueOf(item.getPontiacao()));

        return view;
    }
}
