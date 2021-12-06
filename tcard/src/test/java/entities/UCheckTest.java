package entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UCheckTest {

    UCheck testUCheck;
    @Before
    public void setUp(){
        testUCheck = new UCheck();
    }

    @Test
    public void getDate() {
        testUCheck.setDate("date");
        Assert.assertSame(testUCheck.getDate(), "date");
    }

    @Test
    public void setDate() {
        testUCheck.setDate("date");
        assertEquals("date", testUCheck.getDate());
    }

    @Test
    public void getStatePass() {
        testUCheck.setState(1);
        assertEquals(1, testUCheck.getState());
    }
    
    @Test
    public void getStateFail() {
        testUCheck.setState(2);
        assertEquals(2, testUCheck.getState());
    }

    @Test
    public void getStateNeutral() {
        assertEquals(0, testUCheck.getState());
    }

    @Test
    public void setStatePass() {
        testUCheck.setState(1);
        assertEquals(1, testUCheck.getState());
    }

    @Test
    public void setStateFail() {
        testUCheck.setState(2);
        assertEquals(2, testUCheck.getState());
    }
}