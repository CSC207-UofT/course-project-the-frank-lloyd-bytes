package usecases;

import entities.UCheckQuestion;
import junit.framework.TestCase;

public class UCheckQuestionCommandsTest extends TestCase {
    UCheckQuestion q1 = new UCheckQuestion();
    UCheckQuestion q2 = new UCheckQuestion();
    UCheckQuestionCommands q1Commands = new UCheckQuestionCommands();
    public void setUp() throws Exception {
        super.setUp();
        q1.setTitle("title");
        q1.setQuestion("question");
        q2.setTitle("ME");
        q2.setQuestion("who am I");
        q1Commands.populateUCheckQuestion(q1);
    }

    public void testGetTitle() {
        assertEquals(q1.getTitle(), q1Commands.getTitle());
    }

    public void testGetQuestion() {
        assertEquals(q1.getQuestion(), q1Commands.getQuestion());
    }

    public void testPopulateUCheckQuestion() {
        q1Commands.populateUCheckQuestion(q2);
        assertEquals(q2.getTitle(), q1Commands.getTitle());
        assertEquals(q2.getQuestion(), q1Commands.getQuestion());
    }
}