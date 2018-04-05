package br.com.senaijandira.smartcash;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class CadastroCategoria extends AppCompatActivity {

    EditText nomeCategoria;
    EditText descCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_categoria);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        nomeCategoria = (EditText) findViewById(R.id.nomeCategoria);
        descCategoria = (EditText) findViewById(R.id.descCategoria);
    }

    public void salvar(View v){
        Categoria c = new Categoria(nomeCategoria.getText().toString(), descCategoria.getText().toString());
        CategoriaDAO cDao = CategoriaDAO.getInstance();

        cDao.inserir(this, c);

        finish();
    }

}
