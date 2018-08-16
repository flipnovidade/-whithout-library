package br.com.test.claro.net;


import android.database.SQLException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import br.com.test.claro.net.model.CustonShot;
import br.com.test.claro.net.repository.CustonShotRepository;
import br.com.test.claro.net.sqlite.ShotDao;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SQLiteTest {


    private ShotDao mDataSourceShotDao;

    @Before
    public void setUp()throws SQLException {
        mDataSourceShotDao = new ShotDao(InstrumentationRegistry.getTargetContext());
        mDataSourceShotDao.open();
    }

    @After
    public void finish() {
        mDataSourceShotDao.close();
    }

    @Test
    public void testPreConditions() {
        assertNotNull(mDataSourceShotDao);
    }

    @Test
    public void testRemoveAll() {
        List<CustonShot> listCustonShot = new ArrayList<>();
        listCustonShot.addAll(CustonShotRepository.getListCustonShot());

        mDataSourceShotDao.insertListCustonShot(listCustonShot);
        mDataSourceShotDao.removeAll();

        List<CustonShot> listCustonShotAux = mDataSourceShotDao.getAllCustonShot();
        assertThat(listCustonShotAux.size(), is(0));
    }

    @Test
    public void testInserList() {
        List<CustonShot> listCustonShot = new ArrayList<>();
        listCustonShot.addAll(CustonShotRepository.getListCustonShot());

        mDataSourceShotDao.insertListCustonShot(listCustonShot);

        List<CustonShot> listCustonShotAux = mDataSourceShotDao.getAllCustonShot();
        assertThat(listCustonShotAux.size(), is(2));

        mDataSourceShotDao.removeAll();
    }

    @Test
    public void testDeleteItem() {
        List<CustonShot> listCustonShot = new ArrayList<>();
        listCustonShot.addAll(CustonShotRepository.getListCustonShot());
        mDataSourceShotDao.insertListCustonShot(listCustonShot);

        mDataSourceShotDao.deleteCustonShotById(listCustonShot.get(0));
        List<CustonShot> listCustonShotAux = mDataSourceShotDao.getAllCustonShot();
        assertThat(listCustonShotAux.size(), is(1));

        mDataSourceShotDao.removeAll();
    }

    @Test
    public void testUpdateItem() {
        List<CustonShot> listCustonShot = new ArrayList<>();
        listCustonShot.addAll(CustonShotRepository.getListCustonShot());
        mDataSourceShotDao.insertListCustonShot(listCustonShot);

        CustonShot custonShotAux1 = listCustonShot.get(0);
        custonShotAux1.setTitle("Batatinha");
        int auxReturnUpdate = mDataSourceShotDao.updateCustonShotById(listCustonShot.get(0));
        assertThat(auxReturnUpdate, is(1));

        mDataSourceShotDao.removeAll();
    }

    @Test
    public void testGetItem() {
        List<CustonShot> listCustonShot = new ArrayList<>();
        listCustonShot.addAll(CustonShotRepository.getListCustonShot());
        mDataSourceShotDao.insertListCustonShot(listCustonShot);

        CustonShot custonShotAux1 = listCustonShot.get(0);
        CustonShot custonShotAux2 = mDataSourceShotDao.getCustonShotById(listCustonShot.get(0).getId());
        assertEquals(custonShotAux1.getId(), custonShotAux2.getId());

        mDataSourceShotDao.removeAll();
    }

}
