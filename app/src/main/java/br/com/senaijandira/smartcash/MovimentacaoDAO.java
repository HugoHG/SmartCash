package br.com.senaijandira.smartcash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 17170098 on 21/03/2018.
 */

public class MovimentacaoDAO {
    private static MovimentacaoDAO instance;
    public static MovimentacaoDAO getInstance() {

        if (instance == null)
            instance = new MovimentacaoDAO();

        return instance;
    }

    public Boolean inserir(Context context, Movimentacao m) {

        //acessar o banco em modo de escrita
        SQLiteDatabase db = new DbHelper(context).getWritableDatabase();

        ContentValues movimentacoes = new ContentValues();
        movimentacoes.put("receita_despesa", m.getReceita_despesa());
        movimentacoes.put("mes", m.getMes());
        movimentacoes.put("categoria", m.getCategoria());
        movimentacoes.put("nomeDespesa", m.getNomeMovimentacao());
        movimentacoes.put("descricao", m.getDescricao());
        movimentacoes.put("ano", m.getAno());
        movimentacoes.put("valor", m.getValor());

        Log.d("receita", m.getReceita_despesa());

        Long id = db.insert("tbl_movimentacao", null, movimentacoes);

        if (id != -1)
            return true;
        else
            return false;

    }

    public ArrayList<Movimentacao> selecionarTodos(Context context) {

        //banco de dados de leitura
        SQLiteDatabase db = new DbHelper(context).getReadableDatabase();
        ArrayList<Movimentacao> retorno = new ArrayList<Movimentacao>();

        String sql = "select * from tbl_movimentacao;";
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            Movimentacao m = new Movimentacao();
            m.setIdMovimentacao(cursor.getInt(0)/*acessando a coluna do ID*/);
            m.setReceita_despesa(cursor.getString(1));
            m.setMes(cursor.getString(2));
            m.setCategoria(cursor.getString(3));
            m.setNomeMovimentacao(cursor.getString(4));
            m.setDescricao(cursor.getString(5));
            m.setAno(cursor.getInt(6));
            m.setValor(cursor.getFloat(7));

            Log.d("nome", m.getNomeMovimentacao());

            retorno.add(m);
        }
        return retorno;
    }

    public ArrayList<Movimentacao> selecionarPorCategoria(Context context, String nomeCategoria) {

        //banco de dados de leitura
        SQLiteDatabase db = new DbHelper(context).getReadableDatabase();
        ArrayList<Movimentacao> retorno = new ArrayList<Movimentacao>();

        String sql = "select * from tbl_movimentacao where categoria = '" + nomeCategoria + "';" ;
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            Movimentacao m = new Movimentacao();
            m.setIdMovimentacao(cursor.getInt(0)/*acessando a coluna do ID*/);
            m.setReceita_despesa(cursor.getString(1));
            m.setMes(cursor.getString(2));
            m.setCategoria(cursor.getString(3));
            m.setNomeMovimentacao(cursor.getString(4));
            m.setDescricao(cursor.getString(5));
            m.setAno(cursor.getInt(6));
            m.setValor(cursor.getFloat(7));

            Log.d("nome", m.getNomeMovimentacao());

            retorno.add(m);
        }
        return retorno;
    }
}