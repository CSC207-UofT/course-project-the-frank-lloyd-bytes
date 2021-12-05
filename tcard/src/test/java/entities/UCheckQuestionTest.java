package entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UCheckQuestionTest {

    UCheckQuestion testUCheckQuestion;
    @Before
    public void setUp(){
        testUCheckQuestion = new UCheckQuestion("title", "question");
    }

    @Test
    public void isSelectedFalse() {
        assertFalse(testUCheckQuestion.isSelected());
    }

    @Test
    public void setSelectedTrue() {
        testUCheckQuestion.setSelected(true);
        assertTrue(testUCheckQuestion.isSelected());
    }
    @Test
    public void setSelectedFalse() {
        testUCheckQuestion.setSelected(false);
        assertFalse(testUCheckQuestion.isSelected());
    }
    @Test
    public void getQuestion() {
        assertEquals("question", testUCheckQuestion.getQUESTION());
    }

    @Test
    public void isNoFalse() {
        assertFalse(testUCheckQuestion.isNo());
    }
    @Test
    public void isNoTrue() {
        testUCheckQuestion.setIsNo(true);
        assertTrue(testUCheckQuestion.isNo());
    }
    @Test
    public void setIsNo() {
        testUCheckQuestion.setIsNo(true);
        assertTrue(testUCheckQuestion.isNo());
    }

    @Test
    public void getTitle() {
        assertEquals("title", testUCheckQuestion.getTITLE());
    }
}