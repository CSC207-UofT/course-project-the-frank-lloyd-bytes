package usecases;


import activities.R;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UCheckCommandsTest {

    UCheckCommands uCheckCommandsSample;

    @Before
    public void setUp(){
        uCheckCommandsSample = new UCheckCommands();
    }

    @Test
    public void testGetStateTrue() {
        uCheckCommandsSample.getUCHECK().setState(1);
        Assert.assertEquals(1, uCheckCommandsSample.getState());
    }

    @Test
    public void testGetStateFalse() {
        uCheckCommandsSample.getUCHECK().setState(2);
        Assert.assertEquals(2, uCheckCommandsSample.getState());
    }

    @Test
    public void testGetStateNeutral() {
        Assert.assertEquals(0, uCheckCommandsSample.getState());
    }

    @Test
    public void testGetDateUCheck() {
        uCheckCommandsSample.getUCHECK().setDate("test");
        Assert.assertEquals("test", uCheckCommandsSample.getDate());
    }


    @Test
    public void testGetLayout(){
        uCheckCommandsSample.getUCHECK().setState(1);
        Assert.assertEquals(R.layout.ucheck_green_layout_view, uCheckCommandsSample.getLayout());
        uCheckCommandsSample.getUCHECK().setState(2);
        Assert.assertEquals(R.layout.ucheck_red_layout_view, uCheckCommandsSample.getLayout());
        uCheckCommandsSample.getUCHECK().setState(0);
        Assert.assertEquals(R.layout.ucheck_grey_layout_view, uCheckCommandsSample.getLayout());
    }


}