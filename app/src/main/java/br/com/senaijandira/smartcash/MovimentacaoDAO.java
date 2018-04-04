package br.com.senaijandira.smartcash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

/**
 * Created by 17170098 on 21/03/2018.
 */
/*
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
        movimentacoes.put("nome", m.getNomeMovimentacao());


        //TODO: Arrumar a data de nascimento e incluir a foto
        //valores.put("dt_nascimento", c.getDt_nascimento());
        //

        if (c.getFoto() != null) {
            valores.put("foto", transformarParaBytes(c.getFoto()));
        }


        Long id = db.insert("tbl_contato", null, valores);

        if (id != -1)
            return true;
        else
            return false;

    }

    public ArrayList<Contato> selecionarTodos(Context context) {

        //banco de dados de leitura
        SQLiteDatabase db = new DbHelper(context).getReadableDatabase();
        ArrayList<Contato> retorno = new ArrayList<Contato>();

        String sql = "select * from tbl_contato;";
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            Contato c = new Contato();
            c.setId(cursor.getInt(0)/*acessando a coluna do ID)
            c.setNome(cursor.getString(1));
            c.setTelefone(cursor.getString(2));
            c.setEmail(cursor.getString(3));

            //TODO: arrumar dt nascimento e foto

            c.setDt_nascimento(new Date());

            byte[] fotoBanco = cursor.getBlob(5);

            if(fotoBanco!=null && fotoBanco.length > 0){
                c.setFoto(transformarParaBitmap(fotoBanco));
            }

            retorno.add(c);
        }
        return retorno;
    }
}
*/