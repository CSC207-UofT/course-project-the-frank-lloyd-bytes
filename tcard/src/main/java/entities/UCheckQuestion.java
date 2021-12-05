package entities;

/**
 * This class is an entity stores the state of UCheck result completed by USER in UCheckQuestionnaireActivity.This class takes in one UCheckQuestion from UCheckQuestions.
 * The QUESTION structure matches XML file structure in activity_ucheck_questionnaire.xml and the adapter will apply a UCheckQuestion object into it.
 * This class also contains data for the questionnaire and UI interaction state that USER interacts with in UI.
 */
public class UCheckQuestion {

    private final String TITLE;
    private final String QUESTION;
    private boolean isSelected;
    private boolean isNo;

    /**
     * @param title is the TITLE of String to insert.
     * @param QUESTION is the QUESTION of String to insert.
     */
    public UCheckQuestion(String title, String QUESTION) {
        this.TITLE = title;
        this.QUESTION = QUESTION;
    }

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
     * @return String QUESTION for front-end.
     */
    public String getQUESTION(){
        return this.QUESTION;
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
     * @return String TITLE for front-end.
     */
    public String getTITLE(){
        return this.TITLE;
    }
}
