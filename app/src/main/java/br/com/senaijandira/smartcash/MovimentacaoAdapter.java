package br.com.senaijandira.smartcash;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovimentacaoAdapter extends ArrayAdapter<Movimentacao> {


    public MovimentacaoAdapter(Context ctx, ArrayList<Movimentacao> lst){
        super(ctx, 0, lst);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        View v = convertView;

        if (v == null){

            v = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_view_item, null);
        }

        //pegar o contato que esta sendo montado
        Movimentacao item = getItem(position);

        TextView txt_item_nome = v.findViewById(R.id.txt_item_nome);
        TextView txt_item_valor = v.findViewById(R.id.txt_item_valor);

        txt_item_nome.setText( item.getNomeMovimentacao());
        txt_item_valor.setText(item.getValor().toString());

        return v;
    }
}
