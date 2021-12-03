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
    public void getState() {
        testUCheck.setState(1);
        assertEquals(testUCheck.getState(), 1);
    }

    @Test
    public void setState() {
        testUCheck.setState(1);
        assertEquals(testUCheck.getState(), 1);
    }
}