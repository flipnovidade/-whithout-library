package br.com.test.claro.net.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.List;
import br.com.test.claro.net.R;
import br.com.test.claro.net.api.AssyncCarregaInfosApi;
import br.com.test.claro.net.model.CustonShot;
import br.com.test.claro.net.utils.PreferencesApp;
import br.com.test.claro.net.views.adapter.AdapterShot;

public class MainActivity extends AppCompatActivity implements AssyncCarregaInfosApi.OnListenerStatusCallApi{
    public static String PREFERENCE_PAGE = "PREFERENCE_PAGE";
    private AssyncCarregaInfosApi assyncCarregaInfosApi;
    private PreferencesApp preferencesApp;
    private ListView listView;
    private AdapterShot adapterShot;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CustonShot custonShot = (CustonShot) parent.getItemAtPosition(position);

                Intent intent = new Intent(MainActivity.this, DetailShotActivity.class);
                intent.putExtra("Bean", custonShot);
                startActivity( intent );

            }
        });

        setPreferenceApp();
        callApi(true);
    }

    private void setPreferenceApp(){
        preferencesApp = new PreferencesApp(this);
    }

    private void callApi(boolean isFirst){
        assyncCarregaInfosApi = new AssyncCarregaInfosApi(
                this,
                preferencesApp.getIntByKey(PREFERENCE_PAGE),
                isFirst,
                this);
        assyncCarregaInfosApi.execute();
    }

    @Override
    public void sucess(List<CustonShot> custonShotList, int netxPage) {
        preferencesApp.setIntByKey(PREFERENCE_PAGE, netxPage);

        if(adapterShot == null){
            adapterShot = new AdapterShot(this, custonShotList);
            listView.setAdapter(adapterShot);
        }else{
            adapterShot.addItemList(custonShotList);
        }

    }

    @Override
    public void fail() {

    }

    @Override
    public void canceled() {

    }

    @Override
    protected void onDestroy() {
        assyncCarregaInfosApi.cancelListener();
        super.onDestroy();
    }
}
