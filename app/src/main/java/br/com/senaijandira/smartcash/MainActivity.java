package br.com.senaijandira.smartcash;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner categorias;
    TextView txt_categoria;
    ArrayList<Categoria> listaCategorias;
    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3;

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

        /*
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter();

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        */

        Categoria lazer = new Categoria(1, "lazer", "l");

        Categoria transporte = new Categoria(2, "transporte", "t");

        Categoria saude = new Categoria(3, "saude", "s");

        Categoria moradia = new Categoria(4, "moradia", "m");

        Categoria salario = new Categoria(5, "salario", "salario");

        Categoria outros = new Categoria(6, "outros", "o");

        listaCategorias = new ArrayList<>();

        listaCategorias.add(lazer);

        listaCategorias.add(transporte);

        listaCategorias.add(saude);

        listaCategorias.add(moradia);

        listaCategorias.add(salario);

        listaCategorias.add(outros);

        txt_categoria.setText(lazer.getNomeCategoria());


        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item3);

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu first item clicked

            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu second item clicked

            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu third item clicked

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
    }
}
