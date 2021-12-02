package dataBase;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;


/*
  A User Database Helper class that set up, add, edit, delete the database.
 */
public class UserDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "User.db";
    public static final String TABLE_NAME = "users";
    public static final String[] COL_LIST = {"UTROID", "PASSWORD", "LEGAL_NAME_F", "LEGAL_NAME_L", "STATUS",
            "ID_NUMBER", "EMAIL", "YEAR_IN_UOFT", "BELONGTO"};


    /**
     * Create a UserDBHelper
     *
     * @param context the context of the class which calls this constructor
     */
    public UserDBHelper(Context context) {
        super(context, DB_NAME, null, 2);
    }


    /**
     * Create a table when the database is created for the first time
     *
     * @param MyDB the database where we put the table.
     */
    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table " + TABLE_NAME + " (UTROID TEXT primary key,PASSWORD TEXT,LEGAL_NAME_F TEXT," +
                "LEGAL_NAME_L TEXT ,STATUS TEXT," +
                "ID_NUMBER TEXT,EMAIL TEXT,YEAR_IN_UOFT TEXT,BELONGTO TEXT)");

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

    /**
     * Check out the whether the user exists in the database
     * @param utroid is the id you want to check
     * @return true if the user exists and false if not
     */
    public Boolean checkutorid(String utroid) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = MyDB.rawQuery("Select * from users where UTROID = ?", new String[]{utroid});
        return cursor.getCount() > 0;
    }

    /**
     * check out whether the user enter the correct username and password
     * @param utroid is the user's utroid
     * @param password is the utroid's corresponding
     * @return true if the user's login successfully, false if not
     */
    public Boolean checkutroidpassword(String utroid, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = MyDB.rawQuery("Select * from users where UTROID = ? and PASSWORD = ?",
                new String[]{utroid, password});
        return cursor.getCount() > 0;
    }

    /**
     * Get a copy of the information of the user with utroid.
     * @param utroid the id of the user
     * @return an ArrayList of user's information
     */
    public ArrayList<String> getInfo(String utroid){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ArrayList<String> Info = new ArrayList<>();
        @SuppressLint("Recycle") Cursor data = MyDB.rawQuery("Select * from " + TABLE_NAME + " where UTROID = ? ", new String[]{utroid});
        for(data.moveToFirst(); !data.isAfterLast(); data.moveToNext()) {
            // The Cursor is now set to the right position
            for (int i=0; i<COL_LIST.length;i++){
            Info.add(data.getString(i));
            }
        }
        return Info;
    }

    /**
     * Insert the data to the database
     * @param username is the user's id
     * @param password is the user's password
     * @param firstName is the user's first name
     * @param lastName is the user's last name
     * @param email is the user's email
     * @param department is the user's department
     * @param status is the user's status
     * @param tCardNumber is the user's Tcard number
     * @param year is the years that user in UofT
     * @return ture if the insert success, false if not
     */
    public Boolean insertData(String username, String password, String firstName, String lastName, String email,
                              String department, String status, String tCardNumber, String year, String photo) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_LIST[0], username);
        contentValues.put(COL_LIST[1], password);
        contentValues.put(COL_LIST[2], firstName);
        contentValues.put(COL_LIST[3], lastName);
        contentValues.put(COL_LIST[4], status);
        contentValues.put(COL_LIST[5], tCardNumber);
        contentValues.put(COL_LIST[6], email);
        contentValues.put(COL_LIST[7], year);
        contentValues.put(COL_LIST[8],department);
        long result = MyDB.insert(TABLE_NAME, null, contentValues); // return created user_id
        return result != -1;
    }

    /**
     * update the password for the user in the database
     * @param data is the user's info
     * @return true if the update work, false if not
     */
    public Boolean updataPassword(ArrayList<String> data){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for (int i=0; i<data.size();i++){
            contentValues.put(COL_LIST[i], data.get(i));
        }
        long result = MyDB.update(TABLE_NAME, contentValues," UTROID=?", new String[] {data.get(0)});
        return result != -1;
    }

}

