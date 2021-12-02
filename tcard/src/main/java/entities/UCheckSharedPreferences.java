package entities;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 */
public class UCheckSharedPreferences {

    public static void setResult(Context context,String userId,int state) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(userId, Context.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("status",state);
        editor.putString("date",new SimpleDateFormat("MMM d, yyyy hh:mm aaa", Locale.ENGLISH).format(new java.util.Date()));
        editor.apply();
    }

    public static UCheckResult getResult(Context context, String userId) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(userId, Context.MODE_PRIVATE);
        UCheckResult myUCheckResult = new UCheckResult();
        String date = sharedPreferences.getString("date",new SimpleDateFormat("MMM d, yyyy hh:mm aaa", Locale.ENGLISH).format(new java.util.Date()));
        int status = sharedPreferences.getInt("status",0);
        myUCheckResult.setState(status);
        myUCheckResult.setDate(date);
        return myUCheckResult;
    }
}
