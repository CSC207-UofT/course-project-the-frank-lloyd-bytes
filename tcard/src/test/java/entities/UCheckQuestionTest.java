package entitiesTest;

import entities.UCheckQuestion;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UCheckQuestionTest {

    UCheckQuestion testUCheckQuestion;

    @Before
    public void setUp(){
        testUCheckQuestion = new UCheckQuestion();
        testUCheckQuestion.setTitle("title");
        testUCheckQuestion.setQuestion("question");
    }

    @Test
    public void testIsSelectedFalse() {
        Assert.assertFalse(testUCheckQuestion.isSelected());
    }

    @Test
    public void testSetSelectedTrue() {
        testUCheckQuestion.setSelected(true);
        Assert.assertTrue(testUCheckQuestion.isSelected());
    }

    @Test
    public void testSetSelectedFalse() {
        testUCheckQuestion.setSelected(false);
        Assert.assertFalse(testUCheckQuestion.isSelected());
    }

    @Test
    public void testGetQuestion() {
        Assert.assertEquals("question", testUCheckQuestion.getQuestion());
    }

    @Test
    public void testIsNoFalse() {
        Assert.assertFalse(testUCheckQuestion.isNo());
    }

    @Test
    public void testIsNoTrue() {
        testUCheckQuestion.setIsNo(true);
        Assert.assertTrue(testUCheckQuestion.isNo());
    }

    @Test
    public void testSetIsNo() {
        testUCheckQuestion.setIsNo(true);
        Assert.assertTrue(testUCheckQuestion.isNo());
    }

    @Test
    public void testSetIsNoFalse() {
        testUCheckQuestion.setIsNo(false);
        Assert.assertFalse(testUCheckQuestion.isNo());
    }

    @Test
    public void testGetTitle() {
        Assert.assertEquals("title", testUCheckQuestion.getTitle());
    }

    @Test
    public void testSetTitle() {
        testUCheckQuestion.setTitle("Dr. Phil");
        Assert.assertEquals("Dr. Phil", testUCheckQuestion.getTitle());
    }

    @Test
    public void testSetQuestion() {
        testUCheckQuestion.setTitle("You are the father");
        Assert.assertEquals("You are the father", testUCheckQuestion.getTitle());
    }

    @After
    public void tearDown() {
        testUCheckQuestion = null;
    }
}