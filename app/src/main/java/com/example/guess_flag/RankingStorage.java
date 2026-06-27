package br.ifsul.ads;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RankingStorage {
    private static final String PREFS = "ranking";
    private static final String CHAVE_ITENS = "itens";
    private static final String CAMPO_NOME = "nome";
    private static final String CAMPO_PONTUACAO = "pontuacao";

    public static void adicionar(Context context, RankingItem item) {
        List<RankingItem> itens = listar(context);
        itens.add(item);
        salvar(context, itens);
    }

    public static List<RankingItem> listar(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        String json = prefs.getString(CHAVE_ITENS, "[]");
        List<RankingItem> itens = new ArrayList<>();

        try {
            JSONArray array = new JSONArray(json);

            for (int i = 0; i < array.length(); i++) {
                JSONObject objeto = array.getJSONObject(i);
                String nome = objeto.getString(CAMPO_NOME);
                int pontuacao = objeto.getInt(CAMPO_PONTUACAO);

                itens.add(new RankingItem(nome, pontuacao));
            }
        } catch (JSONException e) {
            prefs.edit().remove(CHAVE_ITENS).apply();
        }

        ordenar(itens);
        return itens;
    }

    private static void salvar(Context context, List<RankingItem> itens) {
        ordenar(itens);

        JSONArray array = new JSONArray();

        try {
            for (RankingItem item : itens) {
                JSONObject objeto = new JSONObject();
                objeto.put(CAMPO_NOME, item.getNome());
                objeto.put(CAMPO_PONTUACAO, item.getPontiacao());
                array.put(objeto);
            }
        } catch (JSONException e) {
            return;
        }

        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
                .edit()
                .putString(CHAVE_ITENS, array.toString())
                .apply();
    }

    private static void ordenar(List<RankingItem> itens) {
        Collections.sort(itens, Comparator.comparingInt(RankingItem::getPontiacao).reversed());
    }
}
