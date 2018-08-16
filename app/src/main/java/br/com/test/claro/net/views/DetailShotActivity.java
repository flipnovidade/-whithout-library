package br.com.test.claro.net.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.test.claro.net.R;
import br.com.test.claro.net.model.CustonShot;

public class DetailShotActivity extends AppCompatActivity {

    public static final int REQUEST_INVITE = 0;
    private ImageView imageView;
    private TextView txvTitulo, txvSubtitulo, txvDescricao, tvFonte;
    private CustonShot news;
    private String TAG = DetailShotActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_shot);
        //getActionBar().hide();

        Intent i = DetailShotActivity.this.getIntent();
        Bundle b = i.getExtras();
        news = (CustonShot) b.getSerializable("Bean");
        String titulo = news.getTitle();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView = (ImageView) findViewById(R.id.imageViewAvatar);
        txvTitulo = (TextView) findViewById(R.id.textViewTitle);
        txvSubtitulo = (TextView) findViewById(R.id.textViewSubTitle);
        txvDescricao = (TextView) findViewById(R.id.textViewDescription);
        tvFonte = (TextView) findViewById(R.id.textViewFonte);

        if(news.getUrlImage() != null){

        }else{
            imageView.setVisibility(View.GONE);
        }

        if(news.getTitle() != null){
            txvTitulo.setText(Html.fromHtml( news.getTitle() ) );
        }else{
            txvTitulo.setVisibility(View.GONE);
        }

        if(news.getDescription() != null){
            txvSubtitulo.setText(Html.fromHtml( news.getDescription() ) );
        }else{
            txvSubtitulo.setVisibility(View.GONE);
        }

        if(news.getPublishedAt() != null){
            tvFonte.setText(Html.fromHtml("<b>Publish: </b>" + news.getPublishedAt()));
        }else{
            tvFonte.setVisibility(View.GONE);
        }

        if(news.getUpdatedAt() != null){
            txvDescricao.setText(Html.fromHtml("<b>Updated: </b>" + news.getUpdatedAt()));
        }else{
            txvDescricao.setVisibility(View.GONE);
        }



    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
    }

}