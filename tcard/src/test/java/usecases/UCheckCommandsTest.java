package usecases;

import entities.UCheck;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UCheckCommandsTest {
    private UCheckCommands sampleUcheckCommands;

    @Before
    public void setUp() throws Exception {
        sampleUcheckCommands = new UCheckCommands("1003757936");
    }

    @Test
    public void setUCheck() {
        sampleUcheckCommands.setUCheck(true);
    }

    @Test
    public void getUCheckTime() {
    }

    @Test
    public void ucheckResponses() {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void displayUCheck() {
    }

    @Test
    public void displayFailedUCheck() {
    }
}