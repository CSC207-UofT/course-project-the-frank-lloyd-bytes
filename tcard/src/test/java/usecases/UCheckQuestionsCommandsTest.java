package usecases;

import entities.UCheckQuestion;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UCheckQuestionsCommandsTest {

    UCheckQuestion uCheckQuestionSample;
    UCheckQuestionsCommands uCheckQuestionsCommandsSample;

    @Before
    public void setUp() {
        uCheckQuestionSample = new UCheckQuestion();
        uCheckQuestionsCommandsSample = new UCheckQuestionsCommands();
    }

    @Test
    public void testIsAllSelected1() {
        boolean test = uCheckQuestionsCommandsSample.isAllSelected();
        Assert.assertFalse(String.valueOf(true), test);
    }

    @Test
    public void testIsAllSelected2() {
        for (UCheckQuestion question : uCheckQuestionsCommandsSample.getQuestions()){
            uCheckQuestionsCommandsSample.updateSelection(true,
                    uCheckQuestionsCommandsSample.getQuestions().indexOf(question));
        }
        uCheckQuestionsCommandsSample.getQuestions().get(0).setIsNo(false);
        boolean test = uCheckQuestionsCommandsSample.isAllSelected();
        Assert.assertTrue(String.valueOf(true), test);
    }

    @Test
    public void testIsAllowed1() {
        int i = 0;
        if (uCheckQuestionsCommandsSample.isAllowed()){
            i = 1;
        }
        Assert.assertEquals(0, i);
    }

    @Test
    public void testIsAllowed2() {
        int i = 0;
        uCheckQuestionsCommandsSample.updateSelection(true, 0);
        if (uCheckQuestionsCommandsSample.isAllowed()){
            i = 1;
        }
        Assert.assertEquals(0, i);
    }

    @After
    public void tearDown() {
        uCheckQuestionSample = null;
        uCheckQuestionsCommandsSample = null;
    }
}