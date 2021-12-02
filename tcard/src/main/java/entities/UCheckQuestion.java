package entities;

/**
 * This class is a entity of the text display for UCheckQuestionnaireActivity. Gives correct format view model for Listview.
 * The question structure matches XML file structure in activity_ucheck_questionnaire.xml and the adapter will apply a UCheckQuestion object into it.
 * This class also contains data for the questionnaire and UI interaction state.
 */
public class UCheckQuestion {

    private final String title;
    private final String question;
    private boolean isSelected;
    private boolean isNo;

    /**
     * @param title is the title of String to insert.
     * @param question is the question of String to insert.
     */
    public UCheckQuestion(String title, String question) {
        this.title = title;
        this.question = question;
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
}
