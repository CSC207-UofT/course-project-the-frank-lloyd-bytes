package usecases;

import entities.UCheck;
import dataBase.UCheckResults;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UCheckCommandsTest {

    UCheck uCheckSample;
    UCheckResults uCheckResultsSample;

    @Before
    public void setUp(){
        uCheckSample = new UCheck();
        uCheckResultsSample = new UCheckResults();
    }

    @Test
    public void testGetStateTrue() {
        uCheckSample.setState(1);
        Assert.assertEquals(1, uCheckSample.getState());
    }

    @Test
    public void testGetStateFalse() {
        uCheckSample.setState(2);
        Assert.assertEquals(2, uCheckSample.getState());
    }

    @Test
    public void testGetStateNeutral() {
        Assert.assertEquals(0, uCheckSample.getState());
    }

    @Test
    public void testGetDateUCheck() {
        uCheckSample.setDate("test");
        Assert.assertEquals("test", uCheckSample.getDate());
    }

    @After
    public void tearDown() {
        uCheckSample = null;
        uCheckResultsSample = null;
    }
}