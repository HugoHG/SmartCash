package br.com.senaijandira.smartcash;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner categorias;
    TextView txt_categoria;
    ArrayList<Categoria> listaCategorias;
    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3;
    MovimentacaoDAO mDao;
    ListView list_view_movimentacoes;
    MovimentacaoAdapter adapter;
    CategoriaDAO cDao;
    TextView txt_saldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent intent = new Intent(getApplicationContext(), CadastroMovimentacao.class);
                startActivity(intent);
            }
        });*/




        txt_categoria = (TextView) findViewById(R.id.txt_categoria);

        txt_saldo = (TextView) findViewById(R.id.txt_saldo);

        /*
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter();

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        */

        listaCategorias = new ArrayList<>();

        cDao = CategoriaDAO.getInstance();

        listaCategorias = cDao.selecionarTodos(this);

        txt_categoria.setText(listaCategorias.get(0).getNomeCategoria());

        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item3);


        final Intent pgCadMov = new Intent(this, CadastroMovimentacao.class);
        pgCadMov.putExtra("receita_despesa", "receita");

        final Intent pgCadMov2 = new Intent(this, CadastroMovimentacao.class);
        pgCadMov2.putExtra("receita_despesa", "despesa");

        final Intent pgCadCat = new Intent(this, CadastroCategoria.class);

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu first item clicked
                startActivity(pgCadMov);
            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu second item clicked
                startActivity(pgCadMov2);
            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu third item clicked
                startActivity(pgCadCat);
            }
        });

        mDao = MovimentacaoDAO.getInstance();

        list_view_movimentacoes = (ListView) findViewById(R.id.list_view_movimentacoes);

        adapter = new MovimentacaoAdapter(this, new ArrayList<Movimentacao>());

        list_view_movimentacoes.setAdapter(adapter);

        mostrarPorCategoria();

        txt_saldo.setText(calcularSaldo().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();

        listaCategorias = new ArrayList<>();

        cDao = CategoriaDAO.getInstance();

        listaCategorias = cDao.selecionarTodos(this);

        txt_categoria.setText(listaCategorias.get(0).getNomeCategoria());

        mostrarPorCategoria();

    }

    public void mostrarPorCategoria() {
        String nomCat = txt_categoria.getText().toString();

        //Pegando os contatos do banco
        ArrayList<Movimentacao> movimentacoesCadastradas;
        if (nomCat.equals("geral")){
            movimentacoesCadastradas = mDao.selecionarTodos(this);
        } else {
            movimentacoesCadastradas = mDao.selecionarPorCategoria(this, nomCat);
        }

        //limpar o conteudo
        adapter.clear();

        //preenchendo o adaptador
        adapter.addAll(movimentacoesCadastradas);
    }

    public void next_Category(View v) {
        String categoriaAtual = txt_categoria.getText().toString();
        for (Categoria c : listaCategorias) {
            if (c.getNomeCategoria().equals(categoriaAtual)) {
                int index = listaCategorias.indexOf(c);
                int indexproximo = index + 1;
                try {
                    Categoria proxCategoria = listaCategorias.get(indexproximo);
                    txt_categoria.setText(proxCategoria.getNomeCategoria());
                } catch (Exception e) {

                }
            }
        }
        mostrarPorCategoria();
    }

    public void prev_Category(View v) {
        String categoriaAtual = txt_categoria.getText().toString();
        for (Categoria c : listaCategorias) {
            if (c.getNomeCategoria().equals(categoriaAtual)) {
                int index = listaCategorias.indexOf(c);
                int indexanterior = index - 1;
                try {
                    Categoria antCategoria = listaCategorias.get(indexanterior);
                    txt_categoria.setText(antCategoria.getNomeCategoria());
                } catch (Exception e) {

                }
            }
        }
        mostrarPorCategoria();
    }

    Context ctx = this;
    public void excluirCategoria(View v) {
        new AlertDialog.Builder(this)
                .setTitle("Deletando categoria")
                .setMessage("Tem certeza que deseja deletar essa categoria?")
                .setPositiveButton("sim",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                adapter.notifyDataSetChanged();
                                CategoriaDAO.getInstance().remover(ctx, txt_categoria.getText().toString());
                                ArrayList<Movimentacao> movimentacoes = new ArrayList<>();
                                movimentacoes = MovimentacaoDAO.getInstance().selecionarTodos(ctx);
                                for (Movimentacao m : movimentacoes){
                                    if(m.getCategoria().equals(txt_categoria.getText().toString())){
                                        MovimentacaoDAO.getInstance().remover(ctx, m.getIdMovimentacao());
                                    }
                                }
                                onResume();
                            }
                        })
                .setNegativeButton("não", null)
                .show();

    }

    public Float calcularSaldo(){
        ArrayList<Movimentacao> movimentacoes = new ArrayList<>();
        movimentacoes = MovimentacaoDAO.getInstance().selecionarTodos(ctx);
        String zero = "0.0";
        Float saldo = Float.parseFloat(zero);

        for(Movimentacao m : movimentacoes){
            saldo = saldo + m.getValor();
        }
        Log.d("saldo", saldo.toString());
        return saldo;
    }
}
