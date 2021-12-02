package models;

/**
 * This class is a model of the text display for UCheckQuestionnaireActivity. Gives correct format view model for Listview.
 * The question structure matches XML file structure in activity_ucheck_questionnaire.xml and the adapter will apply a Question object into it.
 */
public class Question {

    private final String title;
    private final String question;

    /**
     * @param title is the title of String to insert.
     * @param question is the question of String to insert.
     */
    public Question(String title, String question) {
        this.title = title;
        this.question = question;
    }

    public boolean isNo;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isSelected;

    /**
     * @return String question for front-end.
     */
    public String getQuestion(){
        return this.question;
    }

    /**
     * @return String title for front-end.
     */
    public String getTitle(){
        return this.title;
    }
}
