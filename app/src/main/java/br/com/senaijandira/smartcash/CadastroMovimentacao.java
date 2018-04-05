package br.com.senaijandira.smartcash;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class CadastroMovimentacao extends AppCompatActivity {

    EditText nomeMovimentacao;
    EditText mesMovimentacao;
    EditText categoriaMovimentacao;
    EditText descMovimentacao;
    EditText anoMovimentacao;
    EditText valorMovimentacao;
    EditText receita_despesa;
    String controle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_movimentacao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

                Intent intent = new Intent();
            }
        });

        /*Spinner spinner = (Spinner) findViewById(R.id.planets_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);*/

        nomeMovimentacao = (EditText) findViewById(R.id.nomeMovimentacao);
        mesMovimentacao = (EditText) findViewById(R.id.mesMovimentacao);
        categoriaMovimentacao = (EditText) findViewById(R.id.categoriaMovimentacao);
        descMovimentacao = (EditText) findViewById(R.id.descMovimentacao);
        anoMovimentacao = (EditText) findViewById(R.id.anoMovimentacao);
        valorMovimentacao = (EditText) findViewById(R.id.valorMovimentacao);
        receita_despesa = (EditText) findViewById(R.id.receita_depesa);

        Intent it = getIntent();

        controle = it.getStringExtra("receita_despesa");

        if(controle.equals("receita")){
            receita_despesa.setText("receita");
        }else{
            receita_despesa.setText("despesa");
        }

    }

    public void salvar(View v){
        Movimentacao mov = new Movimentacao();

        mov.setNomeMovimentacao(nomeMovimentacao.getText().toString());
        mov.setMes(mesMovimentacao.getText().toString());
        mov.setCategoria(categoriaMovimentacao.getText().toString());
        mov.setDescricao(descMovimentacao.getText().toString());
        mov.setAno(Integer.parseInt(anoMovimentacao.getText().toString()));

        mov.setReceita_despesa(receita_despesa.getText().toString());

        if (controle.equals("receita")){
            mov.setValor(Float.parseFloat(valorMovimentacao.getText().toString()));
        } else{
            Float valor = Float.parseFloat(valorMovimentacao.toString()) * -1;
            mov.setValor(valor);
        }

        MovimentacaoDAO.getInstance().inserir(this, mov);

        finish();
    }



}
