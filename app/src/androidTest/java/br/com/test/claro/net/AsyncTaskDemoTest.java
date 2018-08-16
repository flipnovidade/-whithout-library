package br.com.test.claro.net;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import br.com.test.claro.net.api.AssyncCarregaInfosApi;
import br.com.test.claro.net.model.CustonShot;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AsyncTaskDemoTest {

    private AssyncCarregaInfosApi assyncCarregaInfosApi;

    @Before
    public void setUp() {
        assyncCarregaInfosApi = new AssyncCarregaInfosApi(
                InstrumentationRegistry.getTargetContext(),
                0,
                true,
                null);
    }

    @Test
    public void testPreConditions() {
        assertNotNull(assyncCarregaInfosApi);
    }

    @Test
    public void getList() throws Exception {
        List<CustonShot> custonShotList = (List<CustonShot>) assyncCarregaInfosApi.execute().get();
        assertThat(custonShotList.size(), is(2));
    }

}
