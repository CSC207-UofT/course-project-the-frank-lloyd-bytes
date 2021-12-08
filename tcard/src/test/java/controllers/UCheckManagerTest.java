package controllers;

import entities.UCheckQuestion;
import entities.UCheckQuestions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import usecases.UCheckQuestionCommands;
import usecases.UCheckQuestionsCommands;

import static org.junit.Assert.*;

public class UCheckManagerTest {
    UCheckManager uCheckManager = new UCheckManager();
    UCheckQuestionsCommands uCheckQuestions = new UCheckQuestionsCommands();
    UCheckQuestionCommands uCheckQuestionCommands = new UCheckQuestionCommands();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getLayout() {
        assertEquals(2131427465, uCheckManager.getLayout());
    }

    @Test
    public void getState() {
        assertEquals(0, uCheckManager.getState());
    }

    @Test
    public void getDate() {
        assertNull(uCheckManager.getDate());
    }

    @Test
    public void getQuestions() {
        Assert.assertEquals(uCheckQuestions.getQuestions().get(0).getQuestion(), uCheckManager.getQuestions().get(0).getQuestion());
        Assert.assertEquals(uCheckQuestions.getQuestions().get(1).getQuestion(), uCheckManager.getQuestions().get(1).getQuestion());
        Assert.assertEquals(uCheckQuestions.getQuestions().get(2).getQuestion(), uCheckManager.getQuestions().get(2).getQuestion());
        Assert.assertEquals(uCheckQuestions.getQuestions().get(3).getQuestion(), uCheckManager.getQuestions().get(3).getQuestion());
        Assert.assertEquals(uCheckQuestions.getQuestions().get(4).getQuestion(), uCheckManager.getQuestions().get(4).getQuestion());
        Assert.assertEquals(uCheckQuestions.getQuestions().get(5).getQuestion(), uCheckManager.getQuestions().get(5).getQuestion());
        Assert.assertEquals(uCheckQuestions.getQuestions().get(6).getQuestion(), uCheckManager.getQuestions().get(6).getQuestion());
        Assert.assertEquals(uCheckQuestions.getQuestions().get(7).getQuestion(), uCheckManager.getQuestions().get(7).getQuestion());
        Assert.assertEquals(uCheckQuestions.getQuestions().get(0).getTitle(), uCheckManager.getQuestions().get(0).getTitle());
        Assert.assertEquals(uCheckQuestions.getQuestions().get(1).getTitle(), uCheckManager.getQuestions().get(1).getTitle());
        Assert.assertEquals(uCheckQuestions.getQuestions().get(2).getTitle(), uCheckManager.getQuestions().get(2).getTitle());
        Assert.assertEquals(uCheckQuestions.getQuestions().get(3).getTitle(), uCheckManager.getQuestions().get(3).getTitle());
        Assert.assertEquals(uCheckQuestions.getQuestions().get(4).getTitle(), uCheckManager.getQuestions().get(4).getTitle());
        Assert.assertEquals(uCheckQuestions.getQuestions().get(5).getTitle(), uCheckManager.getQuestions().get(5).getTitle());
        Assert.assertEquals(uCheckQuestions.getQuestions().get(6).getTitle(), uCheckManager.getQuestions().get(6).getTitle());
        Assert.assertEquals(uCheckQuestions.getQuestions().get(7).getTitle(), uCheckManager.getQuestions().get(7).getTitle());
    }

    @Test
    public void isAllSelected() {
        assertEquals(uCheckQuestions.isAllSelected(), uCheckManager.isAllSelected());
    }

    @Test
    public void isAllowed() {
        assertEquals(uCheckQuestions.isAllowed(), uCheckManager.isAllowed());
    }


    @Test
    public void getTitle() {
        assertEquals(uCheckQuestionCommands.getTitle(), uCheckManager.getTitle());
    }

    @Test
    public void getQuestion() {
        assertEquals(uCheckQuestionCommands.getQuestion(), uCheckManager.getQuestion());
    }
}