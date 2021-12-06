package controllers;

import android.content.Context;
import entities.UCheckQuestion;
import usecases.UCheckCommands;
import usecases.UCheckQuestionCommands;
import usecases.UCheckQuestionsCommands;
import java.util.List;

/**
 * This is controller interacts with 4 activities and the following 3 use cases.
 */
public class UCheckManager {

    private final UCheckQuestionCommands UCHECK_QUESTION_COMMANDS;
    private final UCheckQuestionsCommands UCHECK_QUESTIONS_COMMANDS;
    private final UCheckCommands UCHECK_COMMANDS;

    public UCheckManager(){
        UCHECK_QUESTION_COMMANDS = new UCheckQuestionCommands();
        UCHECK_QUESTIONS_COMMANDS = new UCheckQuestionsCommands();
        UCHECK_COMMANDS = new UCheckCommands();
    }

    /**
     * This method sets the result from onActivityResult in UCheckScrollingActivity. The results are determined by USER completing
     * the questionnaire.
     * @param context context is from the activity location.
     * @param userId String representation of USER utorid.
     * @param state Integer result state.
     */
    public void setResult(Context context, String userId, int state) {
        UCHECK_COMMANDS.setResult(context, userId, state);
    }

    /**
     * This method updates UCheck object with correct date and status when a USER completes UCheck in UCheckScrollingActivity. It also updates data in Shared preferences.
     * @param context context is from the activity location.
     * @param userId String USER userid completing questionnaire.
     */
    public void populateResult(Context context, String userId) {
        UCHECK_COMMANDS.populateResult(context, userId);
    }

    /**
     * This method returns the state of UCheck with corresponds to a layout display in UCheckScrollingActivity for the UI.
     * Method calls getState() in function that gets UCheck state.
     * @return integer of correct layout for UCheckScrollingActivity.  //check isExpired() true: return grey, false: red/greenUCheck here if valid then return grey one if it's been 24hr
     */
    public int getLayout() {
        return UCHECK_COMMANDS.getLayout();
    }

    /**
     * @return integer of current state which determines the correct layout display of UCheck. //add check if UCheck expired here or not, return 0; otherwise.
     */
    public int getState() {
        return UCHECK_COMMANDS.getState();
    }

    /**
     * @return String date representation of date and is used for opening dateDate() method that initiates time (today's date).
     */
    public String getDate() {
        return UCHECK_COMMANDS.getDate();
    }

    /**
     * @return a list of UCheckQuestions.
     */
    public List<UCheckQuestion> getQuestions() {
        return UCHECK_QUESTIONS_COMMANDS.getQuestions();
    }

    /**
     * This method returns boolean based on whether all questions have been answered.
     * @return boolean of status of questions.
     */
    public boolean isAllSelected() {
        return UCHECK_QUESTIONS_COMMANDS.isAllSelected();
    }

    /**
     * This method check if USER is allowed to enter campus or not based off of UCheck self-assessment.
     * @return boolean of logic of UCheckQuestionnaireActivity.
     */
    public boolean isAllowed() {
        return UCHECK_QUESTIONS_COMMANDS.isAllowed();
    }


    /** This method interacts with the interface and determines which question is being selected in UI. If a question is selected, it will update
     * and allows to know the question is stored in a list. When USER selects yes or no, we update that position or index selected.
     * @param isNoVar  boolean value to pass in interface whether an option has been selection in UI.
     * @param position integer position of where in UI the selection has been made.
     */
    public void updateSelection(boolean isNoVar, int position) {
        UCHECK_QUESTIONS_COMMANDS.updateSelection(isNoVar, position);
    }

    /**
     * This method updates both title and question inside UCheckQuestion entity.
     * @param question Question entity.
     */
    public void populateUCheckQuestion(UCheckQuestion question) {
        UCHECK_QUESTION_COMMANDS.populateUCheckQuestion(question);
    }

    /**
     * @return String title of UCheck title.
     */
    public String getTitle() {
        return UCHECK_QUESTION_COMMANDS.getTitle();
    }

    /**
     * @return String question of UCheck question.
     */
    public String getQuestion() {
        return UCHECK_QUESTION_COMMANDS.getQuestion();
    }
}
