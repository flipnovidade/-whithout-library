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
        custonShot.setUrlImage("https://cdn.dribbble.com/users/2479470/screenshots/4951280/testing_teaser.png");
        custonShot.setLinkPage("https://dribbble.com/shots/4951280-Second-Shot");

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
        custonShot.setUrlImage("https://cdn.dribbble.com/users/2479470/screenshots/4951280/testing_teaser.png");
        custonShot.setLinkPage("https://dribbble.com/shots/4951280-Second-Shot");
        lisItemMediaApp.add(custonShot);

        CustonShot custonShot1 = new CustonShot();
        custonShot1.setId(2);
        custonShot1.setTitle("Title Custon Shot 2");
        custonShot1.setDescription("Description Custon Shot 2");
        custonShot1.setPublishedAt("11/08/2018");
        custonShot1.setUpdatedAt("15/08/2018");
        custonShot1.setUrlImage("https://cdn.dribbble.com/users/2479470/screenshots/4951280/testing_teaser.png");
        custonShot1.setLinkPage("https://dribbble.com/shots/4951280-Second-Shot");
        lisItemMediaApp.add(custonShot1);

        return lisItemMediaApp;
    }


}
