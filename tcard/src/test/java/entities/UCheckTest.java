package entities;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UCheckTest {

    UCheck testUCheck;
    @Before
    public void setUp(){
        testUCheck = new UCheck();
    }

    @Test
    public void testGetDate() {
        testUCheck.setDate("date");
        Assert.assertSame(testUCheck.getDate(), "date");
    }

    @Test
    public void testSetDate() {
        testUCheck.setDate("date");
        Assert.assertEquals("date", testUCheck.getDate());
    }

    @Test
    public void testGetStatePass() {
        testUCheck.setState(1);
        Assert.assertEquals(1, testUCheck.getState());
    }
    
    @Test
    public void testGetStateFail() {
        testUCheck.setState(2);
        Assert.assertEquals(2, testUCheck.getState());
    }

    @Test
    public void testGetStateNeutral() {
        Assert.assertEquals(0, testUCheck.getState());
    }

    @Test
    public void testSetStatePass() {
        testUCheck.setState(1);
        Assert.assertEquals(1, testUCheck.getState());
    }

    @Test
    public void testSetStateFail() {
        testUCheck.setState(2);
        Assert.assertEquals(2, testUCheck.getState());
    }

    @After
    public void tearDown() {
        testUCheck = null;
    }
}