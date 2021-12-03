package usecases;

import entities.UCheckQuestion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UCheckQuestionCommandsTest {

    UCheckQuestion uCheckQuestionSample;
    UCheckQuestionCommands uCheckQuestionCommandsSample;

    @Before
    public void setUp() throws Exception {
        uCheckQuestionSample = new UCheckQuestion("title", "question");
        uCheckQuestionCommandsSample = new UCheckQuestionCommands();
    }

    @Test
    public void isAllSelected() {
        boolean test = uCheckQuestionCommandsSample.isAllSelected();
        assertFalse(String.valueOf(true), test);
    }
}