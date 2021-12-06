package usecases;

import entities.UCheckQuestion;

/**
 * This class interacts with UCheckQuestion entity.
 */
public class UCheckQuestionCommands {

    private final UCheckQuestion UCHECKQUESTION;

    public UCheckQuestionCommands(){
        UCHECKQUESTION = new UCheckQuestion();
    }

    /**
     * @return String title of UCheck title.
     */
    public String getTitle() {
        return UCHECKQUESTION.getTitle();
    }

    /**
     * @return String question of UCheck question.
     */
    public String getQuestion() {
        return UCHECKQUESTION.getQuestion();
    }

    /**
     * This method updates both title and question inside UCheckQuestion entity.
     * @param question Question entity.
     */
    public void populateUCheckQuestion(UCheckQuestion question){
        UCHECKQUESTION.setTitle(question.getTitle());
        UCHECKQUESTION.setQuestion(question.getQuestion());
    }
}
