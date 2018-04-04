package br.com.senaijandira.smartcash;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 17170098 on 07/03/2018.
 */

public class DbHelper extends SQLiteOpenHelper {
    //nome do banco
    private static String DB_NAME = "db_smartcash.db";

    //versão do banco
    private static int DB_VERSION = 1;

    //construtor da classe para criação do banco
    public DbHelper(Context ctx){
        super(ctx, DB_NAME, null, DB_VERSION);
    }

    //código de criação do banco. É aqui que se cria as tabelas
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table tbl_categoria(_idCategoria integer primary key autoincrement, nomeCategoria text, " +
                "descricao text);";
        db.execSQL(sql);

        String sql2 = "create table tbl_movimentacao(_idMovimentacao integer primary key autoincrement, receita_despesa text, " +
                "mes text, idCategoria integer, nomeDespesa text, descricao text, ano integer);";
        db.execSQL(sql2);
    }

    //neste método, serão feitos os upgrades do banco
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table tbl_categoria;");
        db.execSQL("drop table tbl_movimentacao;");
        onCreate(db);
    }
}
