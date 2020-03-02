package br.com.etelimoeiro.projetointegrador.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.etelimoeiro.projetointegrador.R;
import br.com.etelimoeiro.projetointegrador.domain.Produto;

public class ListaProdutosAdapter extends BaseAdapter {

    private Context context;
    private List<Produto> produtoList;

    public ListaProdutosAdapter(Context context, List<Produto> produtoList) {
        this.context = context;
        this.produtoList = produtoList;
    }

    @Override
    public int getCount() {
        return this.produtoList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.produtoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void removerProduto(int position){
        this.produtoList.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(this.context, R.layout.layout_produto, null);

        TextView tvNomeProduto = (TextView) v.findViewById(R.id.tvNomeProduto);
        TextView tvValorProduto = (TextView) v.findViewById(R.id.tvValorProduto);
        TextView tvQtdProduto = (TextView) v.findViewById(R.id.tvQtdProduto);

        tvNomeProduto.setText(this.produtoList.get(position).getNomeProduto());
        tvQtdProduto.setText(String.valueOf(this.produtoList.get(position).getQtd()));
        tvValorProduto.setText(String.valueOf(this.produtoList.get(position).getValor()));

        return v;
    }
}
