package br.com.test.claro.net.api;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import br.com.test.claro.net.BuildConfig;
import br.com.test.claro.net.model.CustonShot;
import br.com.test.claro.net.repository.CustonShotRepository;
import br.com.test.claro.net.sqlite.ShotDao;
import br.com.test.claro.net.utils.Constants;

public class AssyncCarregaInfosApi extends AsyncTask<String, Void, List<CustonShot>> {
    private String SERVER = Constants.Dribbble.URL;
    private int PER_PAGE = Constants.Dribbble.PER_PAGE;
    private String TOKEN = Constants.Dribbble.Token;
    private int PAGE;
    private Context context;
    private OnListenerStatusCallApi onListenerStatusCallApi;
    private boolean isFirst = false;

    public interface OnListenerStatusCallApi{
        void sucess(List<CustonShot> custonShotList, int nextPage);
        void fail();
        void canceled();
    }

    public AssyncCarregaInfosApi(Context context, int PAGE, boolean isFirst, OnListenerStatusCallApi onListenerStatusCallApi) {
        this.context = context;
        this.PAGE = PAGE;
        this.onListenerStatusCallApi = onListenerStatusCallApi;
        this.isFirst = isFirst;
    }

    @Override
    protected void onPreExecute() {}

    @Override
    protected List<CustonShot> doInBackground(String... strings) {

        String COMPLETED_URL = SERVER;

        Log.i("teste", "COMPLETED_URL: " + COMPLETED_URL);

        try {

            ConversorJsonParaObjeto conversorJsonParaObjeto = new ConversorJsonParaObjeto();
            List<CustonShot> custonShotArrayList = null;

            if( BuildConfig.FLAVOR.equals("repo") ){
                custonShotArrayList = CustonShotRepository.getListCustonShot();
            }else{
                custonShotArrayList = conversorJsonParaObjeto.conversorJsonStringParaObjeto(getJSONObjectFromURL(COMPLETED_URL));
            }

            ShotDao shotDao = new ShotDao(context);
            shotDao.insertListCustonShot(custonShotArrayList);

            if(isFirst){
                return  shotDao.getAllCustonShot();
            }else{
                CustonShot custonShot = custonShotArrayList.get(custonShotArrayList.size() - 1);
                return shotDao.getCustonShotBiggerTo(custonShot.getId());
            }


        } catch (Exception erro) {
            Log.i("teste", "catch 1: " + erro.getMessage());
            erro.printStackTrace();
            if(onListenerStatusCallApi != null){
                onListenerStatusCallApi.fail();
            }
            onCancelled();
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<CustonShot> custonShotList) {
        if(onListenerStatusCallApi != null){
            onListenerStatusCallApi.sucess(custonShotList, PAGE++);
        }
    }

    public void cancelListener(){
        onListenerStatusCallApi = null;
    }

    @Override
    protected void onCancelled() {
        if(onListenerStatusCallApi != null){
            onListenerStatusCallApi.canceled();
        }
        super.onCancelled();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


    public String getJSONObjectFromURL(String urlString) throws IOException {
        HttpURLConnection urlConnection = null;
        URL url = new URL(urlString);
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(10000 /* milliseconds */ );
        urlConnection.setConnectTimeout(15000 /* milliseconds */ );
        urlConnection.setDoOutput(true);
        urlConnection.connect();

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        br.close();

        String jsonString = sb.toString();
        System.out.println("JSON: " + jsonString);

        return jsonString;
    }


}
