package entities;

/**
 * This class is an entity stores the state of UCheck result completed by USER in UCheckQuestionnaireActivity.This class takes in one UCheckQuestion from UCheckQuestions.
 * The question structure matches XML file structure in activity_ucheck_questionnaire.xml and the adapter will apply a UCheckQuestion object into it.
 * This class also contains data for the questionnaire and UI interaction state that USER interacts with in UI.
 */
public class UCheckQuestion {

    private  String title;
    private  String question;
    private boolean isSelected;
    private boolean isNo;

    public UCheckQuestion() {}

    /**
     * @return boolean if it's selected or not in interface.
     */
    public boolean isSelected() {
        return isSelected;
    }

    /**
     * @param selected boolean value if it's selected, we mutate the variable.
     */
    public void setSelected(boolean selected) {
        isSelected = selected;
    }
    /**
     * @return String question for front-end.
     */
    public String getQuestion(){
        return this.question;
    }

    /**
     * Return if it's no or yes for interface.
     * @return boolean
     */
    public boolean isNo(){
        return this.isNo;
    }

    /**
     * @param value boolean value if set to no in Interface
     */
    public void setIsNo(boolean value){
        this.isNo = value;
    }

    /**
     * @return String title for front-end.
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * @param title String title of the Question.
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * @param question String question of Question.
     */
    public void setQuestion(String question){
        this.question = question;
    }
}
