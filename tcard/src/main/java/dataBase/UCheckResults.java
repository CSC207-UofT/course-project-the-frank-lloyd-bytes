package dataBase;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * This Entity store the results from UI UCheckScrollingActivity in onActivityResult.
 */
public class UCheckResults{

    public UCheckResults(){}

    /**
     *  Updates data in shared preference once USER completes UCheckQuestionnaire self-assessment.
     * @param context from where the activity is calling.
     * @param userId String userid
     * @param state integer of the state once the UCheckQuestionnaire self-assessment is completed.
     */
    public void setResults(Context context, String userId, int state){
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(userId, Context.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("status", state);
        editor.putString("date", new SimpleDateFormat("MMM d, yyyy hh:mm aaa", Locale.ENGLISH).format(new java.util.Date()));
        editor.apply();
    }
}

