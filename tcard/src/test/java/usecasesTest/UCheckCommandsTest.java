package usecasesTest;

import entities.UCheck;
import entities.UCheckResults;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UCheckCommandsTest {

    UCheck uCheckSample;
    UCheckResults uCheckResultsSample;

    @Before
    public void setUp(){
        uCheckSample = new UCheck();
        uCheckResultsSample = new UCheckResults();
    }

    @Test
    public void getStateTrue() {
        uCheckSample.setState(1);
        assertEquals(1, uCheckSample.getState());
    }
    @Test
    public void getStateFalse() {
        uCheckSample.setState(2);
        assertEquals(2, uCheckSample.getState());
    }
    @Test
    public void getStateNeutral() {
        assertEquals(0, uCheckSample.getState());
    }
    @Test
    public void getDateUCheck() {
        uCheckSample.setDate("test");
        assertEquals("test", uCheckSample.getDate());
    }
}