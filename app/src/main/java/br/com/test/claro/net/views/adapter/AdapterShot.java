package br.com.test.claro.net.views.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.List;
import br.com.test.claro.net.R;
import br.com.test.claro.net.model.CustonShot;

public class AdapterShot extends BaseAdapter {
    private final Context context;
    private List<CustonShot> custonShotList;
    private LayoutInflater inflater;

    public TextView txvLinhaUm;
    public TextView txtLinhaDois;
    public TextView txtLinhaTres;
    public TextView txvLinhaUmDireita;
    public ImageView imgavatar;
    public ProgressBar myProgress;

    public AdapterShot(Context context, List<CustonShot> custonShotList) {
        this.context = context;
        this.custonShotList = custonShotList;
    }

    @Override
    public int getCount() {
        return custonShotList.size();
    }

    @Override
    public Object getItem(int position) {
        return custonShotList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addItemList(List<CustonShot> custonShotList) {
        this.custonShotList.addAll(custonShotList);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final CustonShot custonShot = custonShotList.get(position);
        if(v == null){
            v = inflater.inflate(R.layout.item_shot_list, null);
        }

        txvLinhaUm = (TextView) v.findViewById(R.id.txv_linha_um);
        txtLinhaDois = (TextView) v.findViewById(R.id.txv_linha_dois);
        txtLinhaTres = (TextView) v.findViewById(R.id.txv_linha_tres);
        txvLinhaUmDireita = (TextView) v.findViewById(R.id.txv_linha_um_direita);
        imgavatar = (ImageView) v.findViewById(R.id.imgAvatar);
        myProgress = (ProgressBar) v.findViewById(R.id.itemProgress);

        txvLinhaUm.setText(Html.fromHtml( custonShot.getTitle() ));
        txtLinhaDois.setText(Html.fromHtml( custonShot.getDescription() ));
        txtLinhaTres.setText(Html.fromHtml("<b>Publish: </b>" + custonShot.getPublishedAt()));
        txvLinhaUmDireita.setText(Html.fromHtml("<b>Updated: </b>" + custonShot.getUpdatedAt()));
        txvLinhaUmDireita.setVisibility(View.INVISIBLE);

        if(custonShot.getUrlAvatar() != null){
            txvLinhaUmDireita.setVisibility(View.VISIBLE);
        }


        return v;
    }
}
