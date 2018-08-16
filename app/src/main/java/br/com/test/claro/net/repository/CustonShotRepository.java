package br.com.test.claro.net.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.test.claro.net.model.CustonShot;

public class CustonShotRepository {


    public static CustonShot getCustonShot(){

        CustonShot custonShot = new CustonShot();

        custonShot.setId(1);
        custonShot.setTitle("Title Custon Shot 1");
        custonShot.setDescription("Description Custon Shot 1");
        custonShot.setPublishedAt("11/08/2018");
        custonShot.setUpdatedAt("15/08/2018");
        custonShot.setUrlImage("");
        custonShot.setUrlAvatar("");
        custonShot.setLinkPage("");

        return custonShot;
    }

    public static List<CustonShot> getListCustonShot(){

        List<CustonShot> lisItemMediaApp = new ArrayList<>();

        CustonShot custonShot = new CustonShot();
        custonShot.setId(1);
        custonShot.setTitle("Title Custon Shot 1");
        custonShot.setDescription("Description Custon Shot 1");
        custonShot.setPublishedAt("11/08/2018");
        custonShot.setUpdatedAt("15/08/2018");
        custonShot.setUrlImage("");
        custonShot.setUrlAvatar("");
        custonShot.setLinkPage("");
        lisItemMediaApp.add(custonShot);

        CustonShot custonShot1 = new CustonShot();
        custonShot1.setId(2);
        custonShot1.setTitle("Title Custon Shot 2");
        custonShot1.setDescription("Description Custon Shot 2");
        custonShot1.setPublishedAt("11/08/2018");
        custonShot1.setUpdatedAt("15/08/2018");
        custonShot1.setUrlImage("");
        custonShot1.setUrlAvatar("");
        custonShot1.setLinkPage("");
        lisItemMediaApp.add(custonShot1);

        return lisItemMediaApp;
    }


}
