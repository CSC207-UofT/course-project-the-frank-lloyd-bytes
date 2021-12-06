package usecasesTest;

import entities.UCheckQuestion;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import usecases.UCheckQuestionsCommands;

public class UCheckQuestionsCommandsTest {

    UCheckQuestion uCheckQuestionSample;
    UCheckQuestionsCommands uCheckQuestionsCommandsSample;

    @Before
    public void setUp() {
        uCheckQuestionSample = new UCheckQuestion();
        uCheckQuestionsCommandsSample = new UCheckQuestionsCommands();
    }

    @Test
    public void testIsAllSelected() {
        boolean test = uCheckQuestionsCommandsSample.isAllSelected();
        Assert.assertFalse(String.valueOf(true), test);
    }

    @After
    public void tearDown() {
        uCheckQuestionSample = null;
        uCheckQuestionsCommandsSample = null;
    }
}