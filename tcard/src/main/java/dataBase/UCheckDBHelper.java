package dataBase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class UCheckDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "UCheck.db";
    public static final String TABLE_NAME = "ucheck";
    public static final String[] COL_LIST = {"UTROID", "STATUS"};

    /**
     * Create a UserDBHelper
     *
     * @param context the context of the class which calls this constructor
     */
    public UCheckDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    /**
     * Create a table when the database is created for the first time
     *
     * @param MyDB the database where we put the table.
     */
    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table " + TABLE_NAME + " (UTROID TEXT primary key, STATUS BOOLEAN) ");

    }

    /**
     * Delete the existing table
     *
     * @param MyDB is the database we are in
     * @param i    old version of the database
     * @param i1   new version of the database
     */

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(MyDB);
    }

    public Boolean insertData(String tCardNumber, String status) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_LIST[0], tCardNumber);
        contentValues.put(COL_LIST[1], status);
        long result = MyDB.insert(TABLE_NAME, null, contentValues); // return created user_id
        return result != -1;
    }
}
