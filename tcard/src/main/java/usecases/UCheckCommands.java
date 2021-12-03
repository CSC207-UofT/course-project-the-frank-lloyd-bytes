package usecases;

import android.content.Context;
import activities.R;
import entities.UCheck;
import java.text.SimpleDateFormat;
import java.util.Locale;
import entities.UCheckResults;

public class UCheckCommands {

    private final UCheck UCHECK;
    private final UCheckResults UCHECKRESULTS;

    /**
     * Initializes UCheckResults & UCheck object for interaction between UI and Entities.
     */
    public UCheckCommands(){
        UCHECKRESULTS = new UCheckResults();
        UCHECK = new UCheck();
    }

    /**
     * @return integer of current state which determines the correct layout display of UCheck.
     */
    public int getState(){
        return UCHECK.getState();
    }

    /**
     * @return String date representation of date and is used for opening dateDate() method that initiates time (today's date).
     */
    public String getDate() {
        return UCHECK.getDate();
    }

    /**
     * This method sets the result from onActivityResult in UCheckScrollingActivity. The results are determined by USER completing
     * the questionnaire.
     * @param context context is from the activity location.
     * @param userId String representation of USER utorid.
     * @param state Integer result state.
     */
    public void setResult(Context context, String userId, int state){
        UCHECKRESULTS.setResults(context,userId, state);
    }

    /**
     * This method updates UCheck object with correct date and status when a USER completes UCheck in UCheckScrollingActivity. It also updates data in Shared preferences.
     * @param context context is from the activity location.
     * @param userId String USER userid completing questionnaire.
     */
    public void populateResult(Context context, String userId) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(userId, Context.MODE_PRIVATE);
        String date = sharedPreferences.getString("date",new SimpleDateFormat("MMM d, yyyy hh:mm aaa", Locale.ENGLISH).format(new java.util.Date()));
        int status = sharedPreferences.getInt("status",0);
        UCHECK.setState(status);
        UCHECK.setDate(date);
    }

    /**
     * This method returns the state of UCheck with corresponds to a layout display in UCheckScrollingActivity for the UI.
     * Method calls getState() in function that gets UCheck state.
     * @return integer of correct layout for UCheckScrollingActivity.
     */
    public int getLayout() {

        int layout;
        if (getState()  == 1) {
            layout = R.layout.ucheck_green_layout_view;
        }
        else
        if (getState()  == 2) {
            layout = R.layout.ucheck_red_layout_view;
        }
        else
            layout = R.layout.ucheck_grey_layout_view;
        return layout;
    }
}
