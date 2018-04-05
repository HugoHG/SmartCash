package br.com.senaijandira.smartcash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import br.com.senaijandira.smartcash.Categoria;

import java.util.ArrayList;

/**
 * Created by hugoh on 05/04/2018.
 */

public class CategoriaDAO {
    private static CategoriaDAO instance;
    public static CategoriaDAO getInstance() {

        if (instance == null)
            instance = new CategoriaDAO();

        return instance;
    }

    public Boolean inserir(Context context, Categoria c) {

        //acessar o banco em modo de escrita
        SQLiteDatabase db = new DbHelper(context).getWritableDatabase();

        ContentValues categorias = new ContentValues();
        categorias.put("nomeCategoria", c.getNomeCategoria());
        categorias.put("descricao", c.getDescCategoria());

        Long id = db.insert("tbl_categoria", null, categorias);

        if (id != -1)
            return true;
        else
            return false;

    }

    public ArrayList<Categoria> selecionarTodos(Context context) {

        //banco de dados de leitura
        SQLiteDatabase db = new DbHelper(context).getReadableDatabase();
        ArrayList<Categoria> retorno = new ArrayList<>();

        String sql = "select * from tbl_categoria;";
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            Categoria cat = new Categoria(cursor.getString(1), cursor.getString(2));

            Log.d("categoria", cat.getNomeCategoria());

            retorno.add(cat);
        }
        return retorno;
    }

    public Boolean remover(Context context, String nomeCategoria) {
        SQLiteDatabase db = new DbHelper(context).getWritableDatabase();
        db.delete("tbl_categoria", "nomeCategoria = ?", new String[]{nomeCategoria});
        return true;
    }
}
