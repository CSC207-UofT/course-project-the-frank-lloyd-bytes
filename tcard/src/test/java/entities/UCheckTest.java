package entities;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;

public class UCheckTest {
    private UCheck sampleUcheck;

    @Before
    public void setUp() {
        sampleUcheck = new UCheck("1003757936");
    }

    @Test
    public void setUCheckTime() {
        sampleUcheck.setUCheckTime();
        Assert.assertTrue(sampleUcheck.isUCheck());
    }

    @Test
    public void getUCheckTime() {
        Date date = new Date();
        sampleUcheck.setUCheckTime();
        Assert.assertEquals(date,sampleUcheck.getUCheckTime());
    }

    @Test
    public void getUTorId() {
        Assert.assertEquals("1003757936", sampleUcheck.getUTorId());
    }

    @Test
    public void isUCheck() {
        Assert.assertFalse(sampleUcheck.isUCheck());
        sampleUcheck.setUCheckTime();
        Assert.assertTrue(sampleUcheck.isUCheck());
    }

    @Test
    public void uCheckValid() {
        sampleUcheck.setUCheckTime();
        Assert.assertTrue(sampleUcheck.uCheckValid());
    }
    @After
    public void tearDown() {
        sampleUcheck = null;
    }
}