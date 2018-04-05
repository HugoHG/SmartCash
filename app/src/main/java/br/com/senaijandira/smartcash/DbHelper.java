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
    private static int DB_VERSION = 4;

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
                "mes text, categoria text, nomeDespesa text, descricao text, ano integer, valor real);";
        db.execSQL(sql2);

        String sql3 = "INSERT INTO tbl_categoria (nomeCategoria, descricao) VALUES ('geral', 'Movimentações gerais')";

        db.execSQL(sql3);

        String sql4 = "INSERT INTO tbl_categoria (nomeCategoria, descricao) VALUES ('lazer', 'Atividades ligadas ao lazer')";

        db.execSQL(sql4);

        String sql5 = "INSERT INTO tbl_categoria (nomeCategoria, descricao) VALUES ('transporte', 'Atividades ligadas ao transporte')";

        db.execSQL(sql5);

        String sql6 = "INSERT INTO tbl_categoria (nomeCategoria, descricao) VALUES ('saude', 'Atividades ligadas à saúde')";

        db.execSQL(sql6);

        String sql7 = "INSERT INTO tbl_categoria (nomeCategoria, descricao) VALUES ('moradia', 'Atividades ligadas à moradia')";

        db.execSQL(sql7);

        String sql8 = "INSERT INTO tbl_categoria (nomeCategoria, descricao) VALUES ('salario', 'Atividades ligadas ao salário')";

        db.execSQL(sql8);

        String sql9 = "INSERT INTO tbl_categoria (nomeCategoria, descricao) VALUES ('outros', 'Atividades ligadas a outras categorias')";

        db.execSQL(sql9);
    }

    //neste método, serão feitos os upgrades do banco
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table tbl_categoria;");
        db.execSQL("drop table tbl_movimentacao;");
        onCreate(db);
    }
}
