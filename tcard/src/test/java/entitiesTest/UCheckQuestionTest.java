package entitiesTest;

import entities.UCheckQuestion;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UCheckQuestionTest {

    UCheckQuestion testUCheckQuestion;

    @Before
    public void setUp(){
        testUCheckQuestion = new UCheckQuestion();
        testUCheckQuestion.setTitle("title");
        testUCheckQuestion.setQuestion("question");
    }

    @Test
    public void isSelectedFalse() {
        Assert.assertFalse(testUCheckQuestion.isSelected());
    }

    @Test
    public void setSelectedTrue() {
        testUCheckQuestion.setSelected(true);
        Assert.assertTrue(testUCheckQuestion.isSelected());
    }

    @Test
    public void setSelectedFalse() {
        testUCheckQuestion.setSelected(false);
        Assert.assertFalse(testUCheckQuestion.isSelected());
    }

    @Test
    public void getQuestion() {
        Assert.assertEquals("question", testUCheckQuestion.getQuestion());
    }

    @Test
    public void isNoFalse() {
        Assert.assertFalse(testUCheckQuestion.isNo());
    }

    @Test
    public void isNoTrue() {
        testUCheckQuestion.setIsNo(true);
        Assert.assertTrue(testUCheckQuestion.isNo());
    }

    @Test
    public void setIsNo() {
        testUCheckQuestion.setIsNo(true);
        Assert.assertTrue(testUCheckQuestion.isNo());
    }

    @Test
    public void setIsNoFalse() {
        testUCheckQuestion.setIsNo(false);
        Assert.assertFalse(testUCheckQuestion.isNo());
    }

    @Test
    public void getTitle() {
        Assert.assertEquals("title", testUCheckQuestion.getTitle());
    }

    @After
    public void tearDown() {
        testUCheckQuestion = null;
    }
}