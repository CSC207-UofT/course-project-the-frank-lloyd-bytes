package usecases;

import entities.UCheckQuestion;
import entities.UCheckQuestions;
import java.util.List;

public class UCheckQuestionCommands {

    private final List<UCheckQuestion> questionList;

    /**
     * Initiates a questionList with UCheckQuestions for UI.
     */
    public UCheckQuestionCommands(){
        questionList = UCheckQuestions.getQuestions();
    }

    /**
     * This method returns boolean based on whether all questions have been answered.
     * @return boolean of status of questions.
     */
    public  boolean  isAllSelected() {
        for(UCheckQuestion Question : getQuestions()) {
            if(!Question.isSelected()) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return a list of UCheckQuestions.
     */
    public  List<UCheckQuestion> getQuestions() {
        return questionList;
    }

    /**
     * This method check if USER is allowed to enter campus or not based off of UCheck self-assessment.
     * @return boolean of logic of UCheckQuestionnaireActivity.
     */
    public boolean isAllowed() {

        boolean isAllowed = true;
        if(getQuestions().get(0).isNo()) {
            isAllowed = false;
        }
        else {
            for(int i = 1; i < getQuestions().size(); i++) {
                if(!getQuestions().get(i).isNo()) {
                    isAllowed = false;
                    break;
                }
            }
        }
        return isAllowed;
    }

    /** This method interacts with the interface and determines which question is being selected in UI. If a question is selected, it will update
     * and allows to know the question is stored in a list. When USER selects yes or no, we update that position or index selected.
     * @param isNoVar  boolean value to pass in interface whether an option has been selection in UI.
     * @param position integer position of where in UI the selection has been made.
     */
    public void updateSelection(boolean isNoVar, int position) {
        UCheckQuestion UCheckQuestion = getQuestions().get(position);
        UCheckQuestion.setSelected(true);
        UCheckQuestion.setIsNo(isNoVar);
        getQuestions().set(position, UCheckQuestion);
    }
}
