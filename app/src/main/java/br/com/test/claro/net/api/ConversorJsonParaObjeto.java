package br.com.test.claro.net.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import br.com.test.claro.net.model.CustonShot;

public class ConversorJsonParaObjeto {

    public ConversorJsonParaObjeto() { }

    public List<CustonShot> conversorJsonStringParaObjeto(	String jsonString ) {

        List<CustonShot> custonShotList = new ArrayList<>();

        try {
//            JSONObject jsonobject = new JSONObject(jsonString);
            JSONArray array = new JSONArray(jsonString);
            int max = array.length();

            for (int j = 0; j < max; j++) {

                CustonShot custonShot = new CustonShot();

                JSONObject obj = array.getJSONObject(j);
                custonShot.setId(obj.getInt("id"));
                custonShot.setTitle(obj.getString("title"));
                custonShot.setDescription(obj.getString("description"));
                custonShot.setPublishedAt(obj.getString("published_at"));
                custonShot.setUpdatedAt(obj.getString("updated_at"));
                custonShot.setLinkPage(obj.getString("html_url"));

                JSONObject myImage = obj.getJSONObject("images");
                custonShot.setUrlImage(myImage.getString("teaser"));

                custonShotList.add(custonShot);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return custonShotList;
    }

}