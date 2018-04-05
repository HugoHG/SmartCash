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

import java.util.ArrayList;

public class CadastroMovimentacao extends AppCompatActivity {

    EditText nomeMovimentacao;
    EditText mesMovimentacao;
    EditText categoriaMovimentacao;
    EditText descMovimentacao;
    EditText anoMovimentacao;
    EditText valorMovimentacao;
    EditText receita_despesa;
    String controle;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_movimentacao);


        ArrayList<Categoria> listCat = new ArrayList<>();
        listCat = CategoriaDAO.getInstance().selecionarTodos(this);

        ArrayList<String> categorias = new ArrayList<>();

        for (Categoria c : listCat){
            categorias.add(c.getNomeCategoria());
        }

        spinner = (Spinner) findViewById(R.id.planets_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        /*ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);*/
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, categorias);
        // Specify the layout to use when the list of choices appears
        /*adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);*/
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        // Apply the adapter to the spinner
        //spinner.setAdapter(adapter);
        spinner.setAdapter(spinnerArrayAdapter);

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

        Log.d("item", spinner.getSelectedItem().toString());

        mov.setNomeMovimentacao(nomeMovimentacao.getText().toString());
        mov.setMes(mesMovimentacao.getText().toString());
        mov.setCategoria(spinner.getSelectedItem().toString());
        mov.setDescricao(descMovimentacao.getText().toString());
        mov.setAno(Integer.parseInt(anoMovimentacao.getText().toString()));

        mov.setReceita_despesa(receita_despesa.getText().toString());

        if (controle.equals("receita")){
            mov.setValor(Float.parseFloat(valorMovimentacao.getText().toString()));
        } else{
            Float valor = Float.parseFloat(valorMovimentacao.getText().toString()) * -1;
            mov.setValor(valor);
        }

        MovimentacaoDAO.getInstance().inserir(this, mov);

        finish();
    }



}
