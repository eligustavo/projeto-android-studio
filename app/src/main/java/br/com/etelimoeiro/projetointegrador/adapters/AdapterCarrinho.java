package br.com.etelimoeiro.projetointegrador.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.etelimoeiro.projetointegrador.R;
import br.com.etelimoeiro.projetointegrador.domain.ItemVenda;
import br.com.etelimoeiro.projetointegrador.domain.Produto;

public class AdapterCarrinho extends BaseAdapter {

    private Context context;
    private List<ItemVenda> itensCarrinho;

    public AdapterCarrinho(Context context, List<ItemVenda> itensCarrinho) {
        this.context = context;
        this.itensCarrinho = itensCarrinho;
    }

    @Override
    public int getCount() {
        return this.itensCarrinho.size();
    }

    @Override
    public Object getItem(int position) {
        return this.itensCarrinho.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void removerItemCarrinho(int position) {
        this.itensCarrinho.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(this.context, R.layout.layout_produto, null);

        TextView tvNomeProduto = (TextView) v.findViewById(R.id.tvNomeProduto);
        TextView tvValorProduto = (TextView) v.findViewById(R.id.tvValorProduto);
        TextView tvQtdProduto = (TextView) v.findViewById(R.id.tvQtdProduto);
        TextView tvValorTotal = (TextView) v.findViewById(R.id.tvValorTotal);


        tvNomeProduto.setText(this.itensCarrinho.get(position).getNome());
        tvValorProduto.setText(String.valueOf(this.itensCarrinho.get(position).getValorProduto()));
        tvQtdProduto.setText(String.valueOf(this.itensCarrinho.get(position).getQtdSelecionada()));
        tvValorTotal.setText(String.valueOf(this.itensCarrinho.get(position).getValorItemVenda()));

        return v;
    }

    public void Atualizar(List<ItemVenda> itemVendas) {
        this.itensCarrinho.clear();
        this.itensCarrinho = itensCarrinho;
        this.notifyDataSetChanged();
    }

}
