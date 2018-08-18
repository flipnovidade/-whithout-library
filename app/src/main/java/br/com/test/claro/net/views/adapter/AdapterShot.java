package br.com.test.claro.net.views.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import br.com.test.claro.net.R;
import br.com.test.claro.net.api.AssyncCarregaImagemByUrl;
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

        txvLinhaUm = v.findViewById(R.id.txv_linha_um);
        txtLinhaDois = v.findViewById(R.id.txv_linha_dois);
        txtLinhaTres = v.findViewById(R.id.txv_linha_tres);
        txvLinhaUmDireita = v.findViewById(R.id.txv_linha_um_direita);
        imgavatar = v.findViewById(R.id.imgAvatar);
        myProgress = v.findViewById(R.id.itemProgress);

        txvLinhaUm.setText(Html.fromHtml( custonShot.getTitle() ));
        txtLinhaDois.setText(Html.fromHtml( custonShot.getDescription() ));
        txtLinhaTres.setText(Html.fromHtml("<b>Publish: </b>" + custonShot.getPublishedAt()));
        txvLinhaUmDireita.setText(Html.fromHtml("<b>Updated: </b>" + custonShot.getUpdatedAt()));

        if(custonShot.getUrlImage() != null){
            setImageByUrl(imgavatar, custonShot.getUrlImage(), myProgress);
        }

        return v;
    }

    private void setImageByUrl(ImageView imageView, String urlImage, ProgressBar progressBar){
        new AssyncCarregaImagemByUrl(imageView, progressBar).execute(urlImage);
    }
}
