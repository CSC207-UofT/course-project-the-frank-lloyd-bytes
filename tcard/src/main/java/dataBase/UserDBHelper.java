package dataBase;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import usecases.UserReadWriter;

import java.util.ArrayList;
import java.util.List;


/*
  A User Database Helper class that set up, add, edit, delete the database.
 */
public class UserDBHelper extends SQLiteOpenHelper implements UserReadWriter {
    public static final String DB_NAME = "User.db";
    public static final String TABLE_NAME = "users";
    public static final String[] COL_LIST = {"UTROID", "PASSWORD", "LEGAL_NAME_F", "LEGAL_NAME_L", "STATUS",
            "ID_NUMBER", "EMAIL", "YEAR_IN_UOFT", "BELONGTO", "PICTURE"};


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
     * @param myDB the database where we put the table.
     */
    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table " + TABLE_NAME + " (UTROID TEXT primary key,PASSWORD TEXT,LEGAL_NAME_F TEXT," +
                "LEGAL_NAME_L TEXT ,STATUS TEXT," +
                "ID_NUMBER TEXT,EMAIL TEXT,YEAR_IN_UOFT TEXT,BELONGTO TEXT, PICTURE TEXT)");

    }

    /**
     * Delete the existing table
     *
     * @param myDB is the database we are in
     * @param i    old version of the database
     * @param i1   new version of the database
     */
    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(myDB);
    }

    /**
     * Check out the whether the user exists in the database
     * @param utorID is the id you want to check
     * @return true if the user exists and false if not
     */
    @Override
    public Boolean checkUtorID(String utorID) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = myDB.rawQuery("Select * from users where UTROID = ?", new String[]{utorID});
        return cursor.getCount() > 0;
    }

    /**
     * check out whether the user enter the correct username and password
     * @param utorID is the user's utroid
     * @param password is the utroid's corresponding
     * @return true if the user's login successfully, false if not
     */
    @Override
    public Boolean checkUtorIDPassword(String utorID, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = myDB.rawQuery("Select * from users where UTROID = ? and PASSWORD = ?",
                new String[]{utorID, password});
        return cursor.getCount() > 0;
    }

    /**
     * Get a copy of the information of the user with utroid.
     * @param utorID the id of the user
     * @return an ArrayList of user's information
     */
    @Override
    public List<String> getInfo(String utorID){
        SQLiteDatabase myDB = this.getWritableDatabase();
        List<String> info = new ArrayList<>();
        @SuppressLint("Recycle") Cursor data = myDB.rawQuery("Select * from " + TABLE_NAME + " where UTROID = ? ", new String[]{utorID});
        for(data.moveToFirst(); !data.isAfterLast(); data.moveToNext()) {
            // The Cursor is now set to the right position
            for (int i=0; i<COL_LIST.length;i++){
            info.add(data.getString(i));
            }
        }
        return info;
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
     * @return true if the insert success, false if not
     */
    @Override
    public Boolean insertData(String username, String password, String firstName, String lastName, String email,
                              String department, String status, String tCardNumber, String year, String pic) {
        SQLiteDatabase myDB = this.getWritableDatabase();
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
        contentValues.put(COL_LIST[9], pic);
        long result = myDB.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    /**
     * update the password for the user in the database
     * @param data is the user's info
     */
    @Override
    public void updatePassword(List<String> data){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for (int i=0; i<data.size();i++){
            contentValues.put(COL_LIST[i], data.get(i));
        }
        long result = myDB.update(TABLE_NAME, contentValues," UTROID=?", new String[] {data.get(0)});

    }

    public void updatePicture(List<String> data){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for (int i=0; i<data.size();i++){
            contentValues.put(COL_LIST[i], data.get(i));
        }
        long result = myDB.update(TABLE_NAME, contentValues," UTROID=?", new String[] {data.get(0)});

    }

}

